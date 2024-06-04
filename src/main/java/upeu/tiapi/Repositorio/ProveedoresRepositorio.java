package upeu.tiapi.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.tiapi.Entity.Proveedor;

public interface ProveedoresRepositorio extends JpaRepository<Proveedor,Integer> {
}
