package com.salesianostriana.dam.ClinicFlow.DTO;

import com.salesianostriana.dam.ClinicFlow.Models.Cita;

public record CitaResponse(
    Long id,
    String motivo,
    String fechaHora,
    Long idPaciente,
    Long idProfesional
) {
    public static CitaResponse fromCita(Cita cita) {
        return new CitaResponse(
                cita.getId(),
                cita.getFechaHora().toString(),
                cita.getEstado().name(),
                cita.getPaciente() != null ? cita.getPaciente().getId() : null,
                cita.getProfesional() != null ? cita.getProfesional().getId() : null
        );
    }
}
