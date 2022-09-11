package com.cardiodiagnostics.heartmonitorapi.csv;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "heart_rate_record")
@Getter
@Setter
@NoArgsConstructor
public class CsvEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long id;
  @Column(name = "rate")
  private int rate;
  @Column(name = "record_date")
  private Date recordDate;
  @Column(name = "study_id")
  private int study;

}
