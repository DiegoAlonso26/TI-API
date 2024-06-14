package upeu.tiapi.Servicio;


import upeu.tiapi.Entity.CategoriaFinanciera;

import java.util.List;
import java.util.Optional;

public interface ICategoriaFinancieraServicio {
    List<CategoriaFinanciera> buscarTodos();
    CategoriaFinanciera guardar(CategoriaFinanciera categoriaFinanciera);
    void eliminar(Integer id);
    void actualizar(CategoriaFinanciera categoriaFinanciera);
    Optional<CategoriaFinanciera> buscarPorId(Integer id);
}
