package upeu.tiapi.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.tiapi.Entity.Venta;

public interface VentaRepositorio extends JpaRepository<Venta, Integer> {
}
