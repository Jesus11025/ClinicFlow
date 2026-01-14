package com.salesianostriana.dam.ClinicFlow.DTO;

import java.time.LocalDateTime;

public record CreateCitaRequest(
        LocalDateTime fechaHora,
        Long idPaciente,
        Long idProfesional
) {
}
