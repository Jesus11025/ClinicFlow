package com.salesianostriana.dam.ClinicFlow.Repository;

import com.salesianostriana.dam.ClinicFlow.Models.Cita;
import com.salesianostriana.dam.ClinicFlow.Models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {

    boolean existsByPacienteIdAndFechaBetween(Long pacienteId, LocalDateTime fechaDia);

    List<Cita> findByPaciente(Paciente paciente);

    List<Cita> findByEstado(String estado);

    List<Cita> findByFechaBetween(LocalDateTime inicio, LocalDateTime fin);

    @Query("SELECT c FROM Cita c " +
            "JOIN FETCH c.paciente " +
            "WHERE c.profesional.id = :profesionalId " +
            "ORDER BY c.fecha ASC")
    List<Cita> findAgendaProfesionalConPaciente(
            @Param("profesionalId") Long profesionalId,
            @Param("fecha") LocalDate fecha
    );


}
