package upeu.tiapi.Controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Cliente;
import upeu.tiapi.Servicio.IClienteServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-ti")
public class ClienteControlador {
    @Autowired
    private IClienteServicio clienteServicio;

    @GetMapping("/clientes")
    public List<Cliente> listarClientes() {
        return clienteServicio.buscarTodos();
    }

    @GetMapping("/clientes/{id}")
    public Optional<Cliente> buscarCliente(@PathVariable int id) {
        return clienteServicio.buscarPorId(id);
    }

    @PostMapping("/clientes")
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteServicio.guardar(cliente);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable int id, @RequestBody Cliente cliente) {
        if(!clienteServicio.buscarPorId(id).isPresent()) {
            throw new RecursoNoEncontradoExcepcion("No se encontró el cliente con el id: " + id);

        }
        cliente.setId(id);
        clienteServicio.actualizar(cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/clientes/{id}")
    public String eliminar(@PathVariable int id) {
        clienteServicio.eliminar(id);
        return "Cliente eliminado";
    }

}


