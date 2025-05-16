// File: src/main/java/com/healthplatform/model/Patient.java
package com.healthplatform.model;

import com.healthplatform.model.enums.Symptom;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, message = "Name must be at least 3 characters")
    private String name;

    @Size(max = 20, message = "City must be at most 20 characters")
    private String city;

    @Email
    private String email;

    @Pattern(regexp = "^\\d{10,}$", message = "Phone number must be at least 10 digits")
    private String phone;

    @Enumerated(EnumType.STRING)
    private Symptom symptom;
}
