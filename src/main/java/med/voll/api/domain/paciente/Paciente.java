package med.voll.api.domain.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.direccion.Direccion;
import med.voll.api.domain.medico.Especialidad;

@Entity(name = "Paciente")
@Table(name = "pacientes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
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
    private boolean activo = true;

    public Paciente(DatosRegistroPaciente registroPaciente) {
        this.nombre = registroPaciente.nombre();
        this.email = registroPaciente.email();
        this.telefono = registroPaciente.telefono();
        this.documento = registroPaciente.documento();
        this.direccion = new Direccion(registroPaciente.direccion());
    }

    public void actualizarDatos(DatosActualizarPaciente actualizarPaciente) {
        if (actualizarPaciente.nombre() != null) {
            this.nombre = actualizarPaciente.nombre();
        }
        if (actualizarPaciente.documento() != null) {
            this.documento = actualizarPaciente.documento();
        }
        if (actualizarPaciente.direccion() != null) {
            this.direccion = direccion.actualizarDireccion(actualizarPaciente.direccion());
        }
    }

    public void desactivarPaciente() {
        activo = false;
    }
}
