package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

//record -> Encaptusa Los objetos de la clase CrearUsuarioDTO
public record CrearUsuarioDTO(

        //Generar Validaciones Sobre el atributo
        //@NotBlank @Length(max = 100) Sin Espacios Maximo 100 caracteres

        @NotBlank @Length(max = 100) String nombre,
        @Length(max = 10) String telefono,
        @NotBlank @Length(max = 100) String ciudad,
        @NotBlank @Length(max = 100) String direccion,
        @NotBlank @Length(max = 50) @Email String email,
        @NotBlank @Length(min = 7, max = 20) String password
) {
}
