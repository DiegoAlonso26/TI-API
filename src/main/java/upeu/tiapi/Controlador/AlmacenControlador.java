package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Almacen;
import upeu.tiapi.Repositorio.ProductoRepositorio;
import upeu.tiapi.Servicio.IAlmacenServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;

@RestController
@RequestMapping("/api-ti")
@CrossOrigin(origins = "*")
public class AlmacenControlador {
    @Autowired
    private IAlmacenServicio almacenServicio;

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @GetMapping("/almacenes")
    public List<Almacen> listarAlmacenes() {
        return almacenServicio.buscarTodos();
    }

    @GetMapping("/almacenes/{id}")
    public ResponseEntity<Almacen> buscarAlmacenPorId(@PathVariable int id) {
        Almacen almacen = almacenServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el almacén con el id: " + id));
        return ResponseEntity.ok(almacen);
    }

    @PostMapping("/almacenes")
    public Almacen guardarAlmacen(@RequestBody Almacen almacen) {
        return almacenServicio.guardar(almacen);
    }

    @PutMapping("/almacenes/{id}")
    public ResponseEntity<Almacen> actualizarAlmacen(@PathVariable int id, @RequestBody Almacen almacen) {
        if (!almacenServicio.buscarPorId(id).isPresent()) {
            throw new RecursoNoEncontradoExcepcion("No se encontró el almacén con el id: " + id);
        }
        almacen.setId(id);
        almacenServicio.actualizar(almacen);
        return ResponseEntity.ok(almacen);
    }

    @DeleteMapping("/almacenes/{id}")
    public ResponseEntity<?> eliminarAlmacen(@PathVariable int id) {
        if (productoRepositorio.countByAlmacenId(id) > 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El almacén está relacionado con uno o más productos.");
        }
        almacenServicio.eliminar(id);
        return ResponseEntity.ok().build();
    }


}
