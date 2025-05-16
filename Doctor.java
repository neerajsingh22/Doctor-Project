// File: src/main/java/com/healthplatform/model/Doctor.java
package com.healthplatform.model;

import com.healthplatform.model.enums.DoctorCity;
import com.healthplatform.model.enums.Speciality;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, message = "Name must be at least 3 characters")
    private String name;

    @Enumerated(EnumType.STRING)
    private DoctorCity city;

    @Email
    private String email;

    @Pattern(regexp = "^\\d{10,}$", message = "Phone number must be at least 10 digits")
    private String phone;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;
}
