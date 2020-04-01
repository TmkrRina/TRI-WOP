package com.doclink.config;


import com.doclink.model.UserRole;
import com.doclink.security.JwtAuthenticationEntryPoint;
import com.doclink.security.JwtAuthenticationFilter;
import com.doclink.security.DoclinkUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

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
    private JwtAuthenticationEntryPoint unauthorizedHandeler;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {

        return new JwtAuthenticationFilter();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(doclinkUserDetailService)
        .passwordEncoder(getPasswordEncoder());
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                    .and()
                .csrf()
                    .disable()
                .exceptionHandling()
                    .authenticationEntryPoint(unauthorizedHandeler)
                    .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                .authorizeRequests()
                .antMatchers("/api/Admin").hasRole(UserRole.Role_Admin.name())
                .antMatchers("/api/user/**").hasAnyRole(UserRole.Role_Patient.name(), UserRole.Role_Admin.name())
                .antMatchers("/api/doctor").hasAnyRole(UserRole.Role_Doctor.name(), UserRole.Role_Admin.name())
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
