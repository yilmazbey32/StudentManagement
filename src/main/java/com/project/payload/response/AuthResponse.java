package com.project.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)// gelen bilgiler boş gelmesin !!! boşsa gelmesin demek !!!
// tokende geliyor
public class AuthResponse {
    private String username;
    private String ssn;
    private String role;
    private String token; //!!!!!!!!!!!!!!!!!!
    private String name;

}
