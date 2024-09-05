package com.eubrunoo07.auth_login_sytem.dto;

import com.eubrunoo07.auth_login_sytem.enums.UserRole;

public record UserResponseDTO(
        String username,
        String email,
        UserRole role
) {
}
