package com.eubrunoo07.auth_login_sytem.dto;

public record UserRequestDTO(
        String username,
        String email,
        String password,
        String role
) {
}
