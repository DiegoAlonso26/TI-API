package upeu.tiapi.Servicio;

import upeu.tiapi.Entity.Garantia;

import java.util.List;
import java.util.Optional;

public interface IGarantiaServicio {
    List<Garantia> buscarTodos();
    Garantia guardar(Garantia garantia);
    void eliminar(Integer id);
    void actualizar(Garantia garantia);
    Optional<Garantia> buscarPorId(Integer id);
}
