package com.salesianostriana.dam.ClinicFlow.Controllers;

import com.salesianostriana.dam.ClinicFlow.Models.Cita;
import com.salesianostriana.dam.ClinicFlow.Models.Paciente;
import com.salesianostriana.dam.ClinicFlow.services.CitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pacientes/")
@RequiredArgsConstructor
public class PacienteController {


    @GetMapping("{id}/citas")
    public List<Cita> listarCitasDePaciente(Paciente paciente) {
        return paciente.getCitas();
    }

}
