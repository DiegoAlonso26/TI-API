package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Caja;
import upeu.tiapi.Servicio.ICajaServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;


@RestController
@RequestMapping("/api-ti")
@CrossOrigin(origins = "*")

public class CajaControlador {
    @Autowired
    private ICajaServicio cajaServicio;

    @GetMapping("/cajas")
    public List<Caja> listar() {
        return cajaServicio.buscarTodos();
    }

    @PostMapping("/cajas")
    public Caja guardar(@RequestBody Caja caja) {
        return cajaServicio.guardar(caja);
    }

    @GetMapping("/cajas/{id}")
    public ResponseEntity<Caja> buscarPorId(@PathVariable Integer id) {
        Caja caja = cajaServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró la caja con el id: " + id));
        return ResponseEntity.ok(caja);
    }

    @PutMapping("/cajas/{id}")
    public ResponseEntity<Caja> actualizar(@PathVariable Integer id, @RequestBody Caja caja) {
        if(!cajaServicio.buscarPorId(id).isPresent()) {
            throw new RecursoNoEncontradoExcepcion("No se encontró la caja con el id: " + id);

        }
        caja.setId(id);
        cajaServicio.actualizar(caja);
        return ResponseEntity.ok(caja);
    }

    @DeleteMapping("/cajas/{id}")
    public void eliminar(@PathVariable Integer id) {
        cajaServicio.eliminar(id);
    }
}
