package com.doclink.security;

import com.doclink.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * This is the class whose instances will be returned from our custom UserDetailsService.
 * Spring Security will use the information stored in the UserPrincipal object to perform
 * authentication and authorization.
 */
//@Builder
@Getter
public class DoclinkUserPrincipal implements UserDetails {
    private Long id;
    private String firstName;
    private String lastName;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private String gender;
    private String state;
    private String country;
    private String profileImg;
    private Boolean confirmedEmail;


    public String getGender() {
        return gender;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public Boolean getConfirmedEmail() {
        return confirmedEmail;
    }

    public DoclinkUserPrincipal(User user, Collection<? extends GrantedAuthority> authorities) {
        this.id = user.getId();
        this.authorities = authorities;
        this.firstName = user.getFirstName();
        this.lastName=user.getLastName();
        this.email = user.getEmail();
        this.gender=user.getGender();
        this.state = user.getState();
        this.country=user.getCountry();
        this.profileImg = user.getProfileImg();
        this.confirmedEmail=user.getConfirmedEmail();
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public static DoclinkUserPrincipal create(User user) {
       /**
        * This is basically should use stream mapping which is a feature of
        * Java 8 just to filter the roles and assign it to spring authorities object
        * which determines the users privilege. Each role in the roles set is changed
        * to a new granted authority object through the stream map method and the collect method
        */

        List <GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().name()));
//        UserRole.valueOf(userModel.getRole().toString());
//                userModel.getRole().map(role ->
//                new SimpleGrantedAuthority(role.name()))
//                .collect(Collectors.toList());

        // Doing that without the main should be done first and then we will implement the above
        // code in the second phase of the project

        return new DoclinkUserPrincipal(
                user,
                grantedAuthorities
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
