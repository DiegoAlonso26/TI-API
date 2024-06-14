package upeu.tiapi.Controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Sucursal;
import upeu.tiapi.Servicio.ISucursalServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;


@RestController
@RequestMapping("/api-ti")
@CrossOrigin(origins = "*")
public class SucursalControlador {
    @Autowired
    private ISucursalServicio sucursalServicio;

    @GetMapping("/sucursales")
    public List<Sucursal> listar() {
        return sucursalServicio.buscarTodos();
    }

    @PostMapping("/sucursales")
    public Sucursal guardar(@RequestBody Sucursal sucursal) {
        return sucursalServicio.guardar(sucursal);
    }

    @GetMapping("/sucursales/{id}")
    public ResponseEntity<Sucursal> buscarPorId(@PathVariable Integer id) {
        Sucursal sucursal = sucursalServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró la sucursal con el id: " + id));
        return ResponseEntity.ok(sucursal);
    }

    @PutMapping("/sucursales/{id}")
    public ResponseEntity<Sucursal> actualizar(@PathVariable Integer id, @RequestBody Sucursal sucursal) {
        if(!sucursalServicio.buscarPorId(id).isPresent()) {
            throw new RecursoNoEncontradoExcepcion("No se encontró la sucursal con el id: " + id);

        }
        sucursal.setId(id);
        sucursalServicio.actualizar(sucursal);
        return ResponseEntity.ok(sucursal);
    }

    @DeleteMapping("/sucursales/{id}")
    public void eliminar(@PathVariable Integer id) {
        sucursalServicio.eliminar(id);
    }
}
