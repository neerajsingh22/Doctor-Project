// File: src/main/java/com/healthplatform/repository/PatientRepository.java
package com.healthplatform.repository;

import com.healthplatform.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
