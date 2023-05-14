package med.meditec.api.domain.paciente;

import med.meditec.api.domain.direccion.DatosDireccion;

public record DatosRespuestaPaciente(
        Long id,
        String nombre,
        String email,
        String telefono,
        String docuemento,
        DatosDireccion direccion

) {}
