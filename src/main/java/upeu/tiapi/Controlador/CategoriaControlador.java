package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Categoria;
import upeu.tiapi.Servicio.ICategoriaServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;


@RestController
@RequestMapping("/api-ti")
public class CategoriaControlador {
    @Autowired
    private ICategoriaServicio categoriaServicio;
    @GetMapping("/categorias")
    public List<Categoria> listar() {
        return categoriaServicio.buscarTodos();
    }

    @PostMapping("/categorias")
    public Categoria guardar(@RequestBody Categoria categoria) {
        return categoriaServicio.guardar(categoria);
    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Integer id) {
        Categoria categoria = categoriaServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el usuario con el id: " + id));
        return ResponseEntity.ok(categoria);
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<Categoria> actualizar(@PathVariable Integer id, @RequestBody Categoria categoria) {
        if(!categoriaServicio.buscarPorId(id).isPresent()) {
            throw new RecursoNoEncontradoExcepcion("No se encontró el usuario con el id: " + id);
        }
        categoria.setId(id);
        categoriaServicio.actualizar(categoria);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/categorias/{id}")
    public void eliminar(@PathVariable Integer id) {
        categoriaServicio.eliminar(id);
    }
}
