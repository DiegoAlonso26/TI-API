package upeu.tiapi.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import upeu.tiapi.Entity.Producto;

import java.util.List;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
    @Query("SELECT COUNT(p) FROM Producto p WHERE p.almacen.id = :almacenId")
    long countByAlmacenId(@Param("almacenId") Integer almacenId);

    @Query("SELECT COUNT(p) FROM Producto p WHERE p.categoria.id = :categoriaId")
    long countByCategoriaId(@Param("categoriaId") Integer categoriaId);

    List<Producto> findBySucursalId(Integer sucursalId);

}
