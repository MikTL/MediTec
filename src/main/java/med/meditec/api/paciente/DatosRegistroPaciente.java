package med.meditec.api.paciente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.meditec.api.direccion.DatosDireccion;

public record DatosRegistroPaciente(
        @NotBlank
        String nombre,
        @NotBlank
        String email,
        @NotBlank
        String telefono,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String documento,
        @NotNull
        DatosDireccion direccion
) {}
