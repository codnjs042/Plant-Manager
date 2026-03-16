package com.example.plant.global.security;

import com.example.plant.domain.User.domain.User;
import com.example.plant.domain.User.domain.UserStatus;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
public class CustomUserDetails implements UserDetails {
    private User user;

    public CustomUserDetails(User user){
        this.user = user;
    }

    public Long getId(){
        return user.getId();
    }

    @Override
    public String getUsername(){
        return user.getUsername();
    }

    @Override
    public String getPassword(){
        return user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        String roleName = "ROLE_" + this.user.getRole().name();
        return List.of(new SimpleGrantedAuthority(roleName));
    }

    @Override
    public boolean isEnabled(){
        return user.getStatus() != UserStatus.DELETED;
    }
}
