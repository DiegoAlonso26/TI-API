package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.DetalleVentas;
import upeu.tiapi.Servicio.IDetalleVentasServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;

@RestController
@RequestMapping("/api-ti")
@CrossOrigin(origins = "*")

public class DetalleVentasControlador {
    @Autowired
    private IDetalleVentasServicio detalleVentaServicio;

    @GetMapping("/detalle-ventas")
    public List<DetalleVentas> listarDetalleVentas() {
        return detalleVentaServicio.buscarTodos();
    }

    @GetMapping("/detalle-ventas/{id}")
    public ResponseEntity<DetalleVentas> buscarDetalleVentaPorId(@PathVariable int id) {
        DetalleVentas detalleVenta = detalleVentaServicio.buscarPorId(id);
        if (detalleVenta == null) {
            throw new RecursoNoEncontradoExcepcion("No se encontró el detalle de venta con el id: " + id);
        }
        return ResponseEntity.ok(detalleVenta);
    }

    @PostMapping("/detalle-ventas")
    public ResponseEntity<DetalleVentas> guardarDetalleVenta(@RequestBody DetalleVentas detalleVenta) {
        DetalleVentas nuevoDetalleVenta = detalleVentaServicio.guardar(detalleVenta);
        return ResponseEntity.ok(nuevoDetalleVenta);
    }

    @PutMapping("/detalle-ventas/{id}")
    public ResponseEntity<DetalleVentas> actualizarDetalleVenta(@PathVariable int id, @RequestBody DetalleVentas detalleVenta) {
        DetalleVentas detalleVentaExistente = detalleVentaServicio.buscarPorId(id);
        if (detalleVentaExistente == null) {
            throw new RecursoNoEncontradoExcepcion("No se encontró el detalle de venta con el id: " + id);
        }
        detalleVenta.setId(id);
        DetalleVentas detalleVentaActualizado = detalleVentaServicio.actualizar(detalleVenta);
        return ResponseEntity.ok(detalleVentaActualizado);
    }

    @DeleteMapping("/detalle-ventas/{id}")
    public ResponseEntity<Void> eliminarDetalleVenta(@PathVariable int id) {
        DetalleVentas detalleVentaExistente = detalleVentaServicio.buscarPorId(id);
        if (detalleVentaExistente == null) {
            throw new RecursoNoEncontradoExcepcion("No se encontró el detalle de venta con el id: " + id);
        }
        detalleVentaServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }



}
