// File: src/main/java/com/healthplatform/service/SuggestionService.java
package com.healthplatform.service;

import com.healthplatform.exception.PatientNotFoundException;
import com.healthplatform.model.Doctor;
import com.healthplatform.model.Patient;
import com.healthplatform.model.enums.DoctorCity;
import com.healthplatform.model.enums.Speciality;
import com.healthplatform.model.enums.Symptom;
import com.healthplatform.repository.DoctorRepository;
import com.healthplatform.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SuggestionService {
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public Object suggestDoctors(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException(patientId));

        // Edge-case 1: Outside supported cities
        DoctorCity doctorCity = null;
        try {
            doctorCity = DoctorCity.valueOf(patient.getCity().toUpperCase());
        } catch (IllegalArgumentException e) {
            return "We are still waiting to expand to your location";
        }

        Speciality requiredSpeciality = mapSymptomToSpeciality(patient.getSymptom());
        List<Doctor> doctors = doctorRepository.findByCityAndSpeciality(doctorCity, requiredSpeciality);

        if (doctors.isEmpty()) {
            return "There isn't any doctor present at your location for your symptom";
        }
        return doctors;
    }

    private Speciality mapSymptomToSpeciality(Symptom symptom) {
        return switch (symptom) {
            case ARTHRITIS, BACK_PAIN, TISSUE_INJURIES -> Speciality.ORTHOPAEDIC;
            case DYSMENORRHEA -> Speciality.GYNECOLOGY;
            case SKIN_INFECTION, SKIN_BURN -> Speciality.DERMATOLOGY;
            case EAR_PAIN -> Speciality.ENT;
        };
    }
}
