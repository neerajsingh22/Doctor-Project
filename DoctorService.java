// File: src/main/java/com/healthplatform/service/DoctorService.java
package com.healthplatform.service;

import com.healthplatform.model.Doctor;
import com.healthplatform.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void removeDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
}
