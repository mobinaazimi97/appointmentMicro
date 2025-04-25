package com.mftplus.appointmentmicro.appointments.dto;

import com.mftplus.appointmentmicro.appointments.Appointment;
import com.mftplus.appointmentmicro.appointments.Schedule;
import com.mftplus.appointmentmicro.patient.Patient;
import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
//@ToString

@Component
public class PatientAppointmentDto {

    //Appointment :
    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    //Patient :
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    //Schedule :
    private String turnNumber;


    //Get Patient :
    public Patient getPatient() {
        return Patient.builder().firstName(firstName).lastName(lastName).build();
    }

    //Get Schedule :
    public Schedule getSchedule() {
        return Schedule.builder().appointment(getAppointment()).turnNumber(turnNumber).startDateTime(startDateTime).endDateTime(endDateTime).build();
    }

    //Get Appointment :
    public Appointment getAppointment() {
        return Appointment.builder()
                .schedule(getSchedule())
                .patient(getPatient())
                .startDateTime(startDateTime)
                .endDateTime(endDateTime)
                .build();

    }

}
