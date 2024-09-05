package com.eubrunoo07.auth_login_sytem.service;

import com.eubrunoo07.auth_login_sytem.dto.UserLoginRequestDTO;
import com.eubrunoo07.auth_login_sytem.dto.UserRequestDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {
    String genToken(UserLoginRequestDTO dto);
    String validateToken(String token);
}
