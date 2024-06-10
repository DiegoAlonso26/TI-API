package upeu.tiapi.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.tiapi.Entity.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido,Integer> {
}
