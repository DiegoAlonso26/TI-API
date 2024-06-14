package upeu.tiapi.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.tiapi.Entity.TransaccionesFinanciera;

public interface TransaccionesFinancierasRepositorio extends JpaRepository<TransaccionesFinanciera, Integer> {
}
