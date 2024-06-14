package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Empresa;
import upeu.tiapi.Servicio.IEmpresaServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;

@RestController
@RequestMapping("/api-ti")
@CrossOrigin(origins = "*")

public class EmpresaControlador {
    @Autowired
    private IEmpresaServicio empresaServicio;

    @GetMapping("/empresas")
    public List<Empresa> listar() {
        return empresaServicio.buscarTodos();
    }

    @PostMapping("/empresas")
    public Empresa guardar(@RequestBody Empresa empresa) {
        return empresaServicio.guardar(empresa);
    }

    @GetMapping("/empresas/{id}")
    public ResponseEntity<Empresa> buscarPorId(@PathVariable Integer id) {
        Empresa empresa = empresaServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró la empresa con el id: " + id));
        return ResponseEntity.ok(empresa);
    }

    @PutMapping("/empresas/{id}")
    public ResponseEntity<Empresa> actualizar(@PathVariable Integer id, @RequestBody Empresa empresa) {
        if(!empresaServicio.buscarPorId(id).isPresent()) {
            throw new RecursoNoEncontradoExcepcion("No se encontró la empresa con el id: " + id);

        }
        empresa.setId(id);
        empresaServicio.actualizar(empresa);
        return ResponseEntity.ok(empresa);
    }

    @DeleteMapping("/empresas/{id}")
    public String eliminar(@PathVariable Integer id) {
        empresaServicio.eliminar(id);
        return "Empresa eliminada correctamente";
    }

}
