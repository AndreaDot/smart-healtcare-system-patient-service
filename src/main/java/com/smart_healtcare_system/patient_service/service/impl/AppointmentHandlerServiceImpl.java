package com.smart_healtcare_system.patient_service.service.impl;

import com.smart_healtcare_system.patient_service.dto.response.AppointmentDTOResponse;
import com.smart_healtcare_system.patient_service.service.AppointmentHandlerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AppointmentHandlerServiceImpl implements AppointmentHandlerService {
    @Override
    @RabbitListener(queues = "${rabbitmq.queue.appointment.responses.name}")
    public void receiveResponseAppointment(AppointmentDTOResponse appointmentDTOResponse) {
        log.info("Appuntamento del {} alle ore {} : {} dal dottore!", appointmentDTOResponse.getDate(), appointmentDTOResponse.getTime(), appointmentDTOResponse.getStatus());
    }
}
