package med.meditec.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.meditec.api.paciente.DatosRegistroPaciente;
import med.meditec.api.paciente.Paciente;
import med.meditec.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepository;
    @PostMapping
    @Transactional
   public void registrar(@RequestBody @Valid DatosRegistroPaciente datosPaciente) {
        System.out.println(datosPaciente);
        pacienteRepository.save(new Paciente(datosPaciente));
    }
}
