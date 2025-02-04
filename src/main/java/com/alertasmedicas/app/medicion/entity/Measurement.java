package com.alertasmedicas.app.medicion.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "medicion", schema = "admin")
@NoArgsConstructor
@AllArgsConstructor
public class Measurement {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_paciente")
    private Long idPatient;

    @Column(name = "id_signo")
    private Long idSing;

    @Column(name = "medicion")
    private double measurementValue;

    @Column(name = "fecha_hora")
    private LocalDateTime dateTime;
}
