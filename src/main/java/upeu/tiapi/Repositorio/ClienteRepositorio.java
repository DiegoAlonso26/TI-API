package upeu.tiapi.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.tiapi.Entity.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
}
