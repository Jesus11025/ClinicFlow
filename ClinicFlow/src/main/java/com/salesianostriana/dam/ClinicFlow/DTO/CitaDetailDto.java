package com.salesianostriana.dam.ClinicFlow.DTO;

import com.salesianostriana.dam.ClinicFlow.Models.Cita;

public record CitaDetailDto(
        Long id,
        String fecha,
        String hora,
        String estado,
        String nombrePaciente,
        String nombreProfesional
) {

    public static CitaDetailDto of(Cita cita) {
        return new CitaDetailDto(
                cita.getId(),
                cita.getFechaHora().toLocalDate().toString(),
                cita.getFechaHora().toLocalTime().toString(),
                cita.getEstado().name(),
                cita.getPaciente().getNombre(),
                cita.getProfesional().getNombre()
        );
    }
}