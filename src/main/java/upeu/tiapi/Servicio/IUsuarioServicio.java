package upeu.tiapi.Servicio;

import upeu.tiapi.Entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioServicio {
    List<Usuario> buscarTodos();
    Usuario guardar(Usuario usuario);
    void eliminar(Integer id);
    void actualizar(Usuario usuario);
    Optional<Usuario> buscarPorId(Integer id);

}
