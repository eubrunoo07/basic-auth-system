package com.eubrunoo07.auth_login_sytem.controller;

import com.eubrunoo07.auth_login_sytem.dto.UserLoginRequestDTO;
import com.eubrunoo07.auth_login_sytem.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> login(@RequestBody UserLoginRequestDTO dto){
        var authenticationUserToken = new UsernamePasswordAuthenticationToken(dto.email(), dto.password());
        authenticationManager.authenticate(authenticationUserToken);
        var token = authService.genToken(dto);
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }

}
