package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.CategoriaFinanciera;
import upeu.tiapi.Servicio.ICategoriaFinancieraServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;

@RestController
@RequestMapping("/api-ti")
@CrossOrigin(origins = "*")
public class CategoriaFinancieraControlador {
    @Autowired
    private ICategoriaFinancieraServicio servicio;

    @GetMapping("/CategoriaFinanciera")
    public List<CategoriaFinanciera> listaCategoriaFinanciera() {
        return servicio.buscarTodos();
    }
    @GetMapping("/CategoriaFinanciera/{id}")
    public ResponseEntity<CategoriaFinanciera> buscarCategoriaFinanciera(@PathVariable int id) {
        CategoriaFinanciera categoriaFinanciera = servicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró la categoria con el id: " + id));

        return ResponseEntity.ok(categoriaFinanciera);
    }

    @PostMapping("/CategoriaFinanciera")
    public CategoriaFinanciera guardar(@RequestBody CategoriaFinanciera categoriaFinanciera) {
        return servicio.guardar(categoriaFinanciera);
    }
    @PutMapping("/CategoriaFinanciera/{id}")
    public ResponseEntity<CategoriaFinanciera> actualizar(@PathVariable int id, @RequestBody CategoriaFinanciera categoriaFinanciera) {
        if(!servicio.buscarPorId(id).isPresent()){
            throw new RecursoNoEncontradoExcepcion("No se encontró la categoria con el id: " + id);

        }
        categoriaFinanciera.setId(id);
        servicio.actualizar(categoriaFinanciera);
        return ResponseEntity.ok(categoriaFinanciera);
    }
    @DeleteMapping("CategoriaFinanciera/{id}")
    public void eliminar(@PathVariable int id) {
        servicio.eliminar(id);
    }


}

