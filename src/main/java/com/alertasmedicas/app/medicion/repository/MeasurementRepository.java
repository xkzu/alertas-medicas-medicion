package com.alertasmedicas.app.medicion.repository;

import com.alertasmedicas.app.medicion.entity.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    List<Measurement> findAllByIdPatient(Long idPatient);
}
