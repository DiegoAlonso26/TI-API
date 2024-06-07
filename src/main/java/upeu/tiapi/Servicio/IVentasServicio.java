package upeu.tiapi.Servicio;


import upeu.tiapi.Entity.Venta;

import java.util.List;
import java.util.Optional;

public interface IVentasServicio {
    List<Venta> buscarTodos();
    Venta guardar(Venta venta);
    void eliminar(Integer id);
    void actualizar(Venta venta);
    Optional<Venta> buscarPorId(Integer id);
}
