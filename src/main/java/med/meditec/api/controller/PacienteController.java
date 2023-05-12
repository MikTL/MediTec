package med.meditec.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.meditec.api.paciente.DatosListadoPaciente;
import med.meditec.api.paciente.DatosRegistroPaciente;
import med.meditec.api.paciente.Paciente;
import med.meditec.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping
    public Page<DatosListadoPaciente> listaPacientes(@PageableDefault(size = 5,sort = "nombre") Pageable pageable){
        return pacienteRepository.findAll(pageable).map(DatosListadoPaciente::new);
    }
}
