package upeu.tiapi.Servicio;

import upeu.tiapi.Entity.DetallePedidos;

import java.util.List;
import java.util.Optional;

public interface IDetallePedidosServicio {
    List<DetallePedidos> buscarTodos();
    DetallePedidos guardar(DetallePedidos detallePedidos);
    void eliminar(Integer id);
    void actualizar(DetallePedidos detallePedidos);
    Optional<DetallePedidos> buscarPorId(Integer id);
}
