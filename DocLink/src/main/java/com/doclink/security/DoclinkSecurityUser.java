package com.doclink.security;

import com.doclink.model.UserModel;
import com.doclink.model.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


/**
 * This is the class whose instances will be returned from our custom UserDetailsService.
 * Spring Security will use the information stored in the UserPrincipal object to perform
 * authentication and authorization.
 */
@Getter
public class DoclinkSecurityUser implements UserDetails {

    private Long id;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private String password;
    private UserRole role;
    private Collection<? extends GrantedAuthority> authorities;


    public DoclinkSecurityUser(Long id, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static DoclinkSecurityUser create(UserModel userModel) {
       /**
        * This is basically should use stream mapping which is a feature of
        * Java 8 just to filter the roles and assign it to spring authorities object
        * which determines the users privilege. Each role in the roles set is changed
        * to a new granted authority object through the stream map method and the collect method
        */

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userModel.getRole().name()));
        // Doing that without the main should be done first and then we will implement the above
        // code in the second phase of the project

        return new DoclinkSecurityUser(
                userModel.getId(),
                userModel.getEmail(),
                userModel.getPassword(),
                authorities
        );
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override
    public String getPassword() {
        return password ;
    }
    @Override
    public String getUsername() {
        return email;
    }
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
