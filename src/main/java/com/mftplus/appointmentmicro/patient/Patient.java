package com.mftplus.appointmentmicro.patient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.mftplus.appointmentmicro.appointments.Appointment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLRestriction;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString

@Cacheable
@Entity(name = "patientEntity")
@Table(name = "patients")
@SQLRestriction("deleted = false")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "patientId")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patientId")
    private Long patientId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "phone")
    private String phone;

    @Column(name = "deleted")
    private boolean deleted = false;

//    @OneToMany(mappedBy = "patient",fetch = FetchType.EAGER)
//    @JsonIgnore
//    private List<Appointment> appointments=new ArrayList<>();

//    @OneToOne
//    @JoinTable(name = "patient_user",foreignKey = @ForeignKey(name = "fk_patient_user"))
//    private User user;
//
}