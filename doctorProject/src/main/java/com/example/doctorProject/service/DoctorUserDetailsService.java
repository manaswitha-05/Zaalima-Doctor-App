package com.example.doctorProject.service;

import com.example.doctorProject.entity.Doctor;
import com.example.doctorProject.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorUserDetailsService implements UserDetailsService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Doctor> doctorOptional = doctorRepository.findByEmail(email);

        if (doctorOptional.isEmpty()) {
            throw new UsernameNotFoundException("Doctor not found with email: " + email);
        }

        Doctor doctor = doctorOptional.get();

        // You can later customize roles dynamically from DB
        return User.builder()
                .username(doctor.getEmail())
                .password(doctor.getPassword())
                .roles("DOCTOR")
                .build();
    }
}

