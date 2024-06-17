package upeu.tiapi.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import upeu.tiapi.Entity.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria,Integer> {
    @Query("SELECT COUNT(p) FROM Producto p WHERE p.categoria.id = :categoriaId")
    long countByProductoId(@Param("categoriaId") Integer categoriaId);

    @Query("SELECT COUNT(p) FROM Producto p WHERE p.almacen.id = :almacenId")
    long countByAlmacenId(@Param("almacenId") Integer almacenId);

}
