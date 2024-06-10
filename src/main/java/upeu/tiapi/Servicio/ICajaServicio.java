package upeu.tiapi.Servicio;

import upeu.tiapi.Entity.Caja;
import java.util.List;
import java.util.Optional;

public interface ICajaServicio {
    List<Caja> buscarTodos();
    Caja guardar(Caja caja);
    void eliminar(Integer id);
    void actualizar(Caja caja);
    Optional<Caja> buscarPorId(Integer id);
}
