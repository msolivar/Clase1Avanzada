package co.edu.uniquindio.proyecto.servicios.impl;
import co.edu.uniquindio.proyecto.dto.CrearUsuarioDTO;
import co.edu.uniquindio.proyecto.dto.EditarUsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {
    //TODO implementar todos los métodos de la interfaz
    private final List<UsuarioDTO> usuarios = new ArrayList<>();

    @Override
    public void crear(CrearUsuarioDTO cuenta) {
        UsuarioDTO usuario = new UsuarioDTO(
                String.valueOf(usuarios.size() + 1),
                cuenta.nombre(),
                cuenta.telefono(),
                cuenta.ciudad(),
                cuenta.direccion(),
                cuenta.email()
        );
        usuarios.add(usuario);
    }

    @Override
    public void editar(EditarUsuarioDTO cuenta) {
        usuarios.replaceAll(usuario -> usuario.id().equals(cuenta.id()) ?
                new UsuarioDTO(cuenta.id(), cuenta.nombre(), cuenta.telefono(), cuenta.ciudad(), cuenta.direccion(), usuario.email()) : usuario);
    }

    @Override
    public void eliminar(String id) {
        usuarios.removeIf(usuario -> usuario.id().equals(id));
    }

    @Override
    public UsuarioDTO obtener(String id) {
        return usuarios.stream().filter(usuario -> usuario.id().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<UsuarioDTO> listarTodos() {
        return new ArrayList<>(usuarios);
    }

    @Override
    public List<UsuarioDTO> listarTodosPorNombreYCiudad(String nombre, String ciudad) {
        return usuarios.stream()
                .filter(usuario -> usuario.nombre().equalsIgnoreCase(nombre) && usuario.ciudad().equalsIgnoreCase(ciudad))
                .collect(Collectors.toList());
    }

}

