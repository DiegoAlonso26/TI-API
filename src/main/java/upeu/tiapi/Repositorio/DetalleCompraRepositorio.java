package upeu.tiapi.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.tiapi.Entity.DetalleCompra;

import java.util.List;

public interface DetalleCompraRepositorio extends JpaRepository<DetalleCompra, Integer> {
    List<DetalleCompra> findByCompraId(Integer compra);
}
