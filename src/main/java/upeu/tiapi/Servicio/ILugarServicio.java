package upeu.tiapi.Servicio;


import upeu.tiapi.Entity.Lugar;

import java.util.List;
import java.util.Optional;

public interface ILugarServicio {
    List<Lugar> buscarTodos();
    Lugar guardar(Lugar lugar);
    void eliminar(Integer id);
    void actualizar(Lugar lugar);
    Optional<Lugar> buscarPorId(Integer id);
}
