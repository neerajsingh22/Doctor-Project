// File: src/main/java/com/healthplatform/repository/DoctorRepository.java
package com.healthplatform.repository;

import com.healthplatform.model.Doctor;
import com.healthplatform.model.enums.DoctorCity;
import com.healthplatform.model.enums.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByCityAndSpeciality(DoctorCity city, Speciality speciality);
}
