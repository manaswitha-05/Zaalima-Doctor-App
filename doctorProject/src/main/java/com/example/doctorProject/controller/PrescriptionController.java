package com.example.doctorProject.controller;

import com.example.doctorProject.entity.Prescription;
import com.example.doctorProject.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    // Add prescription
    @PostMapping("/add")
    public String addPrescription(@RequestBody Prescription prescription) {
        return prescriptionService.savePrescription(prescription);
    }

    // Get all prescriptions
    @GetMapping("/all")
    public List<Prescription> getAllPrescriptions() {
        return prescriptionService.getAllPrescriptions();
    }
}
