package com.cardiodiagnostics.heartmonitorapi.csv;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CsvRepository extends JpaRepository<CsvEntity, Integer> {

}
