package com.example.doctorProject.controller;

import com.example.doctorProject.service.DoctorUserDetailsService;
import com.example.doctorProject.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private DoctorUserDetailsService doctorUserDetailsService;

    @PostMapping("/jwt-login")
    public String createToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getEmail(),
                            authRequest.getPassword()
                    )
            );
        } catch (AuthenticationException e) {
            throw new Exception("Invalid credentials", e);
        }

        final UserDetails userDetails =
                doctorUserDetailsService.loadUserByUsername(authRequest.getEmail());

        return jwtUtil.generateToken(userDetails);
    }

    // Simple DTO class for login payload
    public static class AuthRequest {
        private String email;
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
