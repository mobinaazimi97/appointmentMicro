package com.mftplus.appointmentmicro.appointments;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@SuperBuilder
@Entity(name = "scheduleEntity")
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "turnNumber")
    private String turnNumber;

    @Column(name = "start_time")
    private LocalDateTime startDateTime;

    @Column(name = "end_time")
    private LocalDateTime endDateTime;

    @OneToOne(fetch = FetchType.EAGER)
    private Appointment appointment;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "schedule_doctors")
//    private List<Doctor> doctorList;
}