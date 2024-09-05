package com.eubrunoo07.auth_login_sytem.controller;

import com.eubrunoo07.auth_login_sytem.dto.UserLoginRequestDTO;
import com.eubrunoo07.auth_login_sytem.dto.UserRequestDTO;
import com.eubrunoo07.auth_login_sytem.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/users")
@CrossOrigin(originPatterns = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody UserRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(dto));
    }

    @GetMapping("/")
    public String get(){
        return "Olá";
    }


}
