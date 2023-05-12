package med.meditec.api.medico;

import jakarta.validation.constraints.NotNull;
import med.meditec.api.direccion.DatosDireccion;

public record DatosActualizarMedico(
        @NotNull Long id,
        String nombre,
        String documento,
        DatosDireccion direccion
) {}
