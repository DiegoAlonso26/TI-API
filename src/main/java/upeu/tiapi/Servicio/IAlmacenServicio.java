package upeu.tiapi.Servicio;


import upeu.tiapi.Entity.Almacen;

import java.util.List;
import java.util.Optional;

public interface IAlmacenServicio {
    List<Almacen> buscarTodos();
    Almacen guardar(Almacen almacen);
    void eliminar(Integer id);
    void actualizar(Almacen almacen);
    Optional<Almacen> buscarPorId(Integer id);
}
