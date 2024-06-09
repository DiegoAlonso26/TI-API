package upeu.tiapi.Servicio;

import upeu.tiapi.Entity.Acceso;

import java.util.List;
import java.util.Optional;

public interface IAccesoServicio {
    List<Acceso> buscarTodos();
    Acceso guardar(Acceso acceso);
    void eliminar(Integer id);
    void actualizar(Acceso acceso);
    Optional<Acceso> buscarPorId(Integer id);
}
