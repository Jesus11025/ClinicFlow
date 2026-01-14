package com.salesianostriana.dam.ClinicFlow.Repository;

import com.salesianostriana.dam.ClinicFlow.Models.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ProfesionalRepository extends JpaRepository<Profesional, Long> {

    boolean existsByProfesionalIdAndHora(Long profesionalId, LocalDateTime hora);

}
