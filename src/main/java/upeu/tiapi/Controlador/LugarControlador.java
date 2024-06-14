package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Lugar;
import upeu.tiapi.Servicio.ILugarServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;

@RestController
@RequestMapping("/api-ti")
@CrossOrigin(origins = "*")
public class LugarControlador {
    @Autowired
    private ILugarServicio  lugarServicio;
    @GetMapping("/lugares")
    public List<Lugar> lugares(){
        return lugarServicio.buscarTodos();
    }
    @GetMapping("/lugares/{id}")
    public ResponseEntity<Lugar> buscarLugar(@PathVariable int id){
        Lugar lugar = lugarServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el lugar con el id: " + id));
        return ResponseEntity.ok(lugar);
    }

    @PostMapping("/lugares")
    public Lugar guardarLugar(@RequestBody Lugar lugar){
        return lugarServicio.guardar(lugar);
    }
    @PutMapping("/lugares/{id}")
    public ResponseEntity<Lugar> actualizarLugar(@PathVariable int id, @RequestBody Lugar lugar){
        if(!lugarServicio.buscarPorId(id).isPresent()){
            throw new RecursoNoEncontradoExcepcion("No se encontró el lugar con el id: " + id);

        }
        lugar.setId(id);
        lugarServicio.actualizar(lugar);
        return ResponseEntity.ok(lugar);
    }

    @DeleteMapping("/lugares/{id}")
    public void eliminarLugar(@PathVariable int id){
        lugarServicio.eliminar(id);
    }
}
