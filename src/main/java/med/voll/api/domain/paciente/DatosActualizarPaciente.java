package med.voll.api.domain.paciente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.direccion.DatosDireccion;

public record DatosActualizarPaciente(
        @NotNull
        Long id,
        @NotBlank
        String nombre,
        @NotBlank @Pattern(regexp = "\\d{8,10}")
        String documento,
        DatosDireccion direccion
) {
}
