package com.cardiodiagnostics.heartmonitorapi.csv;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

@Log4j2
public class CSVHelper {

  public static String TYPE = "text/csv";
  static String[] HEADERs = {"Id", "Title", "Description", "Published"};

  public static boolean hasCSVFormat(MultipartFile file) {
    if (!TYPE.equals(file.getContentType())) {
      return false;
    }
    return true;
  }

  public static List<CsvEntity> csvToTutorials(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(
        new InputStreamReader(is, "UTF-8")); CSVParser csvParser = new CSVParser(fileReader,
        CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
      List<CsvEntity> tutorials = new ArrayList<CsvEntity>();
      Iterable<CSVRecord> csvRecords = csvParser.getRecords();
      DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.sss");

      for (CSVRecord csvRecord : csvRecords) {
        CsvEntity tutorial = new CsvEntity();
        tutorial.setRate(Integer.parseInt(csvRecord.get("rate")));
        tutorial.setRecordDate(df.parse(csvRecord.get("record_date")));
        tutorial.setStudy(Integer.parseInt(csvRecord.get("study")));
        tutorials.add(tutorial);
      }
      return tutorials;
    } catch (Exception e) {
      log.error("Exception in reading the records.", e);
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }
}