package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Devolucion;
import upeu.tiapi.Servicio.IDevolucionServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;

@RestController
@RequestMapping("/api-ti")
@CrossOrigin(origins = "*")
public class DevolucionControlador {
    @Autowired
    private IDevolucionServicio servicio;
    @GetMapping("/Devoluciones")
    public List<Devolucion> obtenerDevoluciones(){
        return servicio.buscarTodos();
    }

    @GetMapping("/Devoluciones/{id}")
    public ResponseEntity<Devolucion> obtenerDevolucion(@PathVariable int id){
        Devolucion devolucion = servicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró la devolucion de compras financiera con el id: " + id));
        return ResponseEntity.ok(devolucion);
    }

    @PostMapping("/Devoluciones")
    public Devolucion crearDevolucion(@RequestBody Devolucion devolucion){
        return servicio.guardar(devolucion);
    }
    @PutMapping("/Devoluciones/{id}")
    public ResponseEntity<Devolucion> actualizar(@RequestBody Devolucion devolucion, @PathVariable int id){
        if(!servicio.buscarPorId(id).isPresent()) {
            throw new RecursoNoEncontradoExcepcion("No se encontró la devolucion de compras con el id: " + id);
        }
        devolucion.setId(id);
        servicio.actualizar(devolucion);
        return ResponseEntity.ok(devolucion);
    }
    @DeleteMapping("/Devoluciones/{id}")
    public void eliminar(@PathVariable int id){
        servicio.eliminar(id);
    }
}