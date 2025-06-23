package com.example.doctorProject.service;

import com.example.doctorProject.entity.Doctor;
import com.example.doctorProject.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Register a doctor
    public String registerUser(Doctor doctor) {
        if (doctor.getEmail().matches(".*@(gmail\\.com|yahoo\\.com|outlook\\.com|hotmail\\.com)$")) {
            doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
            doctorRepository.save(doctor);
            return "Registration successful!";
        } else {
            return "Email must end with gmail.com, yahoo.com, outlook.com, or hotmail.com";
        }
    }

    // Login a doctor
    public String loginUser(String email, String password) {
        Optional<Doctor> optionalDoctor = doctorRepository.findByEmail(email);
        if (optionalDoctor.isPresent()) {
            Doctor doctor = optionalDoctor.get();
            if (passwordEncoder.matches(password, doctor.getPassword())) {
                return "Login successful!";
            } else {
                return "Invalid password!";
            }
        } else {
            return "Doctor not found!";
        }
    }

    // Get all doctors
    public List<Doctor> getAllUsers() {
        return doctorRepository.findAll();
    }

    // Delete a doctor
    public String deleteDoctor(int id) {
        if (doctorRepository.existsById(id)) {
            doctorRepository.deleteById(id);
            return "Doctor deleted successfully!";
        } else {
            return "Doctor not found!";
        }
    }

    // Update a doctor
    public String updateDoctor(int id, Doctor updatedDoctor) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        if (optionalDoctor.isPresent()) {
            Doctor doctor = optionalDoctor.get();
            doctor.setName(updatedDoctor.getName());
            doctor.setEmail(updatedDoctor.getEmail());
            doctor.setPassword(passwordEncoder.encode(updatedDoctor.getPassword()));
            doctorRepository.save(doctor);
            return "Doctor updated successfully!";
        } else {
            return "Doctor not found!";
        }
    }
}
