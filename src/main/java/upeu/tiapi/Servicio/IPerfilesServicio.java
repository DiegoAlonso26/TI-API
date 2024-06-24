package upeu.tiapi.Servicio;


import upeu.tiapi.Entity.Modulo;
import upeu.tiapi.Entity.Perfil;

import java.util.List;
import java.util.Optional;

public interface IPerfilesServicio {
    List<Perfil> buscarTodos();
    Perfil guardar(Perfil perfil);
    void eliminar(Integer id);
    void actualizar(Perfil perfil);
    Optional<Perfil> buscarPorId(Integer id);
    Optional<List<Modulo>> buscarPorModulo(Integer id);
}
