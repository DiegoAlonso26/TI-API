package upeu.tiapi.Servicio;


import upeu.tiapi.Entity.Devolucion;

import java.util.List;
import java.util.Optional;

public interface IDevolucionServicio {
    List<Devolucion> buscarTodos();
    Devolucion guardar(Devolucion devolucion);
    void eliminar(Integer id);
    void actualizar(Devolucion devolucion);
    Optional<Devolucion> buscarPorId(Integer id);
}
