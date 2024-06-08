package upeu.tiapi.Servicio;


import upeu.tiapi.Entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface ICategoriaServicio {
    List<Categoria> buscarTodos();
    Categoria guardar(Categoria categoria);
    void eliminar(Integer id);
    void actualizar(Categoria categoria);
    Optional<Categoria> buscarPorId(Integer id);
}
