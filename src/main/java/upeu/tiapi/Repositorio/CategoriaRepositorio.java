package upeu.tiapi.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.tiapi.Entity.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria,Integer> {
}
