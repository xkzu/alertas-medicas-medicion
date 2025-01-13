package com.alertasmedicas.app.medicion.service;

import com.alertasmedicas.app.medicion.dto.MeasurementDTO;

import java.util.List;

public interface MeasurementService {

    List<MeasurementDTO> getMeasurementsAsDTOByIdPatient(Long idPatient);

    MeasurementDTO saveMeasurementAsDTO(MeasurementDTO measurementDTO);
}
