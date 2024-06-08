package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.DetalleVentas;
import upeu.tiapi.Repositorio.DetalleVentasRepositorio;
import upeu.tiapi.Servicio.IDetalleVentasServicio;

import java.util.List;
import java.util.Optional;
@Service
public class DetalleVentasServicioImpl implements IDetalleVentasServicio {
    @Autowired
    private DetalleVentasRepositorio detalleVentasRepositorio;
    @Override
    public void actualizar(DetalleVentas detalleVentas) {
        detalleVentasRepositorio.save(detalleVentas);

    }

    @Override
    public List<DetalleVentas> buscarTodos() {
        return detalleVentasRepositorio.findAll();
    }

    @Override
    public DetalleVentas guardar(DetalleVentas detalleVentas) {
        return detalleVentasRepositorio.save(detalleVentas);
    }

    @Override
    public void eliminar(Integer id) {
        detalleVentasRepositorio.deleteById(id);

    }

    @Override
    public Optional<DetalleVentas> buscarPorId(Integer id) {
        return detalleVentasRepositorio.findById(id);
    }
}
