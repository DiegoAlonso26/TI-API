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
    private IDetalleVentasServicio detalleVentasServicio;

    @GetMapping("/detalleventas")
    public List<DetalleVentas> listaDetalleVentas() {
        return detalleVentasServicio.buscarTodos();
    }

    @GetMapping("/detalleventas/{id}")
    public ResponseEntity<DetalleVentas> buscarDetalleVentas(@PathVariable Integer id) {
        DetalleVentas detalleVentas = detalleVentasServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el detalle de ventas con el id: " + id));
    return ResponseEntity.ok(detalleVentas);
    }

    @PostMapping("/detalleventas")
    public DetalleVentas guardarDetalleVentas(@RequestBody DetalleVentas detalleVentas) {
        return detalleVentasServicio.guardar(detalleVentas);
    }
    @PutMapping("/detalleventas/{id}")
    public ResponseEntity<DetalleVentas> actualizarDetalleVentas(@PathVariable Integer id, @RequestBody DetalleVentas detalleVentas) {
        if(!detalleVentasServicio.buscarPorId(id).isPresent()){
            throw new RecursoNoEncontradoExcepcion("No se encontró el detalle de ventas con el id: " + id);

        }
        detalleVentas.setId(id);
        detalleVentasServicio.actualizar(detalleVentas);
        return ResponseEntity.ok(detalleVentas);
    }

    @DeleteMapping("/detalleventas/{id}")
    public String eliminarDetalleVentas(@PathVariable Integer id) {
        detalleVentasServicio.eliminar(id);
        return "Detalle de ventas con el id: " + id + " eliminado";
    }


}
