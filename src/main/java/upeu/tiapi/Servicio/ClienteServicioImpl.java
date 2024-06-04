package upeu.tiapi.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.Cliente;
import upeu.tiapi.Repositorio.ClienteRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImpl implements IClienteServicio {
    @Autowired
    private ClienteRepositorio clienteRepositorio;
    @Override
    public List<Cliente> buscarTodos() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        clienteRepositorio.save(cliente);
        return cliente;
    }

    @Override
    public void eliminar(Integer id) {
            clienteRepositorio.deleteById(id);
    }

    @Override
    public void actualizar(Cliente cliente) {
        clienteRepositorio.save(cliente);

    }

    @Override
    public Optional<Cliente> buscarPorId(Integer id) {
        return clienteRepositorio.findById(id);
    }


}
