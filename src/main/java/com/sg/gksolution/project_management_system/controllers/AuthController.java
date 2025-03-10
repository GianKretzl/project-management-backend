package com.sg.gksolution.project_management_system.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.gksolution.project_management_system.security.JwtUtil;

@RestController
@RequestMapping("/authenticate")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createAuthenticationToken(@RequestBody Map<String, String> authRequest) {
        // Valide o usuário aqui (adicione lógica de validação real)
        String username = authRequest.get("username");
        String token = jwtUtil.generateToken(username);

        return ResponseEntity.ok(Map.of("jwt", token));
    }
}
