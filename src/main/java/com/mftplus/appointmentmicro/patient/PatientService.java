package com.mftplus.appointmentmicro.patient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(value = "patientClient", url = "http://172.20.208.1:80",fallback = PatientServiceFallback.class)
@FeignClient(
        name = "patientClient",
        url = "http://192.168.36.55")
@Component
public interface PatientService {

    @PostMapping("/patients")
    ResponseEntity<String> save(@RequestBody Patient patient);

//    @PostMapping("/patients")
//    ResponseEntity<String> postPatient(@RequestBody Patient patient);

    @GetMapping("/patients")
    ResponseEntity<String> getPatients();
}
