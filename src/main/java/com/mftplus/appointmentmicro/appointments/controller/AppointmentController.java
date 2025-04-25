package com.mftplus.appointmentmicro.appointments.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mftplus.appointmentmicro.appointments.Appointment;
import com.mftplus.appointmentmicro.appointments.dto.PatientAppointmentDto;
import com.mftplus.appointmentmicro.appointments.exception.NoContentException;
import com.mftplus.appointmentmicro.appointments.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;


    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    //ChatGpt :
//    @PostMapping
//    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) throws JsonProcessingException, NoContentException {
//        appointmentService.save(appointment);
//        return ResponseEntity.ok(appointment);
//    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAppointments() {
        List<Appointment> appointments = appointmentService.findAll();
        return ResponseEntity.ok(appointments);
    }


    @PostMapping
    public ResponseEntity<Appointment>save(@RequestBody PatientAppointmentDto patientAppointmentDto) throws JsonProcessingException, NoContentException, JsonProcessingException, NoContentException {

        Appointment appointment = patientAppointmentDto.getAppointment();
        appointmentService.save(appointment);
        return ResponseEntity.ok(appointment);

    }

//    @PostMapping
//    public ResponseEntity<?> createAppointment(@RequestBody PatientAppointmentDto dto) {
//        try {
//            Appointment appointment = appointmentService.save(dto);
//            return ResponseEntity.status(HttpStatus.CREATED).body(appointment);
//        } catch (RuntimeException e) {
//            // agar patient service unavailable bood ya exception dade shod
//            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
//                    .body("Could not create appointment: " + e.getMessage());
//        }
//    }
}
