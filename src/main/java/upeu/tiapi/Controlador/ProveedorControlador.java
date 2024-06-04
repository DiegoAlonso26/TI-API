package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Proveedores;
import upeu.tiapi.Servicio.IProveedoresServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;

@RestController
@RequestMapping("/api-ti")
public class ProveedorControlador {
    @Autowired
    private IProveedoresServicio proveedoresServicio;


    @GetMapping("/proveedores")
    public List<Proveedores> listaProveedores() {
        return proveedoresServicio.buscarTodos();
    }

    @GetMapping("/proveedores/{id}")
    public ResponseEntity<Proveedores> buscarProveedoresPorId(@PathVariable int id) {
        Proveedores proveedores = proveedoresServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el proveedor con el id: " + id));
        return ResponseEntity.ok(proveedores);

    }
    @PostMapping("/proveedores")
    public Proveedores crearProveedor(@RequestBody Proveedores proveedores) {
        return proveedoresServicio.guardar(proveedores);
    }

    @PutMapping("/proveedores/{id}")
    public ResponseEntity<Proveedores> modificarProveedor(@PathVariable int id, @RequestBody Proveedores proveedoresRecibidos) {
        Proveedores proveedores = proveedoresServicio.buscarPorId(id).orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el proveedor con el id: " + id));
        proveedores.setDireccion(proveedoresRecibidos.getDireccion());
        proveedores.setNombre(proveedores.getNombre());
        proveedores.setTelefono(proveedores.getTelefono());
        Proveedores proveedorActualizado = proveedoresServicio.guardar(proveedores);
        return ResponseEntity.ok(proveedorActualizado);
    }
    @DeleteMapping("/proveedores/{id}")
    public void eliminarProveedor(@PathVariable int id) {
        proveedoresServicio.eliminar(id);
    }
}
