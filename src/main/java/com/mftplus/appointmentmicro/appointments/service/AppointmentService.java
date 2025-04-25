package com.mftplus.appointmentmicro.appointments.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mftplus.appointmentmicro.appointments.Appointment;
import com.mftplus.appointmentmicro.appointments.dto.PatientAppointmentDto;
import com.mftplus.appointmentmicro.appointments.exception.NoContentException;
import com.mftplus.appointmentmicro.appointments.repository.AppointmentRepository;
import com.mftplus.appointmentmicro.patient.Patient;
import com.mftplus.appointmentmicro.patient.PatientRepository;
import com.mftplus.appointmentmicro.patient.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class AppointmentService {
    private final PatientRepository patientRepository;
    private final PatientService patientService;
    private final AppointmentRepository appointmentRepository;


    public AppointmentService(PatientRepository patientRepository, PatientService patientService, AppointmentRepository appointmentRepository) {
        this.patientRepository = patientRepository;
        this.patientService = patientService;
        this.appointmentRepository = appointmentRepository;
    }

    //chatgpt:
//    public Appointment save(PatientAppointmentDto patientAppointmentDto) {
        // Step 1: Send request to Patient service
//        Patient patient = null;
//        try {
//            patient = patientService.save(patientAppointmentDto).getBody();
//        } catch (Exception e) {
//            // Handle gracefully
//            log.error("Patient service is unavailable", e);
//            // You can either:
//            // 1. Throw a custom exception
//            // 2. Return partial data
//            // 3. Save appointment without patient data (based on logic)
//            throw new RuntimeException("Failed to create patient via Patient Service");
//        }

        // Step 2: Save appointment with patient ID or info
//        Appointment appointment = new Appointment();
//        appointment.setStartDateTime(patientAppointmentDto.getStartDateTime());
//        appointment.setEndDateTime(patientAppointmentDto.getEndDateTime());
//        appointment.setPatient(patientAppointmentDto.getPatient()); // validate patient != null if needed
//
//        return appointmentRepository.save(appointment);
//    }

        // Save a new Appointment
        public void save (Appointment appointment) throws JsonProcessingException, NoContentException {
            ResponseEntity<String> responses = patientService.save(appointment.getPatient());
            if (responses.getStatusCode().equals(HttpStatus.OK)) {
                ObjectMapper mapper = new ObjectMapper();
                Patient patient = mapper.readValue(responses.getBody(), Patient.class);
                patientRepository.save(patient);
                appointment.setPatient(patient);
                appointmentRepository.save(appointment);
                System.out.println(mapper.writeValueAsString(appointment));
            } else {
                System.out.println("Error :" + responses.getStatusCode() + " : " + responses.getBody());
                throw new NoContentException();
            }

        }

    public List<Appointment> findAll() {
        return appointmentRepository.findAll(); // استفاده از متد findAll که در JpaRepository به صورت پیش‌فرض موجود است.
    }

}
