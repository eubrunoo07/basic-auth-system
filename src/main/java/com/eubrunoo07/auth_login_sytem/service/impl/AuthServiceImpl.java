package com.eubrunoo07.auth_login_sytem.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.eubrunoo07.auth_login_sytem.dto.UserLoginRequestDTO;
import com.eubrunoo07.auth_login_sytem.dto.UserRequestDTO;
import com.eubrunoo07.auth_login_sytem.entity.User;
import com.eubrunoo07.auth_login_sytem.repository.UserRepository;
import com.eubrunoo07.auth_login_sytem.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
//Quinto passo é implementar o UserDetailsService
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;


    //Sexto passo é implementar o método a seguir:
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    }

    @Override
    public String genToken(UserLoginRequestDTO dto) {
        User user = userRepository.findByEmail(dto.email());
        return generateTokenJWT(user);
    }

    public String generateTokenJWT(User user){
        try{
            Algorithm algorithm = Algorithm.HMAC256("my-secret");
            return JWT.create()
                    .withIssuer("Auth System")
                    .withSubject(user.getEmail())
                    .withExpiresAt(expiresAt())
                    .sign(algorithm);
        } catch (JWTCreationException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256("my-secret");
            return JWT.require(algorithm)
                    .withIssuer("Auth System")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (JWTVerificationException e){
            return "";
        }
    }

    private Instant expiresAt() {
        return LocalDateTime.now().plusHours(8).toInstant(ZoneOffset.of("-03:00"));
    }
}
