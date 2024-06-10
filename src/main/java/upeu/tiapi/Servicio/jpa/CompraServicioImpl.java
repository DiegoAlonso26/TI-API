package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.Compra;
import upeu.tiapi.Repositorio.CompraRepositorio;
import upeu.tiapi.Servicio.ICompraServicio;

import java.util.List;
import java.util.Optional;

@Service
public class CompraServicioImpl implements ICompraServicio {
    @Autowired
    private CompraRepositorio compraRepositorio;

    @Override
    public List<Compra> buscarTodos() {
        return compraRepositorio.findAll();
    }

    @Override
    public Compra guardar(Compra compra) {
        compraRepositorio.save(compra);
        return compra;
    }

    @Override
    public void eliminar(Integer id) {
        compraRepositorio.deleteById(id);
    }

    @Override
    public void actualizar(Compra compra) {
        compraRepositorio.save(compra);
    }

    @Override
    public Optional<Compra> buscarPorId(Integer id) {
        return compraRepositorio.findById(id);
    }
}
