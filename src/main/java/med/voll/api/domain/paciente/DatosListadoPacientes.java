package med.voll.api.domain.paciente;

public record DatosListadoPacientes(
        String nombre,
        String documento,
        String email
) {
    public DatosListadoPacientes(DatosListadoPacientes datosListadoPacientes) {
        this(datosListadoPacientes.nombre, datosListadoPacientes.documento(), datosListadoPacientes.email());
    }
}
