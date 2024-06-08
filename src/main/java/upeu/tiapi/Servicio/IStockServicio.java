package upeu.tiapi.Servicio;

import upeu.tiapi.Entity.Stock;

import java.util.List;
import java.util.Optional;

public interface IStockServicio {
    List<Stock> buscarTodos();
    Stock guardar(Stock stock);
    void eliminar(Integer id);
    void actualizar(Stock stock);
    Optional<Stock> buscarPorId(Integer id);
}
