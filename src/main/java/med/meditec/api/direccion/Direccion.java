package med.meditec.api.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {
    private String calle;
    private String distrito;
    private String ciudad;
    private String numero;
    private String complemento;

    public Direccion(DatosDireccion direccion) {
        this.calle= direccion.calle();
        this.distrito=direccion.distrito();
        this.numero= direccion.numero();
        this.ciudad=direccion.ciudad();
        this.complemento=direccion.complemento();
    }
}
