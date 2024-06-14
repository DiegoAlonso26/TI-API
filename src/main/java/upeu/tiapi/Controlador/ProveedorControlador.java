package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Proveedor;
import upeu.tiapi.Repositorio.CompraRepositorio;
import upeu.tiapi.Servicio.IProveedoresServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;

@RestController
@RequestMapping("/api-ti")
@CrossOrigin(origins = "*")
public class ProveedorControlador {
    @Autowired
    private IProveedoresServicio proveedoresServicio;

    @Autowired
    private CompraRepositorio comprasRepositorio; // Agrega el repositorio de compras

    @GetMapping("/proveedores")
    public List<Proveedor> listaProveedores() {
        return proveedoresServicio.buscarTodos();
    }

    @GetMapping("/proveedores/{id}")
    public ResponseEntity<Proveedor> buscarProveedoresPorId(@PathVariable int id) {
        Proveedor proveedores = proveedoresServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el proveedor con el id: " + id));
        return ResponseEntity.ok(proveedores);
    }

    @PostMapping("/proveedores")
    public Proveedor guardarProveedor(@RequestBody Proveedor proveedores) {
        return proveedoresServicio.guardar(proveedores);
    }

    @PutMapping("/proveedores/{id}")
    public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable int id, @RequestBody Proveedor proveedores) {
        if (!proveedoresServicio.buscarPorId(id).isPresent()) {
            throw new RecursoNoEncontradoExcepcion("No se encontró el proveedor con el id: " + id);
        }
        proveedores.setId(id);
        proveedoresServicio.actualizar(proveedores);
        return ResponseEntity.ok(proveedores);
    }

    @DeleteMapping("/proveedores/{id}")
    public ResponseEntity<?> eliminarProveedor(@PathVariable int id) {
        // Validar si el proveedor tiene compras asociadas antes de eliminar
        long count = comprasRepositorio.countByProveedorId(id);
        if (count > 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El proveedor está relacionado con una o más compras.");
        }
        proveedoresServicio.eliminar(id);
        return ResponseEntity.ok().build();
    }
}
