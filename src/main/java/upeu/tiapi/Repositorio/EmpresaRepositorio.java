package upeu.tiapi.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.tiapi.Entity.Empresa;

public interface EmpresaRepositorio extends JpaRepository<Empresa, Integer> {

}
