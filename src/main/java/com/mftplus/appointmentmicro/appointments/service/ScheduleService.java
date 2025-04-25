package com.mftplus.appointmentmicro.appointments.service;


import com.mftplus.appointmentmicro.appointments.Schedule;
import com.mftplus.appointmentmicro.appointments.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public Schedule update(Schedule schedule) {
        return scheduleRepository.save(schedule);
//        Optional<Schedule> existingSchedule = scheduleRepository.findById(id);
//        if (existingSchedule.isPresent()) {
//            Schedule updatedSchedule = existingSchedule.get();
////            Todo : Error
////            updatedSchedule.setDate(schedule.getDate());  // Update any other fields here
////            updatedSchedule.setDoctor(schedule.getDoctor());  // Example of updating another field
//            return scheduleRepository.save(updatedSchedule);
//        }
//        throw new RuntimeException("Schedule not found with ID: " + id);
    }

    public void delete(Long id) {
        scheduleRepository.deleteById(id);
    }

    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    public Schedule findById(Long id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found with ID: " + id));
    }

    public Schedule findByAppointmentId(Long appointmentId) {
        return scheduleRepository.findByAppointmentId(appointmentId);
    }


}
