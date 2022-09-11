package com.cardiodiagnostics.heartmonitorapi.study;

import com.cardiodiagnostics.heartmonitorapi.study.device.DeviceEntity;
import com.cardiodiagnostics.heartmonitorapi.study.device.DeviceRepository;
import com.cardiodiagnostics.heartmonitorapi.study.device.response.DeviceResponse;
import com.cardiodiagnostics.heartmonitorapi.study.patient.PatientEntity;
import com.cardiodiagnostics.heartmonitorapi.study.patient.PatientRepository;
import com.cardiodiagnostics.heartmonitorapi.study.patient.response.PatientResponse;
import com.cardiodiagnostics.heartmonitorapi.study.request.AddStudyRequest;
import com.cardiodiagnostics.heartmonitorapi.study.response.GetAllStudiesResponse;
import com.cardiodiagnostics.heartmonitorapi.study.response.StudyResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Log4j2
public class StudyLogic {

  private final StudyRepository studyRepository;
  private final PatientRepository patientRepository;
  private final DeviceRepository deviceRepository;

  protected StudyResponse addStudy(AddStudyRequest request) {

    Optional<PatientEntity> patientOptional = patientRepository.findById(request.getPatientId());
    if (patientOptional.isEmpty()) {
      throw new RuntimeException("Patient Not Found");
    }
    Optional<DeviceEntity> deviceOptional = deviceRepository.findById(request.getDeviceId());
    if (deviceOptional.isEmpty()) {
      throw new RuntimeException("Device Not Found");
    }
    StudyEntity studyEntity = new StudyEntity();
    studyEntity.setDevice(deviceOptional.get());
    studyEntity.setPatient(patientOptional.get());
    studyEntity.setName(request.getName());
    studyEntity.setStartTime(request.getStartTime());
    studyEntity.setEndTime(request.getEndTime());

    studyRepository.save(studyEntity);

    return mapStudyResponse(studyEntity);
  }

  protected GetAllStudiesResponse getAll() {

    List<StudyEntity> studyEntities = studyRepository.findAll();

    List<StudyResponse> studyResponses = studyEntities
        .parallelStream()
        .map(this::mapStudyResponse)
        .collect(Collectors.toList());

    GetAllStudiesResponse getAllStudiesResponse = new GetAllStudiesResponse();
    getAllStudiesResponse.setStudies(studyResponses);
    return getAllStudiesResponse;
  }

  private StudyResponse mapStudyResponse(StudyEntity studyEntity) {
    /*
    Fill Patient info
     */
    PatientResponse patientResponse = new PatientResponse();
    patientResponse.setId(studyEntity.getPatient().getId());
    patientResponse.setName(studyEntity.getPatient().getName());
    /*
    Fill device info
     */
    DeviceResponse deviceResponse = new DeviceResponse();
    deviceResponse.setId(studyEntity.getDevice().getId());
    deviceResponse.setSerial(studyEntity.getDevice().getSerial());
    /*
    Fill Study response info
     */
    StudyResponse studyResponse = new StudyResponse();
    studyResponse.setPatient(patientResponse);
    studyResponse.setDevice(deviceResponse);
    studyResponse.setName(studyEntity.getName());
    studyResponse.setStartTime(studyEntity.getStartTime());
    studyResponse.setEndTime(studyEntity.getEndTime());
    studyResponse.setId(studyEntity.getId());
    return studyResponse;
  }
}
