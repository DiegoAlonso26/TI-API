package upeu.tiapi.Controlador;


import upeu.tiapi.Entity.Usuario;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;
import upeu.tiapi.Servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public Usuario editar(@RequestBody Usuario usuario) {
        return usuarioServicio.actualizar(usuario);

    }

    @DeleteMapping("/usuarios/{id}")
    public void eliminar(@PathVariable Integer id) {
        usuarioServicio.eliminar(id);
    }
}
