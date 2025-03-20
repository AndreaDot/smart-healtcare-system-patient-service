package com.smart_healtcare_system.patient_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTORequest {

    @NotBlank(message = "{name.required}")
    private String name;

    @NotBlank(message = "{surname.required}")
    private String surname;

    @Size(min = 16, max = 16, message = "{ssn.length}")
    @Pattern(regexp = "^[A-Z]{6}\\d{2}[A-EHLMPR-T]{1}\\d{2}[A-Z]{1}\\d{3}[A-Z]{1}$", message = "{ssn.invalid}")
    private String ssn;

    private LocalDate birthDate;

    private String address;

    private String city;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "{email.invalid}")
    private String email;

    private String telephoneNumber;
}
