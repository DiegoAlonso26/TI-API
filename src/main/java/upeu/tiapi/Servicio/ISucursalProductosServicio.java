package upeu.tiapi.Servicio;

import upeu.tiapi.Entity.SucursalProductos;

import java.util.List;
import java.util.Optional;

public interface ISucursalProductosServicio {
    List<SucursalProductos> buscarTodos();
    SucursalProductos guardar(SucursalProductos sucursalProductos);
    void eliminar(Integer id);
    void actualizar(SucursalProductos sucursalProductos);
    Optional<SucursalProductos> buscarPorId(Integer id);
}
