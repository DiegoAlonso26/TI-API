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
public class ProductoControlador {
    @Autowired
    private IProductoServicio productoServicio;

    @GetMapping("/productos")
    public List<Producto> listaProductos() {
        return productoServicio.listarTodosProductos();

    }

    @GetMapping("/productos/{id}")
   public ResponseEntity<Producto> buscarProductoPorId(@PathVariable int id) {
        Producto producto = productoServicio.buscarProductoPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el producto con el id: " + id));
        return ResponseEntity.ok(producto);
    }

    @PostMapping("productos")
    public Producto guardarProducto(@RequestBody Producto producto) {
        return productoServicio.guardarProducto(producto);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable int id, @RequestBody Producto productoRecibido) {
        Producto producto = productoServicio.buscarProductoPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el producto con el id: " + id));
        producto.setNombre(productoRecibido.getNombre());
        producto.setPrecio(productoRecibido.getPrecio());
        producto.setDescripcion(productoRecibido.getDescripcion());
        producto.setStock(productoRecibido.getStock());
        Producto productoActualizado = productoServicio.guardarProducto(producto);
        return ResponseEntity.ok(productoActualizado);

    }
    @DeleteMapping("/productos/{id}")
    public void eliminarProducto(@PathVariable int id) {
        productoServicio.eliminarProducto(id);
    }
}
