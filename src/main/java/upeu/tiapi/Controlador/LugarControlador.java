package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Lugar;
import upeu.tiapi.Repositorio.AlmacenRepositorio;
import upeu.tiapi.Repositorio.SucursalRepositorio;
import upeu.tiapi.Servicio.ILugarServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;

@RestController
@RequestMapping("/api-ti")
@CrossOrigin(origins = "*")
public class LugarControlador {
    @Autowired
    private ILugarServicio lugarServicio;

    @Autowired
    private AlmacenRepositorio almacenRepositorio;

    @Autowired
    private SucursalRepositorio sucursalRepositorio;

    @GetMapping("/lugares")
    public List<Lugar> listarLugares() {
        return lugarServicio.buscarTodos();
    }

    @GetMapping("/lugares/{id}")
    public ResponseEntity<Lugar> buscarLugarPorId(@PathVariable int id) {
        Lugar lugar = lugarServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el lugar con el id: " + id));
        return ResponseEntity.ok(lugar);
    }

    @PostMapping("/lugares")
    public Lugar guardarLugar(@RequestBody Lugar lugar) {
        return lugarServicio.guardar(lugar);
    }

    @PutMapping("/lugares/{id}")
    public ResponseEntity<Lugar> actualizarLugar(@PathVariable int id, @RequestBody Lugar lugar) {
        if (!lugarServicio.buscarPorId(id).isPresent()) {
            throw new RecursoNoEncontradoExcepcion("No se encontró el lugar con el id: " + id);
        }
        lugar.setId(id);
        lugarServicio.actualizar(lugar);
        return ResponseEntity.ok(lugar);
    }

    @DeleteMapping("/lugares/{id}")
    public ResponseEntity<?> eliminarLugar(@PathVariable int id) {
        if (almacenRepositorio.countByLugarId(id) > 0 || sucursalRepositorio.countByLugarId(id) > 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El lugar está relacionado con uno o más almacenes o sucursales.");
        }
        lugarServicio.eliminar(id);
        return ResponseEntity.ok().build();
    }

}
