package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.direccion.DatosDireccion;

public record DatosActualizarMedico(
        @NotNull
        Long id,
        @NotBlank
        String nombre,
        @NotBlank
        String documento,
        @NotNull @Valid
        DatosDireccion direccion
) {
}
