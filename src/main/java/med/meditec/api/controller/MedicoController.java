package med.meditec.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.meditec.api.domain.direccion.DatosDireccion;
import med.meditec.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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
    public ResponseEntity<DatosRespuestaMedico> registrarMedico(
            @RequestBody @Valid DatosRegistroMedico datosRegistroMedico,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        System.out.println("El request llego correctamente");
        //Para las buenas prácticas REST
        /*Return 201 Created, URL para encontrar el médico, */
        Medico medico = medicoRepository.save(new Medico(datosRegistroMedico));
        DatosRespuestaMedico datosRespuestaMedico= new DatosRespuestaMedico(
                medico.getId(),
                medico.getNombre(),
                medico.getEmail(),
                medico.getTelefono(),
                medico.getDocumento(),
                medico.getEspecialidad().toString(),
                new DatosDireccion(
                    medico.getDireccion().getCalle(),
                    medico.getDireccion().getDistrito(),
                    medico.getDireccion().getCiudad(),
                    medico.getDireccion().getNumero(),
                    medico.getDireccion().getComplemento()
                )
        );
        //URI url="http://localhost:8080/medicos/" + medico.getId();
        URI uri= uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(datosRespuestaMedico);
    }
    @GetMapping
    public ResponseEntity<Page<DatosListadoMedico>> listaMedicos(@PageableDefault(size = 3) Pageable pageable){
        //return medicoRepository.findAll(pageable).map(DatosListadoMedico::new);
        return ResponseEntity.ok(medicoRepository.findByActivoTrue(pageable).map(DatosListadoMedico::new));
    }
    @PutMapping
    @Transactional
    public ResponseEntity actualizarMedico(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico){
        Medico medico=medicoRepository.getReferenceById(datosActualizarMedico.id());
        medico.actualizarDatos(datosActualizarMedico);
        return ResponseEntity.ok(
                new DatosRespuestaMedico(
                        medico.getId(),
                        medico.getNombre(),
                        medico.getEmail(),
                        medico.getTelefono(),
                        medico.getDocumento(),
                        medico.getEspecialidad().toString(),
                        new DatosDireccion(
                            medico.getDireccion().getCalle(),
                            medico.getDireccion().getDistrito(),
                            medico.getDireccion().getCiudad(),
                            medico.getDireccion().getNumero(),
                            medico.getDireccion().getComplemento()
                        )
                )
        );
    }
    //DElETE LÓGICO
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity borrarMedico(@PathVariable Long id){
        Medico medico=medicoRepository.getReferenceById(id);
        medico.desactivarMedico();
        return ResponseEntity.noContent().build();
    }
    //DELETE en BASE de Datos
    /*
    public void borrarMedico(@PathVariable Long id){
        Medico medico=medicoRepository.getReferenceById(id);
        medicoRepository.delete(medico);
    }
    */
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaMedico> retornarDatosMedico(@PathVariable Long id){
        Medico medico=medicoRepository.getReferenceById(id);
        var datosMedico= new DatosRespuestaMedico(
                medico.getId(),
                medico.getNombre(),
                medico.getEmail(),
                medico.getTelefono(),
                medico.getDocumento(),
                medico.getEspecialidad().toString(),
                new DatosDireccion(
                    medico.getDireccion().getCalle(),
                    medico.getDireccion().getDistrito(),
                    medico.getDireccion().getCiudad(),
                    medico.getDireccion().getNumero(),
                    medico.getDireccion().getComplemento()
                )
        );
        return ResponseEntity.ok(datosMedico);
    }
}
