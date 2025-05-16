// File: src/main/java/com/healthplatform/exception/PatientNotFoundException.java
package com.healthplatform.exception;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(Long id) {
        super("Patient not found with id: " + id);
    }
}
