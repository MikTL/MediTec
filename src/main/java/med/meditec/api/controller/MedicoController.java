package med.meditec.api.controller;

import med.meditec.api.medico.DatosRegistroMedico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/medicos")
public class MedicoController {

    /*
    Usando el patron DTO, porque estamos usando en el controller un objeto como intermediario
    para mapear nuestra información que nos llega desde el cliente. En este caso estamos usando
    el objeto DatosRegistroMedico.
    */
    @PostMapping
    public void registrarMedico(@RequestBody DatosRegistroMedico datosRegistroMedico) {
        System.out.println("El request llego correctamente");
        System.out.println(datosRegistroMedico);
    }
}
