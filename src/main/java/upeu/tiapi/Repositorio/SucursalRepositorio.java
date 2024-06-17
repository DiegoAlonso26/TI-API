package upeu.tiapi.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import upeu.tiapi.Entity.Sucursal;

public interface SucursalRepositorio extends JpaRepository<Sucursal,Integer> {
    @Query("SELECT COUNT(s) FROM Sucursal s WHERE s.lugar.id = :lugarId")
    long countByLugarId(@Param("lugarId") Integer lugarId);

}
