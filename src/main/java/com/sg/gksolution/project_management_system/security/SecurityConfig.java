package com.sg.gksolution.project_management_system.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Desabilitar CSRF (apenas para APIs REST)
            .authorizeHttpRequests(requests -> requests
                // Rotas Públicas (acessíveis sem autenticação)
                .requestMatchers("/authenticate", "/register").permitAll()

                // Rotas para ADMIN (gerenciamento de usuários)
                .requestMatchers("/users/**").hasRole("ADMIN")

                // Rotas para usuários autenticados (com JWT válido)
                .requestMatchers("/projects/**").authenticated()  // Projetos acessíveis por todos os autenticados
                .requestMatchers("/activities/**").authenticated() // Atividades acessíveis por todos os autenticados
                .requestMatchers("/time-entries/**").authenticated() // Lançamentos de horas acessíveis por todos os autenticados

                // Qualquer outra rota também exige autenticação
                .anyRequest().authenticated()
            )
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // Adiciona o filtro JWT antes do filtro padrão do Spring Security
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class).build();
    }
}
