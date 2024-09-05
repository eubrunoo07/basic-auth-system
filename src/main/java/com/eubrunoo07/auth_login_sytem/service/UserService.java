package com.eubrunoo07.auth_login_sytem.service;

import com.eubrunoo07.auth_login_sytem.dto.UserLoginRequestDTO;
import com.eubrunoo07.auth_login_sytem.dto.UserRequestDTO;
import com.eubrunoo07.auth_login_sytem.dto.UserResponseDTO;
import com.eubrunoo07.auth_login_sytem.entity.User;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO dto);
}
