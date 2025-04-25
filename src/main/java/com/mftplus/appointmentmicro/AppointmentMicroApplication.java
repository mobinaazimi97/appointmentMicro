package com.mftplus.appointmentmicro;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mftplus.appointmentmicro.appointments.Appointment;
import com.mftplus.appointmentmicro.appointments.Schedule;
import com.mftplus.appointmentmicro.appointments.dto.PatientAppointmentDto;
import com.mftplus.appointmentmicro.appointments.exception.NoContentException;
import com.mftplus.appointmentmicro.appointments.service.AppointmentService;
import com.mftplus.appointmentmicro.appointments.service.ScheduleService;
import com.mftplus.appointmentmicro.patient.Patient;
import com.mftplus.appointmentmicro.patient.PatientRepository;
import com.mftplus.appointmentmicro.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.time.LocalDateTime;

@EnableFeignClients
@SpringBootApplication
public class AppointmentMicroApplication {

    private static PatientRepository patientRepository;
    private static AppointmentService appointmentService;
    private static ScheduleService scheduleService;
    private static PatientAppointmentDto patientAppointmentDto;

    public AppointmentMicroApplication(AppointmentService appointmentService, ScheduleService scheduleService, PatientRepository patientRepository, PatientAppointmentDto patientAppointmentDto) {
        AppointmentMicroApplication.appointmentService = appointmentService;

        AppointmentMicroApplication.scheduleService = scheduleService;

        AppointmentMicroApplication.patientAppointmentDto = patientAppointmentDto;

    }

    public static void main(String[] args) throws JsonProcessingException, NoContentException {
        SpringApplication.run(AppointmentMicroApplication.class, args);

//        Schedule schedule = Schedule.builder().turnNumber("123").build();
//        scheduleService.save(schedule);
//        System.out.println("Schedule Saved :"+schedule);


//        Patient patient=patientAppointmentDto.getPatient();
//        PatientAppointmentDto patientAppointmentDto=new PatientAppointmentDto();
//        Patient patient=patientAppointmentDto.getPatient();
//        patientRepository.save(patient);
        Patient patient = patientAppointmentDto.getPatient();

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setStartDateTime(LocalDateTime.of(2025, 2, 23, 12, 12));
        appointment.setEndDateTime(LocalDateTime.of(2025, 2, 25, 12, 12));
//        Appointment appointment = Appointment.builder()
//                .startDateTime(LocalDateTime.of(2025, 2, 23, 12, 12))
//                .endDateTime(LocalDateTime.of(2025, 2, 24, 12, 12))
////                .patient(patient)
//                .schedule(schedule)
//                .build();
        appointmentService.save(appointment);
//        System.out.println("Appointments :"+appointment);
//

    }

}
