package com.salesianostriana.dam.ClinicFlow.DTO;

import com.salesianostriana.dam.ClinicFlow.Enum.EstadoCita;
import com.salesianostriana.dam.ClinicFlow.Models.Cita;

import java.time.LocalDateTime;

public record CitaListDto(
        Long id,
        LocalDateTime fechaHora,
        EstadoCita estado,
        String nombrePaciente,
        String nombreProfesional
) {
    public static CitaListDto of(Cita cita) {
        return new CitaListDto(
                cita.getId(),
                cita.getFechaHora(),
                cita.getEstado(),
                cita.getPaciente().getNombre(),
                cita.getProfesional().getNombre()
        );
    }
}
