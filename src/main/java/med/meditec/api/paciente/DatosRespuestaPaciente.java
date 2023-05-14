package med.meditec.api.paciente;

import med.meditec.api.direccion.DatosDireccion;

public record DatosRespuestaPaciente(
        Long id,
        String nombre,
        String email,
        String telefono,
        String docuemento,
        DatosDireccion direccion

) {}
