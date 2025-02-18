package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dto.CrearUsuarioDTO;
import co.edu.uniquindio.proyecto.dto.EditarUsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface UsuarioServicio {

//    void crear(@Valid CrearUsuarioDTO cuenta);
//
//    void editar(@Valid EditarUsuarioDTO cuenta);
//
//    void eliminar(String id);
//
//    UsuarioDTO obtener(String id);
//
//    List<UsuarioDTO> listarTodos();

    void crear(CrearUsuarioDTO cuenta) throws Exception;
    void editar(EditarUsuarioDTO cuenta) throws Exception;
    void eliminar(String id) throws Exception;
    UsuarioDTO obtener(String id) throws Exception;
    List<UsuarioDTO> listarTodos();
    List<UsuarioDTO> listarTodosPorNombreYCiudad(String nombre, String ciudad);
}
