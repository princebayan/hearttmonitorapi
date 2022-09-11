package com.cardiodiagnostics.heartmonitorapi.study.device;

import com.cardiodiagnostics.heartmonitorapi.study.device.request.AddDeviceRequest;
import com.cardiodiagnostics.heartmonitorapi.study.device.response.DeviceResponse;
import com.cardiodiagnostics.heartmonitorapi.study.device.response.GetAllDevicesResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Log4j2
@Service
public class DeviceLogic {

  private final DeviceRepository deviceRepository;

  public GetAllDevicesResponse getAllDevices() {
    /*
    Find all devices.
     */
    List<DeviceEntity> devices = deviceRepository.findAll();
    /*
    map the devices using parallel stream.
     */
    List<DeviceResponse> deviceResponses = devices
        .parallelStream()
        .map(deviceEntity -> {
          DeviceResponse device = new DeviceResponse();
          device.setId(deviceEntity.getId());
          device.setSerial(deviceEntity.getSerial());
          return device;
        })
        .collect(Collectors.toList());
    /*
    fill and return the response.
     */
    GetAllDevicesResponse response = new GetAllDevicesResponse();
    response.setDevices(deviceResponses);
    return response;
  }

  protected DeviceResponse addDevice(AddDeviceRequest addDeviceRequest) {
    DeviceEntity device = new DeviceEntity();
    device.setSerial(addDeviceRequest.getSerial());
    deviceRepository.save(device);

    DeviceResponse response = new DeviceResponse();
    response.setSerial(device.getSerial());
    response.setId(device.getId());
    return response;
  }
}
