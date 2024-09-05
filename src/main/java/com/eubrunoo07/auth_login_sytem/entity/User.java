package com.eubrunoo07.auth_login_sytem.entity;

import com.eubrunoo07.auth_login_sytem.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user_tb")
@Data
@NoArgsConstructor
//Segundo passo é implementar o UserDetails para indicar ao Spring que essa classe possui informações do usuário
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;

    //Primeiro passo é defeniri as roles do usuário
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User(String username, String email, String password, UserRole role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    //Quarto passo é verificar e dar ao usuário sua devida role
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN){
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER"));
        }
        return List.of(
                new SimpleGrantedAuthority("ROLE_USER")
        );
    }


    //Terceiro passo é alterar tudo isso pra true, visto que a aplicação segue um segmento básico do security
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
