package upeu.tiapi.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.tiapi.Entity.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

}
