package com.example.doctorProject.controller;

import com.example.doctorProject.entity.Doctor;
import com.example.doctorProject.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // ✅ Register a new doctor
    @PostMapping("/register")
    public String register(@RequestBody Doctor doctor) {
        return doctorService.registerUser(doctor);
    }

    // ✅ Login doctor
    @PostMapping("/login")
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

    // ✅ Dummy logout
//    @PostMapping("/logout")
//    public String logout(@RequestParam String email) {
//        return doctorService.logoutUser(email);
//    }
}
