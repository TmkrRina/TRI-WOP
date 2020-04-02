package com.doclink.config;


import com.doclink.security.JwtAuthenticationEntryPoint;
import com.doclink.security.JwtAuthenticationFilter;
import com.doclink.service.DoclinkUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/** As we are going to use the database configuration for security this class
 *  inherited web security configuration adapter.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity (
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class DoclinkSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * To authenticate a User or perform various role-based checks,
     * Spring security needs to load users details somehow. For that
     * the class that implements the userdetailservice interface
     * is declared here so that we can
     */

    @Autowired
    private DoclinkUserDetailService doclinkUserDetailService;

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(doclinkUserDetailService)
        .passwordEncoder(getPasswordEncoder());
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                    .and()
                .csrf()
                    .disable()
                .exceptionHandling()
                    .authenticationEntryPoint(unauthorizedHandler)
                    .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                .authorizeRequests()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/api/posts").permitAll()
                .antMatchers("/api/auth").permitAll()
//                .antMatchers("/api/users/{id}/posts")
                //.antMatchers("/api/users/:id/posts", "/api/users/:id/comments").hasRole("Role_Patient")
                .antMatchers(HttpMethod.POST, "/api/register")
                    .permitAll()
                .anyRequest()
                    .authenticated();

        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
