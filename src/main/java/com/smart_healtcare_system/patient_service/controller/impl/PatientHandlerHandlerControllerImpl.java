package com.smart_healtcare_system.patient_service.controller.impl;

import com.smart_healtcare_system.patient_service.controller.PatientHandlerController;
import com.smart_healtcare_system.patient_service.dto.request.PatientDTORequest;
import com.smart_healtcare_system.patient_service.dto.response.PatientDTOResponse;
import com.smart_healtcare_system.patient_service.service.PatientHandlerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class PatientHandlerHandlerControllerImpl implements PatientHandlerController {

    private final PatientHandlerService patientHandlerService;

    @Override
    public ResponseEntity<PatientDTOResponse> createNewPatient(PatientDTORequest patientDTORequest) {
        PatientDTOResponse newPatient = patientHandlerService.createNewPatient(patientDTORequest);
        if(Objects.nonNull(newPatient)){
            return ResponseEntity.status(HttpStatus.CREATED).body(newPatient);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @Override
    public ResponseEntity<PatientDTOResponse> getPatientById(Long patientId) {
        PatientDTOResponse patientById = patientHandlerService.getPatientById(patientId);
        if(Objects.nonNull(patientById)){
            return ResponseEntity.status(HttpStatus.OK).body(patientById);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<PatientDTOResponse> getPatientBySSN(String patientSSN) {
        PatientDTOResponse patientBySSN = patientHandlerService.getPatientBySSN(patientSSN);
        if(Objects.nonNull(patientBySSN)){
            return ResponseEntity.status(HttpStatus.OK).body(patientBySSN);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<Boolean> deletePatientByID(Long patientId) {
        Boolean deleted = patientHandlerService.deletePatientById(patientId);
        return ResponseEntity.status(HttpStatus.GONE).body(deleted);
    }

    @Override
    public ResponseEntity<List<PatientDTOResponse>> getAllPatients(int page, int size) {

        List<PatientDTOResponse> allPatients = patientHandlerService.getAllPatients(page, size);
        if(Objects.nonNull(allPatients)){
            return ResponseEntity.ok(allPatients);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
