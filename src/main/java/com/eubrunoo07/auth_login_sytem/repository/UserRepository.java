package com.eubrunoo07.auth_login_sytem.repository;

import com.eubrunoo07.auth_login_sytem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
    User findByEmail(String email);

    boolean existsByPassword(String password);
}
