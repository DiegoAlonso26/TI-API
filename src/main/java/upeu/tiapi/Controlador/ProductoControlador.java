package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Producto;
import upeu.tiapi.Repositorio.AlmacenRepositorio;
import upeu.tiapi.Repositorio.CategoriaRepositorio;
import upeu.tiapi.Servicio.IProductoServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;

@RestController
@RequestMapping("/api-ti")
@CrossOrigin(origins = "*")
public class ProductoControlador {
    @Autowired
    private IProductoServicio productoServicio;

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Autowired
    private AlmacenRepositorio almacenRepositorio;

    @GetMapping("/productos")
    public List<Producto> listarProductos() {
        return productoServicio.listarTodosProductos();
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> buscarProductoPorId(@PathVariable int id) {
        Producto producto = productoServicio.buscarProductoPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el producto con el id: " + id));
        return ResponseEntity.ok(producto);
    }

    @GetMapping("/productos/sucursal/{sucursalId}")
    public List<Producto> listarProductosPorSucursal(@PathVariable Integer sucursalId) {
        return productoServicio.listarProductosPorSucursal(sucursalId);
    }

    @PostMapping("/productos")
    public Producto guardarProducto(@RequestBody Producto producto) {
        return productoServicio.guardarProducto(producto);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable int id, @RequestBody Producto producto) {
        if (!productoServicio.buscarProductoPorId(id).isPresent()) {
            throw new RecursoNoEncontradoExcepcion("No se encontró el producto con el id: " + id);
        }
        producto.setId(id);
        productoServicio.actualizarProducto(producto);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable int id) {
        long countCategorias = categoriaRepositorio.countByProductoId(id);
        long countAlmacenes = almacenRepositorio.countByProductoId(id);

        if (countCategorias > 0 || countAlmacenes > 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El producto está relacionado con una o más categorías o almacenes.");
        }
        productoServicio.eliminarProducto(id);
        return ResponseEntity.ok().build();
    }
}
