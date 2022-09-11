package com.cardiodiagnostics.heartmonitorapi.study.device.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAllDevicesResponse {

  private List<DeviceResponse> devices;
}
