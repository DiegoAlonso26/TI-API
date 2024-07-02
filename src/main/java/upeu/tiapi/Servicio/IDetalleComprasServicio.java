package upeu.tiapi.Servicio;


import upeu.tiapi.Entity.DetalleCompra;

import java.util.List;
import java.util.Optional;

public interface IDetalleComprasServicio {
    List<DetalleCompra> buscarTodos();
    DetalleCompra guardar(DetalleCompra detalleCompra);
    void eliminar(Integer id);
    void actualizar(DetalleCompra detalleCompra);
    Optional<DetalleCompra> buscarPorId(Integer id);
    List<DetalleCompra> buscarPorIdCompra(Integer compra);
}
