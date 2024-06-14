package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Almacen;
import upeu.tiapi.Servicio.IAlmacenServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;

@RestController
@RequestMapping("/api-ti")
@CrossOrigin(origins = "*")
public class AlmacenControlador {
    @Autowired
    private IAlmacenServicio almacenServicio;

    @GetMapping("/almacenes")
    public List<Almacen> obtenerAlmacenes(){
        return almacenServicio.buscarTodos();
    }
    @GetMapping("/almacenes/{id}")
    public ResponseEntity<Almacen> obtenerAlmacen(@PathVariable int id){
        Almacen almacen = almacenServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el almacen con el id: " + id));
        return  ResponseEntity.ok(almacen);
    }
    @PostMapping("/almacenes")
    public Almacen agregarAlmacen(@RequestBody Almacen almacen){
        return almacenServicio.guardar(almacen);
    }

    @PutMapping("/almacenes/{id}")
    public ResponseEntity<Almacen> actualizarAlmacen(@PathVariable int id, @RequestBody Almacen almacen){
        if(!almacenServicio.buscarPorId(id).isPresent()){
            throw new RecursoNoEncontradoExcepcion("No se encontró el almacen con el id: " + id);
        }
        almacen.setId(id);
        almacenServicio.actualizar(almacen);
        return  ResponseEntity.ok(almacen);
    }
    @DeleteMapping("/almacenes/{id}")
    public void eliminarAlmacen(@PathVariable int id){
        almacenServicio.eliminar(id);
    }


}
