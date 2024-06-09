package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Pago;
import upeu.tiapi.Servicio.IPagoServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api-ti")
public class PagoControlador {
    @Autowired
    private IPagoServicio pagoServicio;

    @GetMapping("/pagos")
    public List<Pago> listar() {
        return pagoServicio.buscarTodos();
    }

    @PostMapping("/pagos")
    public Pago guardar(@RequestBody Pago pago) {
        pago.setFechapago(LocalDateTime.now()); // Asignar la fecha y hora actual
        return pagoServicio.guardar(pago);
    }

    @GetMapping("/pagos/{id}")
    public ResponseEntity<Pago> buscarPorId(@PathVariable Integer id) {
        Pago pago = pagoServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el pago con el id: " + id));
        return ResponseEntity.ok(pago);
    }

    @PutMapping("/pagos/{id}")
    public ResponseEntity<Pago> actualizar(@PathVariable Integer id, @RequestBody Pago pago) {
        if(!pagoServicio.buscarPorId(id).isPresent()) {
            throw new RecursoNoEncontradoExcepcion("No se encontró el pago con el id: " + id);

        }
        pago.setFechapago(LocalDateTime.now());
        pago.setId(id);
        pagoServicio.actualizar(pago);
        return ResponseEntity.ok(pago);
    }

    @DeleteMapping("/pagos/{id}")
    public void eliminar(@PathVariable Integer id) {
        pagoServicio.eliminar(id);
    }
}
