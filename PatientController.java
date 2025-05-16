// File: src/main/java/com/healthplatform/controller/PatientController.java
package com.healthplatform.controller;

import com.healthplatform.model.Patient;
import com.healthplatform.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @PostMapping
    public Patient addPatient(@Valid @RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    @DeleteMapping("/{id}")
    public void removePatient(@PathVariable Long id) {
        patientService.removePatient(id);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }
}
