package com.smart_healtcare_system.patient_service.controller;

import com.smart_healtcare_system.patient_service.constant.RestApiPath;
import com.smart_healtcare_system.patient_service.dto.request.PatientDTORequest;
import com.smart_healtcare_system.patient_service.dto.response.PatientDTOResponse;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Operations on patients
 */
@RequestMapping(RestApiPath.PATIENT_BASE)
public interface PatientHandlerController {

    /**
     * Save new patient
     *
     * @param patientDTORequest
     * @return New Patient Created
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PatientDTOResponse> createNewPatient(@Valid @RequestBody PatientDTORequest patientDTORequest);


    /**
     * Search patient by ID
     *
     * @param patientId
     * @return patient data
     */
    @GetMapping(RestApiPath.PATIENT_BY_ID)
    ResponseEntity<PatientDTOResponse> getPatientById(@PathVariable Long patientId);


    /**
     * Search patient by SSN
     *
     * @param patientSSN
     * @return patient data
     */
    @GetMapping(RestApiPath.PATIENT_BY_SSN)
    ResponseEntity<PatientDTOResponse> getPatientBySSN(@PathVariable String patientSSN);

    /**
     * Delete patient on DB
     *
     * @param patientId
     * @return "true" if patient is deleted successfully
     */
    @DeleteMapping(RestApiPath.PATIENT_BY_ID)
    ResponseEntity<Boolean> deletePatientByID(@PathVariable Long patientId);


    /**
     * Retrieve all patients on DB
     * @param page number of page to retrieve defaultValue=0
     * @param size size of page defaultValue=5
     * @return list of all patients
     */
    @GetMapping
    ResponseEntity<List<PatientDTOResponse>> getAllPatients(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size);

}
