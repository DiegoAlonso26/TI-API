package upeu.tiapi.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.tiapi.Entity.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
}