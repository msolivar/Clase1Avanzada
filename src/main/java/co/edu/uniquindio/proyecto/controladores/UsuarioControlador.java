package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.CrearUsuarioDTO;
import co.edu.uniquindio.proyecto.dto.EditarUsuarioDTO;
import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import co.edu.uniquindio.proyecto.servicios.impl.UsuarioServicioImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //1) Instanciar Clase Controlador
@RequestMapping("/api/usuarios") //2) accessPoint endPoint
@RequiredArgsConstructor

public class UsuarioControlador {
    private final UsuarioServicioImpl usuarioServicio; //3) instanciar usuarioServicio

    //Medodo CRUD
    @PostMapping
    public ResponseEntity<MensajeDTO<String>> crear(@Valid @RequestBody CrearUsuarioDTO cuenta) throws Exception {
        usuarioServicio.crear(cuenta); //Logica Del Negocio
        return ResponseEntity.ok(new MensajeDTO<>(false, "Su registro ha sido exitoso"));
    }

    @PutMapping
    public ResponseEntity<MensajeDTO<String>> editar(@Valid @RequestBody EditarUsuarioDTO cuenta) throws Exception {
        usuarioServicio.editar(cuenta);
        return ResponseEntity.ok(new MensajeDTO<>(false, "Cuenta editada exitosamente"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensajeDTO<String>> eliminar(@PathVariable String id) throws Exception {
        usuarioServicio.eliminar(id);
        return ResponseEntity.ok(new MensajeDTO<>(false, "Cuenta eliminada exitosamente"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MensajeDTO<UsuarioDTO>> obtener(@PathVariable String id) throws Exception {
        UsuarioDTO info = usuarioServicio.obtener(id);
        return ResponseEntity.ok(new MensajeDTO<>(false, info));
    }

    @GetMapping
    public ResponseEntity<MensajeDTO<List<UsuarioDTO>>> listarTodos() {
        List<UsuarioDTO> lista = usuarioServicio.listarTodos();
        return ResponseEntity.ok(new MensajeDTO<>(false, lista));
    }

    //Filtrar por Nombre y Ciudad
    @GetMapping("/buscar")
    public ResponseEntity<MensajeDTO<List<UsuarioDTO>>> listarTodosPorNombreYCiudad(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String ciudad
    ) {
        List<UsuarioDTO> usuarios = usuarioServicio.listarTodosPorNombreYCiudad(nombre, ciudad);
        return ResponseEntity.ok(new MensajeDTO<>(false, usuarios));
    }

}
