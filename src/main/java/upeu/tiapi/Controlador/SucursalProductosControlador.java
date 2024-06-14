package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.SucursalProductos;
import upeu.tiapi.Servicio.ISucursalProductosServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;

@RestController
@RequestMapping("/api-ti")
@CrossOrigin(origins = "*")
public class SucursalProductosControlador {
    @Autowired
    private ISucursalProductosServicio sucursalProductosServicio;

    @GetMapping("/sucursalproductos")
    public List<SucursalProductos> listar() {
        return sucursalProductosServicio.buscarTodos();
    }

    @PostMapping("/sucursalproductos")
    public SucursalProductos guardar(@RequestBody SucursalProductos sucursalProductos) {
        return sucursalProductosServicio.guardar(sucursalProductos);
    }

    @GetMapping("/sucursalproductos/{id}")
    public ResponseEntity<SucursalProductos> buscarPorId(@PathVariable Integer id) {
        SucursalProductos sucursalProductos = sucursalProductosServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró ela sucursal del producto con el id: " + id));
        return ResponseEntity.ok(sucursalProductos);
    }

    @PutMapping("/sucursalproductos/{id}")
    public ResponseEntity<SucursalProductos> actualizar(@PathVariable Integer id, @RequestBody SucursalProductos sucursalProductos) {
        if(!sucursalProductosServicio.buscarPorId(id).isPresent()) {
            throw new RecursoNoEncontradoExcepcion("No se encontró la sucursal del producto con el id: " + id);

        }
        sucursalProductos.setId(id);
        sucursalProductosServicio.actualizar(sucursalProductos);
        return ResponseEntity.ok(sucursalProductos);
    }

    @DeleteMapping("/sucursalproductos/{id}")
    public void eliminar(@PathVariable Integer id) {
        sucursalProductosServicio.eliminar(id);
    }
}

