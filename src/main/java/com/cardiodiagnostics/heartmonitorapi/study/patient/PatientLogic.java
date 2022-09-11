package com.cardiodiagnostics.heartmonitorapi.study.patient;

import com.cardiodiagnostics.heartmonitorapi.study.patient.request.AddPatientRequest;
import com.cardiodiagnostics.heartmonitorapi.study.patient.response.GetAllPatientResponse;
import com.cardiodiagnostics.heartmonitorapi.study.patient.response.PatientResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Log4j2
@Service
public class PatientLogic {

  private final PatientRepository patientRepository;

  protected GetAllPatientResponse getAllPatients() {
    /*
    Find all patients.
     */
    List<PatientEntity> patients = patientRepository.findAll();

    /*
    map the patientts using parallel stream.
     */
    List<PatientResponse> patientResponses = patients
        .parallelStream()
        .map(patientEntity -> {
          PatientResponse patient = new PatientResponse();
          patient.setId(patientEntity.getId());
          patient.setName(patientEntity.getName());
          return patient;
        })
        .collect(Collectors.toList());
    /*
    fill and return the response.
     */
    GetAllPatientResponse response = new GetAllPatientResponse();
    response.setDevices(patientResponses);
    return response;
  }

  protected PatientResponse addPatient(AddPatientRequest addPatientRequest) {
    PatientEntity patient = new PatientEntity();
    patient.setName(addPatientRequest.getName());
    patientRepository.save(patient);

    PatientResponse response = new PatientResponse();
    response.setName(patient.getName());
    response.setId(patient.getId());
    return response;
  }


}
