package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Modulo;
import upeu.tiapi.Servicio.IModuloServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;


@RestController
@RequestMapping("/api-ti")
public class ModuloControlador {
    @Autowired
    private IModuloServicio moduloServicio;

    @GetMapping("/modulos")
    public List<Modulo> listar() {
        return moduloServicio.buscarTodos();
    }

    @PostMapping("/modulos")
    public Modulo guardar(@RequestBody Modulo modulo) {
        return moduloServicio.guardar(modulo);
    }

    @GetMapping("/modulos/{id}")
    public ResponseEntity<Modulo> buscarPorId(@PathVariable Integer id) {
        Modulo modulo = moduloServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el modulo con el id: " + id));
        return ResponseEntity.ok(modulo);
    }

    @PutMapping("/modulos/{id}")
    public ResponseEntity<Modulo> actualizar(@PathVariable Integer id, @RequestBody Modulo modulo) {
        if(!moduloServicio.buscarPorId(id).isPresent()) {
            throw new RecursoNoEncontradoExcepcion("No se encontró el modulo con el id: " + id);

        }
        modulo.setId(id);
        moduloServicio.actualizar(modulo);
        return ResponseEntity.ok(modulo);
    }

    @DeleteMapping("/modulos/{id}")
    public void eliminar(@PathVariable Integer id) {
        moduloServicio.eliminar(id);
    }
}
