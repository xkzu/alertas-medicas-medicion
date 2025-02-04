package com.alertasmedicas.app.medicion.controller;

import com.alertasmedicas.app.medicion.dto.MeasurementDTO;
import com.alertasmedicas.app.medicion.service.MeasurementService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/measurement")
public class MeasurementController {

    private final MeasurementService measurementService;

    @Autowired
    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping("/getMeasurements/{idPatient}")
    public ResponseEntity<List<MeasurementDTO>> getMeasurements(@PathVariable Long idPatient) {
        log.info("Obteniendo todas las mediciones con id paciente {}", idPatient);
        try {
            List<MeasurementDTO> measurements = measurementService.getMeasurementsAsDTOByIdPatient(idPatient);
            log.info("Lista de mediciones asignados al paciente obtenida exitosamente. Total: {} pacientes.", measurements.size());
            return ResponseEntity.ok(measurements);
        } catch (Exception e) {
            log.error("Error al obtener las mediciones: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<MeasurementDTO> addMeasurement(@RequestBody MeasurementDTO measurementDTO) {
        log.info("Registrando la medicion {}", measurementDTO);
        try {
            MeasurementDTO dto = measurementService.saveMeasurementAsDTO(measurementDTO);
            log.info("Medicion registrada exitosamente {}", dto);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            log.error("Error al registrar la medicion: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
