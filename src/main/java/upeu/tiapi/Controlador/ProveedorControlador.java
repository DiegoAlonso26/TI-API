package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Proveedor;
import upeu.tiapi.Servicio.IProveedoresServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;

@RestController
@RequestMapping("/api-ti")
public class ProveedorControlador {
    @Autowired
    private IProveedoresServicio proveedoresServicio;


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
    public Proveedor actualizarProveedor( @RequestBody Proveedor proveedores) {
        proveedoresServicio.actualizar(proveedores);
        return proveedores;

    }
    @DeleteMapping("/proveedores/{id}")
    public void eliminarProveedor(@PathVariable int id) {
        proveedoresServicio.eliminar(id);
    }
}
