package com.doclink.security;

import com.doclink.model.UserModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


/**
 * This is the class whose instances will be returned from our custom UserDetailsService.
 * Spring Security will use the information stored in the UserPrincipal object to perform
 * authentication and authorization.
 */
@Builder
@Getter
public class DoclinkUserPrincipal implements UserDetails {

    private Long id;
    private String fname;
    private String lname;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;


    public DoclinkUserPrincipal(Long id, String fname, String lname, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static DoclinkUserPrincipal create(UserModel userModel) {
       /**
        * This is basically should use stream mapping which is a feature of
        * Java 8 just to filter the roles and assign it to spring authorities object
        * which determines the users privilege. Each role in the roles set is changed
        * to a new granted authority object through the stream map method and the collect method
        */

        List <GrantedAuthority> grantedAuthority = userModel.getRole().stream().map(role ->
                new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());

        // Doing that without the main should be done first and then we will implement the above
        // code in the second phase of the project

        return new DoclinkUserPrincipal(
                userModel.getId(),
                userModel.getFname(),
                userModel.getLname(),
                userModel.getEmail(),
                userModel.getPassword(),
                grantedAuthority
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
