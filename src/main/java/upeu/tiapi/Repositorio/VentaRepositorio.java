package upeu.tiapi.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.tiapi.Entity.Venta;

import java.util.List;

public interface VentaRepositorio extends JpaRepository<Venta, Integer> {
    List<Venta> findBySucursal(String sucursal);
}
