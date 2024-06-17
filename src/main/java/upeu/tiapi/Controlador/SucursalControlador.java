package upeu.tiapi.Controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Sucursal;
import upeu.tiapi.Repositorio.SucursalRepositorio;
import upeu.tiapi.Servicio.ISucursalServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;


@RestController
@RequestMapping("/api-ti")
@CrossOrigin(origins = "*")
public class SucursalControlador {
    @Autowired
    private ISucursalServicio sucursalServicio;

    @Autowired
    private SucursalRepositorio sucursalRepositorio;

    @GetMapping("/sucursales")
    public List<Sucursal> listarSucursales() {
        return sucursalServicio.buscarTodos();
    }

    @GetMapping("/sucursales/{id}")
    public ResponseEntity<Sucursal> buscarSucursalPorId(@PathVariable int id) {
        Sucursal sucursal = sucursalServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró la sucursal con el id: " + id));
        return ResponseEntity.ok(sucursal);
    }

    @PostMapping("/sucursales")
    public Sucursal guardarSucursal(@RequestBody Sucursal sucursal) {
        return sucursalServicio.guardar(sucursal);
    }

    @PutMapping("/sucursales/{id}")
    public ResponseEntity<Sucursal> actualizarSucursal(@PathVariable int id, @RequestBody Sucursal sucursal) {
        if (!sucursalServicio.buscarPorId(id).isPresent()) {
            throw new RecursoNoEncontradoExcepcion("No se encontró la sucursal con el id: " + id);
        }
        sucursal.setId(id);
        sucursalServicio.actualizar(sucursal);
        return ResponseEntity.ok(sucursal);
    }

    @DeleteMapping("/sucursales/{id}")
    public ResponseEntity<?> eliminarSucursal(@PathVariable int id) {
        long count = sucursalRepositorio.countByLugarId(id);
        if (count > 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La sucursal está relacionada con uno o más lugares.");
        }
        sucursalServicio.eliminar(id);
        return ResponseEntity.ok().build();
    }
}
