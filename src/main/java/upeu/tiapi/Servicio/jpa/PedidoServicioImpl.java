package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.Pedido;
import upeu.tiapi.Repositorio.PedidoRepositorio;
import upeu.tiapi.Servicio.IPedidoServicio;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServicioImpl implements IPedidoServicio {
    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Override
    public List<Pedido> buscarTodos() {
        return pedidoRepositorio.findAll();
    }

    @Override
    public Pedido guardar(Pedido pedido) {
        pedidoRepositorio.save(pedido);
        return pedido;
    }

    @Override
    public void eliminar(Integer id) {
        pedidoRepositorio.deleteById(id);
    }

    @Override
    public void actualizar(Pedido pedido) {
        pedidoRepositorio.save(pedido);
    }

    @Override
    public Optional<Pedido> buscarPorId(Integer id) {
        return pedidoRepositorio.findById(id);
    }
}
