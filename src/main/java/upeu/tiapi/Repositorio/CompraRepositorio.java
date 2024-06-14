package upeu.tiapi.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import upeu.tiapi.Entity.Compra;

public interface CompraRepositorio extends JpaRepository<Compra,Integer> {
    @Query("SELECT COUNT(c) FROM Compra c WHERE c.proveedor.id = :proveedorId")
    long countByProveedorId(@Param("proveedorId") Integer proveedorId);
}
