package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Compra;
import upeu.tiapi.Servicio.ICompraServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;


@RestController
@RequestMapping("/api-ti")
@CrossOrigin(origins = "*")
public class CompraControlador {
    @Autowired
    private ICompraServicio compraServicio;

    @GetMapping("/compras")
    public List<Compra> listar() {
        return compraServicio.buscarTodos();
    }

    @PostMapping("/compras")
    public Compra guardar(@RequestBody Compra compra) {
        return compraServicio.guardar(compra);
    }

    @GetMapping("/compras/{id}")
    public ResponseEntity<Compra> buscarPorId(@PathVariable Integer id) {
        Compra compra = compraServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró la compra con el id: " + id));
        return ResponseEntity.ok(compra);
    }

    @PutMapping("/compras/{id}")
    public ResponseEntity<Compra> actualizar(@PathVariable Integer id, @RequestBody Compra compra) {
        if(!compraServicio.buscarPorId(id).isPresent()) {
            throw new RecursoNoEncontradoExcepcion("No se encontró la compra con el id: " + id);

        }
        compra.setId(id);
        compraServicio.actualizar(compra);
        return ResponseEntity.ok(compra);
    }

    @DeleteMapping("/compras/{id}")
    public void eliminar(@PathVariable Integer id) {
        compraServicio.eliminar(id);
    }
}
