package upeu.tiapi.Controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Venta;
import upeu.tiapi.Servicio.IVentasServicio;

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

    @PutMapping("/ventas")
    public void modificar(@RequestBody Venta venta) {
        venta.setFecha(LocalDateTime.now()); // Actualizar la fecha y hora actual
        ventaServicio.actualizar(venta);
    }

    @DeleteMapping("/ventas/{id}")
    public void eliminar(@PathVariable Integer id) {
        ventaServicio.eliminar(id);
    }


}
