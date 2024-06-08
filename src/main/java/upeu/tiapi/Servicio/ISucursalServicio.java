package upeu.tiapi.Servicio;

import upeu.tiapi.Entity.Sucursal;
import java.util.List;
import java.util.Optional;

public interface ISucursalServicio {
    List<Sucursal> buscarTodos();
    Sucursal guardar(Sucursal sucursal);
    void eliminar(Integer id);
    void actualizar(Sucursal sucursal);
    Optional<Sucursal> buscarPorId(Integer id);
}
