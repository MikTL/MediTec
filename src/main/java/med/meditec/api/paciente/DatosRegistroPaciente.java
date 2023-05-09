package med.meditec.api.paciente;

import med.meditec.api.direccion.DatosDireccion;

public record DatosRegistroPaciente(String nombre, String email, String telefono, String documento, DatosDireccion direccion) {}
