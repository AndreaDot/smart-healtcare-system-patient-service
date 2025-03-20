package com.smart_healtcare_system.patient_service.service.impl;

import com.smart_healtcare_system.patient_service.dto.request.PatientDTORequest;
import com.smart_healtcare_system.patient_service.dto.response.PatientDTOResponse;
import com.smart_healtcare_system.patient_service.mapper.PatientMapper;
import com.smart_healtcare_system.patient_service.model.Patient;
import com.smart_healtcare_system.patient_service.repository.PatientRepository;
import com.smart_healtcare_system.patient_service.service.PatientHandlerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientHandlerHandlerServiceImpl implements PatientHandlerService {

    private final PatientMapper patientMapper;

    private final PatientRepository patientRepository;

    @Override
    public PatientDTOResponse createNewPatient(PatientDTORequest patientDTORequest) {
        Optional<Patient> patientBySsn = patientRepository.findBySsn(patientDTORequest.getSsn());
        if(patientBySsn.isEmpty()){
            Patient patient = patientMapper.mapDtoRequestToEntity(patientDTORequest);
            Patient patientSaved = patientRepository.save(patient);
            return patientMapper.mapEntityToDtoResponse(patientSaved);
        }
        return null;
    }

    @Override
    public List<PatientDTOResponse> getAllPatients(int page, int size) {
        Pageable pageRequest = PageRequest.of(page, size);
        Page<Patient> allPatients = patientRepository.findAll(pageRequest);
        if (!allPatients.isEmpty()) {
            return patientMapper.mapEntitiesToDtoResponses(allPatients.getContent());
        }
        return null;
    }

    @Override
    public PatientDTOResponse getPatientById(Long patientId) {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        return patientOptional.map(patientMapper::mapEntityToDtoResponse).orElse(null);
    }

    @Override
    public PatientDTOResponse getPatientBySSN(String patientSSN) {
        Optional<Patient> patientOptional = patientRepository.findBySsn(patientSSN);
        return patientOptional.map(patientMapper::mapEntityToDtoResponse).orElse(null);
    }

    @Override
    public Boolean deletePatientById(Long patientId) {

        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (patientOptional.isPresent()) {
            patientRepository.deleteById(patientId);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
