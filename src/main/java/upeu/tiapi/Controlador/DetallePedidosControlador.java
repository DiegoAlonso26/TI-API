package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.DetallePedidos;
import upeu.tiapi.Servicio.IDetallePedidosServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;

@RestController
@RequestMapping("/api-ti")
@CrossOrigin(origins = "*")

public class DetallePedidosControlador {

    @Autowired
    private IDetallePedidosServicio detallePedidosServicio;

    @GetMapping("/detallepedidos")
    public List<DetallePedidos> listar() {
        return detallePedidosServicio.buscarTodos();
    }

    @PostMapping("/detallepedidos")
    public DetallePedidos guardar(@RequestBody DetallePedidos detallePedidos) {
        return detallePedidosServicio.guardar(detallePedidos);
    }

    @GetMapping("/detallepedidos/{id}")
    public ResponseEntity<DetallePedidos> buscarPorId(@PathVariable Integer id) {
        DetallePedidos detallePedidos = detallePedidosServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el detalle de pedidos con el id: " + id));
        return ResponseEntity.ok(detallePedidos);
    }

    @PutMapping("/detallepedidos/{id}")
    public ResponseEntity<DetallePedidos> actualizar(@PathVariable Integer id, @RequestBody DetallePedidos detallePedidos) {
        if(!detallePedidosServicio.buscarPorId(id).isPresent()) {
            throw new RecursoNoEncontradoExcepcion("No se encontró el detalle de pedidos con el id: " + id);

        }
        detallePedidos.setId(id);
        detallePedidosServicio.actualizar(detallePedidos);
        return ResponseEntity.ok(detallePedidos);
    }

    @DeleteMapping("/detallepedidos/{id}")
    public void eliminar(@PathVariable Integer id) {
        detallePedidosServicio.eliminar(id);
    }
}
