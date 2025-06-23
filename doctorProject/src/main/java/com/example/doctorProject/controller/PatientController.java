package com.example.doctorProject.controller;

import com.example.doctorProject.entity.Patient;
import com.example.doctorProject.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // ➕ POST /patient/add
    @PostMapping("/add")
    public String addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    // 📋 GET /patient/all
    @GetMapping("/all")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    // ✏️ PUT /patient/update/{id}
    @PutMapping("/update/{id}")
    public String updatePatient(@PathVariable int id, @RequestBody Patient updatedPatient) {
        return patientService.updatePatient(id, updatedPatient);
    }

    // ❌ DELETE /patient/delete/{id}
    @DeleteMapping("/delete/{id}")
    public String deletePatient(@PathVariable int id) {
        return patientService.deletePatient(id);
    }
}
