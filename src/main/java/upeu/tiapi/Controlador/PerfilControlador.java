package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Perfil;
import upeu.tiapi.Servicio.IPerfilesServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-ti")
@CrossOrigin(origins = "*")
public class PerfilControlador {
    @Autowired
    private IPerfilesServicio perfilesServicio;

    @GetMapping("/perfiles")
    public List<Perfil> perfiles() {
        return perfilesServicio.buscarTodos();
    }

    @GetMapping("/perfiles/{id}")
    public Optional<Perfil> perfile(@PathVariable Integer id) {
        return perfilesServicio.buscarPorId(id);
    }

    @PostMapping("/perfiles")
    public void guardar(@RequestBody Perfil perfil) {
        perfilesServicio.guardar(perfil);
    }

    @PutMapping("/perfiles/{id}")
    public ResponseEntity<Perfil> editar(@PathVariable Integer id, @RequestBody Perfil perfil) {
        if(!perfilesServicio.buscarPorId(id).isPresent()) {
            throw new RecursoNoEncontradoExcepcion("No se encontró el perfil con el id: " + id);

        }
        perfil.setId(id);
        perfilesServicio.actualizar(perfil);
        return ResponseEntity.ok(perfil);
    }

    @DeleteMapping("/perfiles/{id}")
    public String eliminar(@PathVariable Integer id) {
        perfilesServicio.eliminar(id);
        return "Perfil eliminado con id: " + id;
    }


}
