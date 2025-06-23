package com.example.doctorProject.service;

import com.example.doctorProject.entity.Patient;
import com.example.doctorProject.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // ➕ Add new patient
    public String addPatient(Patient patient) {
        patientRepository.save(patient);
        return "Patient added successfully!";
    }

    // 📋 Get all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // ✏️ Update patient by ID
    public String updatePatient(int id, Patient updatedPatient) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            patient.setName(updatedPatient.getName());
            patient.setAge(updatedPatient.getAge());
            patient.setDiagnosis(updatedPatient.getDiagnosis());
            patientRepository.save(patient);
            return "Patient updated successfully!";
        } else {
            return "Patient not found!";
        }
    }

    // ❌ Delete patient by ID
    public String deletePatient(int id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
            return "Patient deleted successfully!";
        } else {
            return "Patient not found!";
        }
    }
}
