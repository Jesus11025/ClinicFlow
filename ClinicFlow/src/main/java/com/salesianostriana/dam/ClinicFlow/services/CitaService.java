package com.salesianostriana.dam.ClinicFlow.services;

import com.salesianostriana.dam.ClinicFlow.Enum.EstadoCita;
import com.salesianostriana.dam.ClinicFlow.Models.Cita;
import com.salesianostriana.dam.ClinicFlow.Models.Profesional;
import com.salesianostriana.dam.ClinicFlow.Repository.CitaRepository;
import com.salesianostriana.dam.ClinicFlow.Repository.ProfesionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CitaService {

    private final CitaRepository citaRepository;
    private final ProfesionalRepository profesionalRepository;

    public Optional<Cita> crearCita(Cita cita, Profesional profesional) {

        if(profesionalRepository.existsByProfesionalIdAndHora(profesional.getId(), cita.getFechaHora())) {
            throw new RuntimeException("El profesional ya tiene una cita a esa hora.");
        }

        if(citaRepository.existsByPacienteIdAndFechaBetween(cita.getPaciente().getId(), cita.getFechaHora())) {
            throw new RuntimeException("El paciente ya tiene una cita en esa fecha.");
        }

        if(cita.getFechaHora().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("No se pueden crear citas en el pasado.");
        }

        return Optional.of(citaRepository.save(cita));
    }

    public void cancelarCita(Long idCita) {
        Cita cita = citaRepository.findById(idCita)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

        if(cita.getEstado() == EstadoCita.ATENDIDA) {
            throw new RuntimeException("No se puede cancelar una cita que ya ha sido atendida.");
        } else if (cita.getEstado() == EstadoCita.CANCELADA) {
            throw new RuntimeException("La cita ya ha sido cancelada.");
        } else {
            cita.setEstado(EstadoCita.CANCELADA);
            citaRepository.save(cita);
        }

    }



}
