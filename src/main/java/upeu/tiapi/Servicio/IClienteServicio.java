package upeu.tiapi.Servicio;


import upeu.tiapi.Entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteServicio {
    List<Cliente> buscarTodos();
    Cliente guardar(Cliente cliente);
    void eliminar(Integer id);
    Cliente actualizar(Cliente cliente);
    Optional<Cliente> buscarPorId(Integer id);
}
