package com.project.service;

import com.project.entity.concretes.user.User;
import com.project.exception.BadRequestException;
import com.project.payload.mappers.UserMapper;
import com.project.payload.messages.ErrorMessages;
import com.project.payload.request.LoginRequest;
import com.project.payload.request.business.UpdatePasswordRequest;
import com.project.payload.response.AuthResponse;
import com.project.payload.response.UserResponse;
import com.project.repository.UserRepository;
import com.project.security.jwt.JwtUtils;
import com.project.security.service.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncode;

    public ResponseEntity<AuthResponse> authenticateUser(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        //!!! authenticationManager uzerinden kullanici valide ediliyor
        Authentication authentication =
              authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//authentication nesnesine ulaşmak için "UsernamePasswordAuthenticationToken" ismindeki clasın
        // instancesini yolluyoruz


        //!!! valide edilen kullanici context e atiliyor
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //!!! JWT token olusturuluyor
        String  token = "Bearer " + jwtUtils.generateJwtToken(authentication);

        // !!! Response nesnesi olusturuluyor
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        // UserDetailste role grantedauth tibinde
        //!!! grantedAuth --> Role ( String )
        Set<String> roles = userDetails.getAuthorities()
                .stream() // Stream<GrantedAuth>
                .map(GrantedAuthority::getAuthority) // Stream<String>
                .collect(Collectors.toSet());

        Optional<String> role = roles.stream().findFirst();

        AuthResponse.AuthResponseBuilder authResponse = AuthResponse.builder();
        authResponse.username(userDetails.getUsername());
        authResponse.token(token.substring(7));
        authResponse.name(userDetails.getName());
        authResponse.ssn(userDetails.getSsn());
// eğer role bilgisi null değil ise AuthResponse nesnesi içine setleniyor
        role.ifPresent(authResponse::role);

        return ResponseEntity.ok(authResponse.build());

    }


    public UserResponse findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        //!!! Pojo --> DTO
        return userMapper.mapUserToUserResponse(user);
    }
    public void updatePassword(UpdatePasswordRequest updatePasswordRequest, HttpServletRequest request) {

        String userName = (String) request.getAttribute("username");
        User user = userRepository.findByUsername(userName);

        // !!! Built_IN kontrolu
        if(Boolean.TRUE.equals(user.getBuilt_in())){
            throw new BadRequestException(ErrorMessages.NOT_PERMITTED_METHOD_MESSAGE);
        }
        //!!!  Eski şifre bilgisi doğrumu
        if (!passwordEncode.matches(updatePasswordRequest.getNewPassword(),user.getPassword())){
            throw new BadRequestException(ErrorMessages.PASSWORD_NOT_MATCHED);
        }

        //!!! Yeni şifre encode edilecek
        String hashedPassord=passwordEncode.encode(updatePasswordRequest.getNewPassword());


    }
}
