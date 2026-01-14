package com.salesianostriana.dam.ClinicFlow.services;

import com.salesianostriana.dam.ClinicFlow.Enum.EstadoCita;
import com.salesianostriana.dam.ClinicFlow.Models.Cita;
import com.salesianostriana.dam.ClinicFlow.Repository.CitaRepository;
import com.salesianostriana.dam.ClinicFlow.Repository.ConsultaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final CitaRepository citaRepository;
    private final ConsultaRepository consultaRepository;

    public void registrarConsulta(Long idCita) {

        Cita cita = citaRepository.findById(idCita)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

        if(!citaRepository.existsById(cita.getId())) {
            throw new RuntimeException("Cita no encontrada");
        }

        if(cita.getEstado() == EstadoCita.CANCELADA || cita.getEstado() == EstadoCita.ATENDIDA) {
            throw new RuntimeException("No se puede registrar una consulta para una cita cancelada o ya atendida");
        }

        if(cita.getEstado() == EstadoCita.PROGRAMADA) {
            cita.setEstado(EstadoCita.ATENDIDA);
            citaRepository.save(cita);
        }

    }
}
