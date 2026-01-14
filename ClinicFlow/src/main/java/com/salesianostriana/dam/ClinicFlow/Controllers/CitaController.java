package com.salesianostriana.dam.ClinicFlow.Controllers;

import com.salesianostriana.dam.ClinicFlow.DTO.CitaResponse;
import com.salesianostriana.dam.ClinicFlow.Models.Cita;
import com.salesianostriana.dam.ClinicFlow.Repository.CitaRepository;
import com.salesianostriana.dam.ClinicFlow.services.CitaService;
import com.salesianostriana.dam.ClinicFlow.services.ConsultaService;
import jakarta.persistence.TableGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/citas/")
@RequiredArgsConstructor
public class CitaController {

    private final CitaService citaService;
    private final CitaRepository citaRepository;
    private final ConsultaService consultaService;

    @PostMapping
    public Optional<CitaResponse> crearCita(Cita cita, Long idProfesional) {
        return citaService.crearCita(cita, idProfesional);
    }

    @PutMapping("{id}/cancelar")
    public void cancelarCita(Long idCita) {
        citaService.cancelarCita(idCita);
    }

    @PostMapping("{id}/consulta")
    public void registrarConsulta(Long idCita) {
        consultaService.registrarConsulta(idCita);
    }

    @GetMapping
    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }

}
