package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record EditarUsuarioDTO(

        //Generar Validaciones Sobre el atributo
        //@NotBlank @Length(max = 100) Sin Espacios Maximo 100 caracteres

        @NotBlank String id,
        @NotBlank @Length(max = 100) String nombre,
        @Length(max = 10) String telefono,
        @NotBlank @Length(max = 100) String ciudad,
        @NotBlank @Length(max = 100) String direccion
) {
}
