package com.cardiodiagnostics.heartmonitorapi.study.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAllStudiesResponse {

  private List<StudyResponse> studies;
}
