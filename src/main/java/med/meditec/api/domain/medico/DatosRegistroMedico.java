package med.meditec.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.meditec.api.domain.direccion.DatosDireccion;

public record DatosRegistroMedico(
        // también existe la anotación NotNull, pero NotBlank
        // internamente también verifica el null
        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefono,
        @NotBlank
        @Pattern(regexp = "\\d{4,8}")
        String documento,
        @NotNull
        Especialidad especialidad,
        //Aquí NotNull porque es un objeto
        @NotNull
        @Valid
        DatosDireccion direccion
) {}
