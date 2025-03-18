package com.smart_healtcare_system.patient_service.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FieldErrorDetail {
    private String nameField;
    private String errorMessage;
}
