package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.Stock;
import upeu.tiapi.Repositorio.StockRepositorio;
import upeu.tiapi.Servicio.IStockServicio;

import java.util.List;
import java.util.Optional;

@Service
public class StockServicioImpl implements IStockServicio {
    @Autowired
    private StockRepositorio stockRepositorio;

    @Override
    public List<Stock> buscarTodos() {
        return stockRepositorio.findAll();
    }

    @Override
    public Stock guardar(Stock stock) {
        stockRepositorio.save(stock);
        return stock;
    }

    @Override
    public void eliminar(Integer id) {
        stockRepositorio.deleteById(id);
    }

    @Override
    public void actualizar(Stock stock) {
        stockRepositorio.save(stock);
    }

    @Override
    public Optional<Stock> buscarPorId(Integer id) {
        return stockRepositorio.findById(id);
    }
}
