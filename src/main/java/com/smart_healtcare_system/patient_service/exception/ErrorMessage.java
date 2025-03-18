package com.smart_healtcare_system.patient_service.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ErrorMessage {
    private LocalDateTime time;
    private String status;
    private String message;
    private List<FieldErrorDetail> errorsDetails;
}
