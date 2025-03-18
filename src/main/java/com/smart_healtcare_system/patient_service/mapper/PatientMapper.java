package com.smart_healtcare_system.patient_service.mapper;

import com.smart_healtcare_system.patient_service.dto.request.PatientDTORequest;
import com.smart_healtcare_system.patient_service.dto.response.PatientDTOResponse;
import com.smart_healtcare_system.patient_service.model.Patient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient mapDtoRequestToEntity(PatientDTORequest patientDTORequest);

    PatientDTOResponse mapEntityToDtoResponse(Patient patient);

    List<PatientDTOResponse> mapEntitiesToDtoResponses(List<Patient> patients);
}
