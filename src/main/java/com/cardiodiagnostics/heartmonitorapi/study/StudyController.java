package com.cardiodiagnostics.heartmonitorapi.study;

import com.cardiodiagnostics.heartmonitorapi.study.request.AddStudyRequest;
import com.cardiodiagnostics.heartmonitorapi.study.response.GetAllStudiesResponse;
import com.cardiodiagnostics.heartmonitorapi.study.response.StudyResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "study")
@Validated
@Tag(name = "Study Controller")
@Log4j2
@AllArgsConstructor
public class StudyController {

  private final StudyLogic studyLogic;

  @PostMapping
  public ResponseEntity<StudyResponse> addStudy(@RequestBody @Valid AddStudyRequest request) {
    log.info("Invoke addStudy");

    StudyResponse result = studyLogic.addStudy(request);

    log.info("Exiting addStudy. response {}", result);
    return ResponseEntity.status(HttpStatus.OK).body(result);

  }

  @GetMapping("")
  public ResponseEntity<GetAllStudiesResponse> getAllStudies() {
    log.info("Invoke getAllStudies");
    /*
    Get all studies from the logic class
     */
    GetAllStudiesResponse result = studyLogic.getAll();
    /*
    returning the response as 200 OK
     */
    log.info("Exiting getAllStudies. response {}", result);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }
}
