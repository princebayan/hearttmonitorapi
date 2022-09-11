package com.cardiodiagnostics.heartmonitorapi.study.device.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeviceResponse {

  private long id;
  private String serial;

}
