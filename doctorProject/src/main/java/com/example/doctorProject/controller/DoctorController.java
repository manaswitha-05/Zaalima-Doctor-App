package com.example.doctorProject.controller;

import com.example.doctorProject.entity.Doctor;
import com.example.doctorProject.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/auth")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // ✅ Register a new doctor
    @PostMapping("/register")
    public String register(@RequestBody Doctor doctor) {
        try {
            return doctorService.registerUser(doctor);
        } catch (Exception e) {
            e.printStackTrace(); // Print error in Eclipse console
            return "Error: " + e.getMessage();
        }
    }


    // ✅ Login doctor
    @PostMapping("/Doc-login")
    public String login(@RequestBody Doctor doctor) {
        return doctorService.loginUser(doctor.getEmail(), doctor.getPassword());
    }

    // ✅ Get all doctors
    @GetMapping("/all")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllUsers();
    }

    // ✅ Delete a doctor by ID
    @DeleteMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable int id) {
        return doctorService.deleteDoctor(id);
    }

    // ✅ Update a doctor's name/email/password
    @PutMapping("/update/{id}")
    public String updateDoctor(@PathVariable int id, @RequestBody Doctor updatedDoctor) {
        return doctorService.updateDoctor(id, updatedDoctor);
    }

}
