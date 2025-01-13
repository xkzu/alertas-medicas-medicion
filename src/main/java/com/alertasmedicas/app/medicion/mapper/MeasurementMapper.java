package com.alertasmedicas.app.medicion.mapper;

import com.alertasmedicas.app.medicion.dto.MeasurementDTO;
import com.alertasmedicas.app.medicion.entity.Measurement;

public class MeasurementMapper {

    private MeasurementMapper() {}

    public static MeasurementDTO toDTO(Measurement measurement) {
        return new MeasurementDTO(
                measurement.getId(),
                measurement.getIdPatient(),
                measurement.getIdSing(),
                measurement.getMeasurementValue(),
                measurement.getDateTime()
        );
    }

    public static Measurement toMeasurement(MeasurementDTO measurementDTO) {
        return new Measurement(
                measurementDTO.id(),
                measurementDTO.idPatient(),
                measurementDTO.idSing(),
                measurementDTO.measurementValue(),
                measurementDTO.dateTime()
        );
    }
}
