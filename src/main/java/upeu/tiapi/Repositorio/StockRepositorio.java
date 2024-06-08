package upeu.tiapi.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.tiapi.Entity.Stock;

public interface StockRepositorio extends JpaRepository<Stock,Integer> {
}
