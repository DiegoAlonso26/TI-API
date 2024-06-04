package upeu.tiapi.Controlador;


import upeu.tiapi.Entity.Usuario;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;
import upeu.tiapi.Servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api-ti")
public class UsuarioControlador {
    @Autowired
    private IUsuarioServicio usuarioServicio;

    @GetMapping("/usuarios")
    public List<Usuario> listar() {
        return usuarioServicio.buscarTodos();
    }

    @PostMapping("/usuarios")
    public Usuario guardar(@RequestBody Usuario usuario) {
        return usuarioServicio.guardar(usuario);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Integer id) {
        Usuario usuario = usuarioServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el usuario con el id: " + id));
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Integer id, @RequestBody Usuario usuarioRecibido) {
        Usuario usuario = usuarioServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el usuario con el id: " + id));
        usuario.setNombre(usuarioRecibido.getNombre());
        usuario.setEmail(usuarioRecibido.getEmail());
        usuario.setContraseña(usuarioRecibido.getContraseña());
        Usuario usuarioActualizado = usuarioServicio.guardar(usuario);
        return ResponseEntity.ok(usuarioActualizado);
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminar(@PathVariable Integer id) {
        Usuario usuario = usuarioServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el usuario con el id: " + id));
        usuarioServicio.eliminar(id);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
