//package com.example.doctorProject.controller;
//
//import com.example.doctorProject.model.JwtRequest;
//import com.example.doctorProject.model.JwtResponse;
//import com.example.doctorProject.service.DoctorUserDetailsService;
//import com.example.doctorProject.util.JwtUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/auth")
//public class JwtController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private DoctorUserDetailsService doctorUserDetailsService;
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @PostMapping("/login")
//    public JwtResponse login(@RequestBody JwtRequest jwtRequest) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        jwtRequest.getEmail(),
//                        jwtRequest.getPassword()
//                )
//        );
//
//        UserDetails userDetails = doctorUserDetailsService.loadUserByUsername(jwtRequest.getEmail());
//        String token = jwtUtil.generateToken(userDetails);
//        return new JwtResponse(token);
//    }
//}
