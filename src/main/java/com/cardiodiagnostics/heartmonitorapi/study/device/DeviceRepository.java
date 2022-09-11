package com.cardiodiagnostics.heartmonitorapi.study.device;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<DeviceEntity, Long> {

}
