package com.smart_healtcare_system.patient_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientDTOResponse {

    private Long patientId;

    private String name;

    private String surname;

    private String ssn;

    private LocalDate birthDate;

    private String address;

    private String city;

    private String email;

    private String telephoneNumber;

}
