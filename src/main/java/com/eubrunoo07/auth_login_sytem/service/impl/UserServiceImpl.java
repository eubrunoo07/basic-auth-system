package com.eubrunoo07.auth_login_sytem.service.impl;

import com.eubrunoo07.auth_login_sytem.dto.UserLoginRequestDTO;
import com.eubrunoo07.auth_login_sytem.dto.UserRequestDTO;
import com.eubrunoo07.auth_login_sytem.dto.UserResponseDTO;
import com.eubrunoo07.auth_login_sytem.entity.User;
import com.eubrunoo07.auth_login_sytem.enums.UserRole;
import com.eubrunoo07.auth_login_sytem.repository.UserRepository;
import com.eubrunoo07.auth_login_sytem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDTO createUser(UserRequestDTO dto) {
        User user;
        user = validateUserRequestData(dto);
        user.setPassword(encodePassword(user.getPassword()));
        User savedUser = userRepository.save(user);
        return new UserResponseDTO(savedUser.getUsername(), savedUser.getEmail(), savedUser.getRole());
    }

    private String encodePassword(String password){
        return passwordEncoder.encode(password);
    }

    private User validateUserRequestData(UserRequestDTO dto) {
        User user;
        String REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-={}\\[\\]:;\"'<>,.?/]).{8,}$";

        if(dto.password().matches(REGEX_PASSWORD)){
            if(userRepository.existsByUsername(dto.username())){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already in use");
            }
            else if(userRepository.existsByEmail(dto.email())){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already in use");
            }
            else{
                user = new User(dto.username(), dto.email(), dto.password(), UserRole.valueOf(dto.role()));
            }
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password format is invalid");
        }
        return user;
    }
}
