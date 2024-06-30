package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Venta;
import upeu.tiapi.Servicio.IVentasServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;
import java.util.List;


@RestController
@RequestMapping("/api-ti")
@CrossOrigin(origins = "*")
public class VentaControlador {
    @Autowired
    private IVentasServicio ventasServicio;

    @GetMapping("/ventas")
    public List<Venta> listarVentas() {
        return ventasServicio.buscarTodos();
    }

    @GetMapping("/ventas/{id}")
    public ResponseEntity<Venta> buscarVentaPorId(@PathVariable int id) {
        Venta venta = ventasServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró la venta con el id: " + id));
        return ResponseEntity.ok(venta);
    }

    @PostMapping("/ventas")
    public ResponseEntity<Venta> guardarVenta(@RequestBody Venta venta) {
        // La fecha se establecerá automáticamente por el método @PrePersist
        Venta nuevaVenta = ventasServicio.guardar(venta);
        return new ResponseEntity<>(nuevaVenta, HttpStatus.CREATED);
    }

    @PutMapping("/ventas/{id}")
    public ResponseEntity<Venta> actualizarVenta(@PathVariable int id, @RequestBody Venta venta) {
        Venta ventaExistente = ventasServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró la venta con el id: " + id));
        venta.setId(id);
        Venta ventaActualizada = ventasServicio.actualizar(venta);
        return ResponseEntity.ok(ventaActualizada);
    }

    @DeleteMapping("/ventas/{id}")
    public ResponseEntity<Void> eliminarVenta(@PathVariable int id) {
        ventasServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró la venta con el id: " + id));
        ventasServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}