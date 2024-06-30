package upeu.tiapi.Servicio;


import upeu.tiapi.Entity.DetalleVentas;

import java.util.List;
import java.util.Optional;

public interface IDetalleVentasServicio {
    List<DetalleVentas> buscarTodos();
    DetalleVentas guardar(DetalleVentas detalleVenta);
    void eliminar(Integer id);
    DetalleVentas actualizar(DetalleVentas detalleVenta);
    DetalleVentas buscarPorId(Integer id);
}
