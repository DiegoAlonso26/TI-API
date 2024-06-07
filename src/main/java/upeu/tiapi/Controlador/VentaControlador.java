package upeu.tiapi.Controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Venta;
import upeu.tiapi.Servicio.IVentasServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-ti")
public class VentaControlador {
    @Autowired
    private IVentasServicio ventaServicio;

    @GetMapping("/ventas")
    public List<Venta> listar() {
        return ventaServicio.buscarTodos();
    }

    @GetMapping("/ventas/{id}")
    public Optional<Venta> buscarPorId(@PathVariable Integer id) {
        return ventaServicio.buscarPorId(id);
    }

    @PostMapping("/ventas")
    public void guardar(@RequestBody Venta venta) {
        venta.setFecha(LocalDateTime.now()); // Asignar la fecha y hora actual

        ventaServicio.guardar(venta);
    }

    @PutMapping("/ventas/{id}")
    public ResponseEntity<Venta> actualizar(@PathVariable int id, @RequestBody Venta venta) {
        if(!ventaServicio.buscarPorId(id).isPresent()) {
            throw new RecursoNoEncontradoExcepcion("No se encontró la venta con el id: " + id);
        }
        venta.setFecha(LocalDateTime.now());
        venta.setId(id);
        ventaServicio.actualizar(venta);
        return ResponseEntity.ok(venta);
    }

    @DeleteMapping("/ventas/{id}")
    public String eliminar(@PathVariable Integer id) {
        ventaServicio.eliminar(id);
        return "Venta eliminada correctamente";
    }


}