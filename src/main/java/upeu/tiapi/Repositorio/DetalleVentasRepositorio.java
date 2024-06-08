package upeu.tiapi.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.tiapi.Entity.DetalleVentas;

public interface DetalleVentasRepositorio extends JpaRepository<DetalleVentas, Integer> {
}
