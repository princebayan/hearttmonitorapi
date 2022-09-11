package com.cardiodiagnostics.heartmonitorapi.study.response;

import com.cardiodiagnostics.heartmonitorapi.study.device.response.DeviceResponse;
import com.cardiodiagnostics.heartmonitorapi.study.patient.response.PatientResponse;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudyResponse {

  private long id;
  private String name;
  private Date startTime;
  private Date endTime;
  private DeviceResponse device;
  private PatientResponse patient;
}
