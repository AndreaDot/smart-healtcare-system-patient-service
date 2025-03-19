package com.smart_healtcare_system.patient_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "patient")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    private String name;

    private String surname;

    @Column(unique = true)
    private String ssn;

    private LocalDate birthDate;

    private String address;

    private String city;

    private String email;

    private String telephoneNumber;

}
