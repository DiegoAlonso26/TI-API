package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Pedido;
import upeu.tiapi.Servicio.IPedidoServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;

@RestController
@RequestMapping("/api-ti")
public class PedidoControlador {
    @Autowired
    private IPedidoServicio pedidoServicio;

    @GetMapping("/pedidos")
    public List<Pedido> listar() {
        return pedidoServicio.buscarTodos();
    }

    @PostMapping("/pedidos")
    public Pedido guardar(@RequestBody Pedido pedido) {
        return pedidoServicio.guardar(pedido);
    }

    @GetMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Integer id) {
        Pedido pedido = pedidoServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el pedido con el id: " + id));
        return ResponseEntity.ok(pedido);
    }

    @PutMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> actualizar(@PathVariable Integer id, @RequestBody Pedido pedido) {
        if(!pedidoServicio.buscarPorId(id).isPresent()) {
            throw new RecursoNoEncontradoExcepcion("No se encontró el pedido con el id: " + id);

        }
        pedido.setId(id);
        pedidoServicio.actualizar(pedido);
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/pedidos/{id}")
    public void eliminar(@PathVariable Integer id) {
        pedidoServicio.eliminar(id);
    }
}
