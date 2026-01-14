package com.salesianostriana.dam.ClinicFlow.DTO;

import java.time.LocalDate;

public record CreateConsultaRequest(
    LocalDate fecha,
    String diagnostico,
    String observaciones,
    Long idCita
) {
}
