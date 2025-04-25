package com.mftplus.appointmentmicro.appointments.repository;

import com.mftplus.appointmentmicro.appointments.Appointment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {


//    @Query("select a from appointmentEntity a where a.schedule.id =:id and a.startDateTime <=:endTime and a.endDateTime >=:startDate")
//    List<Appointment> findOverLappingAppointments(@Param("id")Long id, @Param("startTime")LocalDateTime startTime, @Param("endTime")LocalDateTime endTime );
//
//
//    @Query("select a from appointmentEntity a join fetch a.patient where a.patient.lastName = :lastName")
//    Appointment findByPatient(@Param("lastName") String lastName);
//
//    @Query("select a from appointmentEntity a join fetch a.patient where a.patient.patientId = :patientId")
//    Appointment findByPatientId(@Param("patientId") Long patientId);
//
//    @Modifying
//    @Query("update appointmentEntity a set a.deleted=true where a.appointmentId= :id")
//    @Transactional
//    void logicalRemove(@Param("id") Long id);
//
//
//    @Query("select a from appointmentEntity a where" +
//            "((:startTime between a.startDateTime and a.endDateTime) " +
//            "or (:endTime between a.startDateTime and a.endDateTime))")
//    List<Appointment> findByAvailableTime(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);


}
