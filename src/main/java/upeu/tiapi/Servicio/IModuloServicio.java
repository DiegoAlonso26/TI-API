package upeu.tiapi.Servicio;

import upeu.tiapi.Entity.Modulo;

import java.util.List;
import java.util.Optional;

public interface IModuloServicio {
    List<Modulo> buscarTodos();
    Modulo guardar(Modulo modulo);
    void eliminar(Integer id);
    void actualizar(Modulo modulo);
    Optional<Modulo> buscarPorId(Integer id);
}
