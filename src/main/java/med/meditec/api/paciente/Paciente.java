package med.meditec.api.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.meditec.api.direccion.Direccion;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    @Embedded
    private Direccion direccion;
    private Boolean activo;

    public Paciente(DatosRegistroPaciente datosPaciente) {
        this.activo=true;
        this.nombre=datosPaciente.nombre();
        this.email=datosPaciente.email();
        this.telefono=datosPaciente.telefono();
        this.documento=datosPaciente.documento();
        this.direccion= new Direccion(datosPaciente.direccion());
    }

    public void actualizarDatos(DatosActualizarPaciente datosActualizarPaciente) {
        if(datosActualizarPaciente.nombre()!=null){
            this.nombre= datosActualizarPaciente.nombre();
        }
        if (datosActualizarPaciente.documento() != null) {
            this.documento= datosActualizarPaciente.documento();
        }
        if(datosActualizarPaciente.direccion()!=null){
            this.direccion= direccion.actualizarDatos(datosActualizarPaciente.direccion());
        }
    }

    public void desactivarPaciente() {
        this.activo=false;
    }
}
