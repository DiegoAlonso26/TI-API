package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.TransaccionesFinanciera;
import upeu.tiapi.Servicio.ITransaccionesFinancierasServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;

@RestController
@RequestMapping("/api-ti")
@CrossOrigin(origins = "*")
public class TransaccionesFinancieraControlador {
    @Autowired
    private ITransaccionesFinancierasServicio servicio;

    @GetMapping("/TransaccionesFinancieras")
    public List<TransaccionesFinanciera> listaTransaccionesFinancieras() {
        return servicio.buscarTodos();
    }
    @PostMapping("/TransaccionesFinancieras")
    public TransaccionesFinanciera guardarTransaccionesFinanciera(@RequestBody TransaccionesFinanciera trans) {
        return servicio.guardar(trans);
    }

    @GetMapping("TransaccionesFinancieras/{id}")
    public ResponseEntity<TransaccionesFinanciera> buscarTransaccionesFinanciera(@PathVariable int id) {
        TransaccionesFinanciera transaccionesFinanciera = servicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró la transaccion con el id: " + id));
        return ResponseEntity.ok(transaccionesFinanciera);
    }

    @PutMapping("TransaccionesFinancieras/{id}")
    public ResponseEntity<TransaccionesFinanciera> actualizarTransaccionesFinanciera(@RequestBody TransaccionesFinanciera trans, @PathVariable Integer id) {
        if(!servicio.buscarPorId(id).isPresent()){
            throw new RecursoNoEncontradoExcepcion("No se encontró el acceso con el id: " + id);

        }
        trans.setId(id);
        servicio.actualizar(trans);
        return ResponseEntity.ok(trans);

    }

    @DeleteMapping("TransaccionesFinancieras/{id}")
    public void eliminarTransaccionesFinanciera(@PathVariable Integer id) {
        servicio.eliminar(id);
    }

}
