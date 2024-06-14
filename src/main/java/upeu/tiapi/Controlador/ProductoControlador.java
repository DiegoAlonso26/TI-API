package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Producto;
import upeu.tiapi.Servicio.IProductoServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;

@RestController
@RequestMapping("/api-ti")
@CrossOrigin(origins = "*")
public class ProductoControlador {
    @Autowired
    private IProductoServicio productoServicio;

    @GetMapping("/productos")
    public List<Producto> listaProductos() {
        return productoServicio.listarTodosProductos();
    }

    @PostMapping("/productos")
    public Producto guardarProducto(@RequestBody Producto producto) {
        return productoServicio.guardarProducto(producto);
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> buscarProductoPorId(@PathVariable int id) {
        Producto producto = productoServicio.buscarProductoPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el producto con el id: " + id));
        return ResponseEntity.ok(producto);
    }


    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        if (!productoServicio.buscarProductoPorId(id).isPresent()) {
            throw new RecursoNoEncontradoExcepcion("No se encontró el producto con el id: " + id);
        }
        producto.setId(id); // Asegurar que el ID del producto coincide con el de la URL
        productoServicio.actualizarProducto(producto);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/productos/{id}")
    public void eliminarProducto(@PathVariable int id) {
        productoServicio.eliminarProducto(id);
    }
}
