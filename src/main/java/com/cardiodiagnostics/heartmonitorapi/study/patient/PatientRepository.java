package com.cardiodiagnostics.heartmonitorapi.study.patient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {


}
