package com.mftplus.appointmentmicro.appointments.repository;

import com.mftplus.appointmentmicro.appointments.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query("select s from scheduleEntity s cross join appointmentEntity a where a.appointmentId=:appointmentId")
    Schedule findByAppointmentId(@Param("appointmentId") Long appointmentId);

}
