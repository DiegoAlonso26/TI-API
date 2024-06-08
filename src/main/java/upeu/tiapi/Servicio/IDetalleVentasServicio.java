package upeu.tiapi.Servicio;


import upeu.tiapi.Entity.DetalleVentas;

import java.util.List;
import java.util.Optional;

public interface IDetalleVentasServicio {
    List<DetalleVentas> buscarTodos();
    DetalleVentas guardar(DetalleVentas detalleVentas);
    void eliminar(Integer id);
    void actualizar(DetalleVentas detalleVentas);
    Optional<DetalleVentas> buscarPorId(Integer id);
}
