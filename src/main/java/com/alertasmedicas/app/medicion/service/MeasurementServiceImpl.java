package com.alertasmedicas.app.medicion.service;

import com.alertasmedicas.app.medicion.dto.MeasurementDTO;
import com.alertasmedicas.app.medicion.entity.Measurement;
import com.alertasmedicas.app.medicion.mapper.MeasurementMapper;
import com.alertasmedicas.app.medicion.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementServiceImpl implements MeasurementService {

    private final MeasurementRepository measurementRepository;

    @Autowired
    public MeasurementServiceImpl(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    @Override
    public List<MeasurementDTO> getMeasurementsAsDTOByIdPatient(Long idPatient) {
        return getMeasurements(idPatient)
                .stream()
                .map(MeasurementMapper::toDTO)
                .toList();
    }

    @Override
    public MeasurementDTO saveMeasurementAsDTO(MeasurementDTO measurementDTO) {
        Measurement measurement = MeasurementMapper.toMeasurement(measurementDTO);
        return MeasurementMapper.toDTO(measurementRepository.save(measurement));
    }

    private List<Measurement> getMeasurements(Long idPatient) {
        return measurementRepository.findAllByIdPatient(idPatient);
    }
}
