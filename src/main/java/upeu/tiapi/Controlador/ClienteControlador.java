package upeu.tiapi.Controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Cliente;
import upeu.tiapi.Servicio.IClienteServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;

@RestController
@RequestMapping("/api-ti")
public class ClienteControlador {
    @Autowired
    private IClienteServicio clienteServicio;

    @GetMapping("/clientes")
    public List<Cliente> listaClientes() {
        return clienteServicio.buscarTodos();
    }
    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable int id) {
        Cliente cliente = clienteServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el cliente con el id: " + id));
        return ResponseEntity.ok(cliente);
    }
    @PostMapping("/clientes")
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteServicio.guardar(cliente);
    }
    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> modificarCliente(@PathVariable int id, @RequestBody Cliente clienteRecibido) {
        Cliente cliente = clienteServicio.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("No se encontró el cliente con el id: " + id));
        cliente.setNombre(clienteRecibido.getNombre());
        cliente.setDireccion(clienteRecibido.getDireccion());
        cliente.setTelefono(clienteRecibido.getTelefono());
        Cliente clienteActualizado = clienteServicio.guardar(cliente);
        return ResponseEntity.ok(clienteActualizado);

    }

    @DeleteMapping("/clientes/{id}")
    public void eliminarCliente(@PathVariable int id) {
        clienteServicio.eliminar(id);
    }

}
