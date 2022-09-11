package com.cardiodiagnostics.heartmonitorapi.study.device;

import com.cardiodiagnostics.heartmonitorapi.study.device.request.AddDeviceRequest;
import com.cardiodiagnostics.heartmonitorapi.study.device.response.DeviceResponse;
import com.cardiodiagnostics.heartmonitorapi.study.device.response.GetAllDevicesResponse;
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
@RequestMapping(value = "device")
@Validated
@Tag(name = "Device Controller")
@Log4j2
@AllArgsConstructor
public class DeviceController {

  private final DeviceLogic deviceLogic;

  @PostMapping
  public ResponseEntity<DeviceResponse> addDevice(AddDeviceRequest addDeviceRequest) {
    log.info("Invoke addDevice");

    DeviceResponse result = deviceLogic.addDevice(addDeviceRequest);

    log.info("Exiting addDevice. response {}", result);
    return ResponseEntity.status(HttpStatus.OK).body(result);

  }

  @GetMapping("")
  public ResponseEntity<GetAllDevicesResponse> getAllDevices() {
    log.info("Invoke getAllDevices");
    /*
    Get all devices from the logic class
     */
    GetAllDevicesResponse result = deviceLogic.getAllDevices();
    /*
    returning the response as 200 OK
     */
    log.info("Exiting getAllDevices. response {}", result);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }
}
