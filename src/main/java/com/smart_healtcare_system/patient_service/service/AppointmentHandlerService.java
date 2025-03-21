package com.smart_healtcare_system.patient_service.service;

import com.smart_healtcare_system.patient_service.dto.response.AppointmentDTOResponse;

public interface AppointmentHandlerService {

    void receiveResponseAppointment(AppointmentDTOResponse appointmentDTOResponse);
}
