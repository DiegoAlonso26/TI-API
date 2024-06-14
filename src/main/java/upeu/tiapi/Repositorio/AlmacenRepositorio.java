package upeu.tiapi.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.tiapi.Entity.Almacen;

public interface AlmacenRepositorio extends JpaRepository<Almacen, Integer> {
}
