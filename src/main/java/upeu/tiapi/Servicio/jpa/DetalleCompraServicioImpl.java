package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.DetalleCompra;
import upeu.tiapi.Repositorio.DetalleCompraRepositorio;
import upeu.tiapi.Servicio.IDetalleComprasServicio;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleCompraServicioImpl implements IDetalleComprasServicio {
    @Autowired
    private DetalleCompraRepositorio repositorio;

    @Override
    public List<DetalleCompra> buscarTodos() {
        return repositorio.findAll();
    }

    @Override
    public DetalleCompra guardar(DetalleCompra detalleCompra) {
        return repositorio.save(detalleCompra);
    }

    @Override
    public void eliminar(Integer id) {
        repositorio.deleteById(id);

    }

    @Override
    public void actualizar(DetalleCompra detalleCompra) {
        repositorio.save(detalleCompra);
    }

    @Override
    public Optional<DetalleCompra> buscarPorId(Integer id) {
        return repositorio.findById(id);
    }
    @Override
    public List<DetalleCompra> buscarPorIdCompra(Integer compra) {
        return repositorio.findByCompraId(compra);
    }
}
