package com.salesianostriana.dam.ClinicFlow.Repository;

import com.salesianostriana.dam.ClinicFlow.Models.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface CitaRepository extends JpaRepository<Cita, Long> {

    boolean existsByPacienteIdAndFechaBetween(Long pacienteId, LocalDateTime fechaDia);

}
