package com.smart_healtcare_system.patient_service.service;

import com.smart_healtcare_system.patient_service.dto.request.PatientDTORequest;
import com.smart_healtcare_system.patient_service.dto.response.PatientDTOResponse;

import java.util.List;

public interface PatientHandlerService {

    PatientDTOResponse createNewPatient(PatientDTORequest patientDTORequest);

    List<PatientDTOResponse> getAllPatients(int page, int size);

    PatientDTOResponse getPatientById(Long patientId);

    PatientDTOResponse getPatientBySSN(String patientSSN);

    Boolean deletePatientById(Long patientId);

}
