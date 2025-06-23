package com.example.doctorProject.service;

import com.example.doctorProject.entity.Prescription;
import com.example.doctorProject.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public String savePrescription(Prescription prescription) {
        if (prescription.getDoctorName() == null || prescription.getPatientName() == null ||
            prescription.getMedicine() == null || prescription.getDiagnosis() == null) {
            return "All fields are required!";
        }

        prescriptionRepository.save(prescription);
        return "Prescription added successfully!";
    }

    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }
}
