package com.cardiodiagnostics.heartmonitorapi.study.patient;

import com.cardiodiagnostics.heartmonitorapi.study.patient.request.AddPatientRequest;
import com.cardiodiagnostics.heartmonitorapi.study.patient.response.GetAllPatientResponse;
import com.cardiodiagnostics.heartmonitorapi.study.patient.response.PatientResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "patient")
@Validated
@Tag(name = "Patient Controller")
@Log4j2
@AllArgsConstructor
public class PatientController {

  private final PatientLogic patientLogic;

  @PostMapping
  public ResponseEntity<PatientResponse> addPatient(AddPatientRequest addPatientRequest) {
    log.info("Invoke addPatient");

    PatientResponse result = patientLogic.addPatient(addPatientRequest);

    log.info("Exiting addPatient. response {}", result);
    return ResponseEntity.status(HttpStatus.OK).body(result);

  }

  @GetMapping
  public ResponseEntity<GetAllPatientResponse> getAllPatients() {
    log.info("Invoke getAllPatients");
    /*
    Get all patient from the logic class
     */
    GetAllPatientResponse result = patientLogic.getAllPatients();
    /*
    returning the response as 200 OK
     */
    log.info("Exiting getAllPatients. response {}", result);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }
}
