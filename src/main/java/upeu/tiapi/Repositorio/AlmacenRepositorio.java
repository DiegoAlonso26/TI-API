package upeu.tiapi.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import upeu.tiapi.Entity.Almacen;

public interface AlmacenRepositorio extends JpaRepository<Almacen, Integer> {
    @Query("SELECT COUNT(p) FROM Producto p WHERE p.almacen.id = :almacenId")
    long countByProductoId(@Param("almacenId") Integer almacenId);

    @Query("SELECT COUNT(a) FROM Almacen a WHERE a.lugar.id = :lugarId")
    long countByLugarId(@Param("lugarId") Integer lugarId);
}
