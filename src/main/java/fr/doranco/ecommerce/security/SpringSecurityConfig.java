package fr.doranco.ecommerce.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) ->
                authorize
                        .requestMatchers("/", "/login-utilisateur", "/add-utilisateur").permitAll()
                        .anyRequest().authenticated()
        ).formLogin(form -> form
                .loginPage("/login-utilisateur")
                .loginProcessingUrl("/login-utilisateur")
                .defaultSuccessUrl("/")
                .permitAll()
        ).logout(
                logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .permitAll()
        );
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withUsername("Admin")
                .password(passwordEncoder().encode("12345"))
                .roles("ADMIN", "MAGASINIER", "CLIENT")
                .build();
        UserDetails magasinier = User.withUsername("Magasinier")
                .password(passwordEncoder().encode("12345"))
                .roles("MAGASINIER", "CLIENT")
                .build();
        UserDetails client = User.withUsername("Client")
                .password(passwordEncoder().encode("12345"))
                .roles("CLIENT")
                .build();
        return new InMemoryUserDetailsManager(admin, magasinier, client);
    }

    /*
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {

        User.UserBuilder users = User.withDefaultPasswordEncoder();
        UserDetails admin = User.builder()
                .username("Admin")
                .password("12345")
                .roles("MAGASINIER", "ADMIN", "CLIENT")
                .build();
        UserDetails magasinier = User.builder()
                .username("Magasinier")
                .password("12345")
                .roles("MAGASINIER", "CLIENT")
                .build();
        UserDetails client = User.builder()
                .username("Client")
                .password("12345")
                .roles("CLIENT")
                .build();
        return new InMemoryUserDetailsManager(admin, magasinier, client);

        //return new JdbcUserDetailsManager(dataSource);
    }
    */
}