package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.DetallePedidos;
import upeu.tiapi.Repositorio.DetallePedidosRepositorio;
import upeu.tiapi.Servicio.IDetallePedidosServicio;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidosServicioImpl implements IDetallePedidosServicio {

    @Autowired
    private DetallePedidosRepositorio detallePedidosRepositorio;

    @Override
    public List<DetallePedidos> buscarTodos() {
        return detallePedidosRepositorio.findAll();
    }

    @Override
    public DetallePedidos guardar(DetallePedidos detallePedidos) {
        detallePedidosRepositorio.save(detallePedidos);
        return detallePedidos;
    }

    @Override
    public void eliminar(Integer id) {
        detallePedidosRepositorio.deleteById(id);
    }

    @Override
    public void actualizar(DetallePedidos detallePedidos) {
        detallePedidosRepositorio.save(detallePedidos);
    }

    @Override
    public Optional<DetallePedidos> buscarPorId(Integer id) {
        return detallePedidosRepositorio.findById(id);
    }
}
