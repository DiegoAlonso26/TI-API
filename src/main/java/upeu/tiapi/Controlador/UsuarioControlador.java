package upeu.tiapi.Controlador;


import org.springframework.http.HttpStatus;
import upeu.tiapi.Entity.Usuario;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;
import upeu.tiapi.Servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api-ti")
@CrossOrigin(origins = "*")
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
    public ResponseEntity<Usuario> actualizar(@PathVariable Integer id, @RequestBody Usuario usuario) {
        if(!usuarioServicio.buscarPorId(id).isPresent()) {
            throw new RecursoNoEncontradoExcepcion("No se encontró el usuario con el id: " + id);

        }
        usuario.setIdUsuario(id);
        usuarioServicio.actualizar(usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            usuarioServicio.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (RecursoNoEncontradoExcepcion e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
