package com.smart_healtcare_system.patient_service.repository;

import com.smart_healtcare_system.patient_service.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findBySsn(String patientSSN);
}
