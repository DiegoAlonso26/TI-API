package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Garantia;
import upeu.tiapi.Servicio.IGarantiaServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;

@RestController
@RequestMapping("/api-ti")
@CrossOrigin(origins = "*")
public class GarantiaControlador {
    @Autowired
    private IGarantiaServicio servicio;
    @GetMapping("/Garantia")
    public List<Garantia> listarGarantias() {
        return servicio.buscarTodos();
    }
    @GetMapping("/Garantia/{id}")
    public ResponseEntity<Garantia> buscarGarantia(@PathVariable int id) {
        Garantia garantia = servicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró la garantia con el id: " + id));
        return ResponseEntity.ok(garantia);
    }
    @PostMapping("/Garantia")
    public Garantia crearGarantia(@RequestBody Garantia garantia) {
        return servicio.guardar(garantia);
    }
    @PutMapping("/Garantia/{id}")
    public ResponseEntity<Garantia> actualizarGarantia(@PathVariable int id, @RequestBody Garantia garantia) {
        if(!servicio.buscarPorId(id).isPresent()){
            throw new RecursoNoEncontradoExcepcion("No se encontro la garantia con el id: " + id);

        }
        garantia.setId(id);
        servicio.actualizar(garantia);
        return ResponseEntity.ok(garantia);
    }

    @DeleteMapping("/Garantia/{id}")
    public void eliminarGarantia(@PathVariable int id) {
        servicio.eliminar(id);
    }


}
