// File: src/main/java/com/healthplatform/controller/DoctorController.java
package com.healthplatform.controller;

import com.healthplatform.model.Doctor;
import com.healthplatform.service.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping
    public Doctor addDoctor(@Valid @RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }

    @DeleteMapping("/{id}")
    public void removeDoctor(@PathVariable Long id) {
        doctorService.removeDoctor(id);
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }
}
