package med.meditec.api.domain.paciente;

import jakarta.validation.constraints.NotNull;
import med.meditec.api.domain.direccion.DatosDireccion;

public record DatosActualizarPaciente(
        @NotNull
        Long id,
        String nombre,
        String documento,
        DatosDireccion direccion) {
}
