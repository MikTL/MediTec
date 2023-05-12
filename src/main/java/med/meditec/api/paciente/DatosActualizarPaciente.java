package med.meditec.api.paciente;

import jakarta.validation.constraints.NotNull;
import med.meditec.api.direccion.DatosDireccion;

public record DatosActualizarPaciente(
        @NotNull
        Long id,
        String nombre,
        String documento,
        DatosDireccion direccion) {
}
