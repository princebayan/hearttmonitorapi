package com.cardiodiagnostics.heartmonitorapi.study.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddStudyRequest {

  @NotBlank
  private String name;
  @Positive
  private long patientId;
  @Positive
  private long deviceId;
  @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Asia/Beirut")
  private Date startTime;
  @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Asia/Beirut")
  private Date endTime;

}
