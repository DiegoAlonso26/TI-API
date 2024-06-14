package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.DetalleCompra;
import upeu.tiapi.Servicio.IDetalleComprasServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;

@RestController
@RequestMapping("/api-ti")
@CrossOrigin(origins = "*")
public class DetalleCompraControlador {
    @Autowired
    private IDetalleComprasServicio servicio;

    @GetMapping("/DetalleCompras")
    public List<DetalleCompra> obtenerDetalleCompras(@PathVariable int id) {
        return servicio.buscarTodos();
    }
    @GetMapping("/DetallesCompra/{id}")
    public ResponseEntity<DetalleCompra> obtenerDetalleCompra(@PathVariable int id) {
        DetalleCompra detalleCompra = servicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el detalle de compras financiera con el id: " + id));
        return ResponseEntity.ok(detalleCompra);
    }

    @PostMapping("/DetallesCompra")
    public DetalleCompra agregarDetalleCompra(@RequestBody DetalleCompra detalleCompra) {
        return servicio.guardar(detalleCompra);
    }

    @PutMapping("DetallesCompra/{id}")
    public ResponseEntity<DetalleCompra> actualizarDetalleCompra(@PathVariable int id, @RequestBody DetalleCompra detalleCompra) {
        if(!servicio.buscarPorId(id).isPresent()){
            throw new RecursoNoEncontradoExcepcion("No se encontró el detalle de compras con el id: " + id);

        }
        detalleCompra.setId(id);
        servicio.actualizar(detalleCompra);
        return ResponseEntity.ok(detalleCompra);
    }
    @DeleteMapping("DetallesCompra/{id}")
    public void eliminarDetalleCompra(@PathVariable int id) {
        servicio.eliminar(id);
    }
}
