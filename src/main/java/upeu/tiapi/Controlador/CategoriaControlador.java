package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Categoria;
import upeu.tiapi.Repositorio.ProductoRepositorio;
import upeu.tiapi.Servicio.ICategoriaServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;


@RestController
@RequestMapping("/api-ti")
@CrossOrigin(origins = "*")
public class CategoriaControlador {
    @Autowired
    private ICategoriaServicio categoriaServicio;

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @GetMapping("/categorias")
    public List<Categoria> listarCategorias() {
        return categoriaServicio.buscarTodos();
    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity<Categoria> buscarCategoriaPorId(@PathVariable int id) {
        Categoria categoria = categoriaServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró la categoría con el id: " + id));
        return ResponseEntity.ok(categoria);
    }

    @PostMapping("/categorias")
    public Categoria guardarCategoria(@RequestBody Categoria categoria) {
        return categoriaServicio.guardar(categoria);
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable int id, @RequestBody Categoria categoria) {
        if (!categoriaServicio.buscarPorId(id).isPresent()) {
            throw new RecursoNoEncontradoExcepcion("No se encontró la categoría con el id: " + id);
        }
        categoria.setId(id);
        categoriaServicio.actualizar(categoria);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<?> eliminarCategoria(@PathVariable int id) {
        long countProductos = productoRepositorio.countByCategoriaId(id);

        if (countProductos > 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La categoría está relacionada con uno o más productos.");
        }
        categoriaServicio.eliminar(id);
        return ResponseEntity.ok().build();
    }
}
