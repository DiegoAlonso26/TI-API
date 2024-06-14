package upeu.tiapi.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.tiapi.Entity.DetalleCompra;

public interface DetalleCompraRepositorio extends JpaRepository<DetalleCompra, Integer> {
}
