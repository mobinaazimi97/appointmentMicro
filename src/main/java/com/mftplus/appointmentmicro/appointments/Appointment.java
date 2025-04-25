package com.mftplus.appointmentmicro.appointments;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mftplus.appointmentmicro.patient.Patient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;



@Getter
@Setter
@NoArgsConstructor
@ToString
@SuperBuilder
@Entity(name = "appointmentEntity")
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "appointment_id")
    private Long appointmentId;

    @Column(name = "deleted")
    private boolean deleted;
//(fetch = FetchType.EAGER)
    @ManyToOne
    @JoinColumn(name = "patient_info")
    @JsonIgnore
    private Patient patient ;

//    @ManyToOne
//    @JoinColumn(name = "medicalHistory_info")
//    private MedicalHistory medicalHistory ;
//
//    @OneToOne
//    private User user;

    @Column(name = "start_time")
    private LocalDateTime startDateTime;

    @Column(name = "end_time")
    private LocalDateTime endDateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "schedule_info")
    private Schedule schedule;

}