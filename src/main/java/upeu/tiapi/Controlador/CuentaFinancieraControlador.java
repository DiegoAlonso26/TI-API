package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.CuentaFinanciera;
import upeu.tiapi.Servicio.ICuentaFinancieraServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;

@RestController
@RequestMapping("/api-ti")
@CrossOrigin(origins = "*")
public class CuentaFinancieraControlador {
    @Autowired
    private ICuentaFinancieraServicio servicio;
    @GetMapping("/CuentasFinancieras")
    public List<CuentaFinanciera> listaCuentasFinancieras() {
        return servicio.buscarTodos();
    }
    @GetMapping("/CuentasFinancieras/{id}")
    public ResponseEntity<CuentaFinanciera> buscarCuentaFinanciera(@PathVariable int id) {
        CuentaFinanciera cuentaFinanciera = servicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró la categoria financiera con el id: " + id));
        return ResponseEntity.ok(cuentaFinanciera);
    }
    @PostMapping("/CuentasFinancieras")
    public CuentaFinanciera guardarCuentaFinanciera(@RequestBody CuentaFinanciera cuentaFinanciera) {
        return servicio.guardar(cuentaFinanciera);
    }

    @PutMapping("/CuentasFinancieras/{id}")
    public ResponseEntity<CuentaFinanciera> actualizar(@PathVariable int id, @RequestBody CuentaFinanciera cuentaFinanciera) {
        if(!servicio.buscarPorId(id).isPresent()){
            throw new RecursoNoEncontradoExcepcion("No se encontró la categoria con el id: " + id);

        }
        cuentaFinanciera.setId(id);
        servicio.actualizar(cuentaFinanciera);
        return ResponseEntity.ok(cuentaFinanciera);
    }

    @DeleteMapping("/CuentasFinancieras/{id}")
    public void eliminar(@PathVariable int id) {
        servicio.eliminar(id);
    }



}
