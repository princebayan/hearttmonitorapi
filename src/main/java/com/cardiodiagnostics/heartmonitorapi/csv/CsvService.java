package com.cardiodiagnostics.heartmonitorapi.csv;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CsvService {

  @Autowired
  CsvRepository repository;

  public void save(MultipartFile file) {
    try {
      List<CsvEntity> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
      repository.saveAll(tutorials);
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }

  public List<CsvEntity> getAllTutorials() {
    return repository.findAll();
  }
}