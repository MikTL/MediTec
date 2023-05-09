package med.meditec.api.medico;

import med.meditec.api.direccion.DatosDireccion;

public record DatosRegistroMedico(String nombre, String email,
                                  String documento, Especialidad especialidad, DatosDireccion direccion) {


}
