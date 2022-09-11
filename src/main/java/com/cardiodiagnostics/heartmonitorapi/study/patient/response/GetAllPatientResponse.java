package com.cardiodiagnostics.heartmonitorapi.study.patient.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAllPatientResponse {

  private List<PatientResponse> devices;
}
