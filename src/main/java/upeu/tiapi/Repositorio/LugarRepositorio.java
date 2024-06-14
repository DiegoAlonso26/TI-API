package upeu.tiapi.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.tiapi.Entity.Lugar;

public interface LugarRepositorio extends JpaRepository<Lugar, Integer> {
}
