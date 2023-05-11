package med.meditec.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.meditec.api.medico.DatosListadoMedico;
import med.meditec.api.medico.DatosRegistroMedico;
import med.meditec.api.medico.Medico;
import med.meditec.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    //autowired no recomendado por fines de testing, lo que hace es inyectar las dependencias en una clase
    @Autowired
    private MedicoRepository medicoRepository;

    /*
    Usando el patron DTO, porque en el controller usamos un objeto como intermediario
    para mapear nuestra información que nos llega desde el cliente. En este caso estamos usando
    el objeto DatosRegistroMedico.
    */
    @PostMapping
    @Transactional
    public void registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico) {
        System.out.println("El request llego correctamente");
        medicoRepository.save(new Medico(datosRegistroMedico));
    }
    @GetMapping
    public List<DatosListadoMedico> listaMedicos(){
        return medicoRepository.findAll().stream().map(DatosListadoMedico::new).toList();
    }
}
