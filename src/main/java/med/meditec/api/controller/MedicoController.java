package med.meditec.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.meditec.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public Page<DatosListadoMedico> listaMedicos( @PageableDefault(size = 3) Pageable pageable){
        return medicoRepository.findAll(pageable).map(DatosListadoMedico::new);
    }
    @PutMapping
    @Transactional
    public void actualizarMedico(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico){
        Medico medico=medicoRepository.getReferenceById(datosActualizarMedico.id());
        medico.actualizarDatos(datosActualizarMedico);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void borrarMedico(@PathVariable Long id){
        Medico medico=medicoRepository.getReferenceById(id);
        medicoRepository.delete(medico);
    }
}
