package com.project.repository;

import com.project.entity.concretes.user.User;
import com.project.entity.enums.RoleType;
import com.project.payload.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



    //!!! alttaki ve ustteki ayni isi yapiyor
    User findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsBySsn(String ssn);

    boolean existsByPhoneNumber(String phone);

    boolean existsByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.userRole.roleName = :roleName") // JPQL
    Page<User> findByUserByRole(String roleName, Pageable pageable);

    List<User> getUserByNameContaining(String name);

    @Query(value = "SELECT COUNT(u) FROM User u WHERE u.userRole.roleType = ?1")
    long countAdmin(RoleType roleType);

    User findByUsernameEquals(String username);

    List<User> findByAdvisorTeacherId(Long id);
@Query("Select u FROM User u WHERE u.isAdvisor=?1")
    List<User> findAllByAdvisor(Boolean aTrue);
    @Query(value = "SELECT (count (u)>0) FROM User u WHERE u.userRole.roleType = ?1")
    boolean findStudent(RoleType roleType);
@Query(value = "SELECT max (u.studentNUmber) FROM User u")
    int getMaxStudentNumber();
}