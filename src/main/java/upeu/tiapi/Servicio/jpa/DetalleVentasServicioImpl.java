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
    private DetalleVentasRepositorio detalleVentaRepositorio;

    @Override
    public List<DetalleVentas> buscarTodos() {
        return detalleVentaRepositorio.findAll();
    }

    @Override
    public DetalleVentas guardar(DetalleVentas detalleVenta) {
        return detalleVentaRepositorio.save(detalleVenta);
    }

    @Override
    public void eliminar(Integer id) {
        detalleVentaRepositorio.deleteById(id);
    }

    @Override
    public DetalleVentas actualizar(DetalleVentas detalleVenta) {
        return detalleVentaRepositorio.save(detalleVenta);
    }

    @Override
    public DetalleVentas buscarPorId(Integer id) {
        return detalleVentaRepositorio.findById(id).orElse(null);
    }
}
