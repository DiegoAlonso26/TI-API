package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Acceso;
import upeu.tiapi.Servicio.IAccesoServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;

@RestController
@RequestMapping("/api-ti")
public class AccesoControlador {
    @Autowired
    private IAccesoServicio accesoServicio;

    @GetMapping("/accesos")
    public List<Acceso> listar() {
        return accesoServicio.buscarTodos();
    }

    @PostMapping("/accesos")
    public Acceso guardar(@RequestBody Acceso acceso) {
        return accesoServicio.guardar(acceso);
    }

    @GetMapping("/accesos/{id}")
    public ResponseEntity<Acceso> buscarPorId(@PathVariable Integer id) {
        Acceso acceso = accesoServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el acceso con el id: " + id));
        return ResponseEntity.ok(acceso);
    }

    @PutMapping("/accesos/{id}")
    public ResponseEntity<Acceso> actualizar(@PathVariable Integer id, @RequestBody Acceso acceso) {
        if(!accesoServicio.buscarPorId(id).isPresent()) {
            throw new RecursoNoEncontradoExcepcion("No se encontró el acceso con el id: " + id);

        }
        acceso.setId(id);
        accesoServicio.actualizar(acceso);
        return ResponseEntity.ok(acceso);
    }

    @DeleteMapping("/accesos/{id}")
    public void eliminar(@PathVariable Integer id) {
        accesoServicio.eliminar(id);
    }

}
