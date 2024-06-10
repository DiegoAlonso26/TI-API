package upeu.tiapi.Servicio;

import upeu.tiapi.Entity.Pedido;
import java.util.List;
import java.util.Optional;

public interface IPedidoServicio {
    List<Pedido> buscarTodos();
    Pedido guardar(Pedido pedido);
    void eliminar(Integer id);
    void actualizar(Pedido pedido);
    Optional<Pedido> buscarPorId(Integer id);
}
