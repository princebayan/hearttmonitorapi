package com.cardiodiagnostics.heartmonitorapi.study;

import com.cardiodiagnostics.heartmonitorapi.study.device.DeviceEntity;
import com.cardiodiagnostics.heartmonitorapi.study.patient.PatientEntity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "study")
@Getter
@Setter
@NoArgsConstructor
public class StudyEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "name")
  private String name;
  @Column(name = "start_time")
  private Date startTime;
  @Column(name = "end_time")
  private Date endTime;
  @Column(name = "low_heart_rate")
  private int lowHeartRate;
  @Column(name = "high_heart_rate")
  private int highHeartRate;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "device_id")
  private DeviceEntity device;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "patient_id")
  private PatientEntity patient;
}
