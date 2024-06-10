package upeu.tiapi.Servicio;

import upeu.tiapi.Entity.Compra;
import java.util.List;
import java.util.Optional;

public interface ICompraServicio {
    List<Compra> buscarTodos();
    Compra guardar(Compra compra);
    void eliminar(Integer id);
    void actualizar(Compra compra);
    Optional<Compra> buscarPorId(Integer id);
}
