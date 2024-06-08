package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Stock;
import upeu.tiapi.Servicio.IStockServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;


@RestController
@RequestMapping("/api-ti")
public class StockControlador {
    @Autowired
    private IStockServicio stockServicio;

    @GetMapping("/stocks")
    public List<Stock> listar() {
        return stockServicio.buscarTodos();
    }

    @PostMapping("/stocks")
    public Stock guardar(@RequestBody Stock stock) {
        return stockServicio.guardar(stock);
    }

    @GetMapping("/stocks/{id}")
    public ResponseEntity<Stock> buscarPorId(@PathVariable Integer id) {
        Stock stock = stockServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el usuario con el id: " + id));
        return ResponseEntity.ok(stock);
    }

    @PutMapping("/stocks/{id}")
    public ResponseEntity<Stock> actualizar(@PathVariable Integer id, @RequestBody Stock stock) {
        if(!stockServicio.buscarPorId(id).isPresent()) {
            throw new RecursoNoEncontradoExcepcion("No se encontró el usuario con el id: " + id);

        }
        stock.setId(id);
        stockServicio.actualizar(stock);
        return ResponseEntity.ok(stock);
    }

    @DeleteMapping("/stocks/{id}")
    public void eliminar(@PathVariable Integer id) {
        stockServicio.eliminar(id);
    }
}
