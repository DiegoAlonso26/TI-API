package upeu.tiapi.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.tiapi.Entity.CuentaFinanciera;

public interface CuentaFinancieraRepositorio extends JpaRepository<CuentaFinanciera, Integer> {
}
