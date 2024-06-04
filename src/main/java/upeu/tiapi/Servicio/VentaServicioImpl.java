package upeu.tiapi.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.Venta;
import upeu.tiapi.Repositorio.VentaRepositorio;

import java.util.List;
import java.util.Optional;
@Service
public class VentaServicioImpl implements IVentasServicio{
    @Autowired
    private VentaRepositorio ventaRepositorio;

    @Override
    public List<Venta> buscarTodos() {
        return ventaRepositorio.findAll();
    }

    @Override
    public Venta guardar(Venta venta) {
        return ventaRepositorio.save(venta);
    }

    @Override
    public void eliminar(Integer id) {
        ventaRepositorio.deleteById(id);
    }

    @Override
    public Venta actualizar(Venta venta) {
       return ventaRepositorio.save(venta);
    }

    @Override
    public Optional<Venta> buscarPorId(Integer id) {
        return ventaRepositorio.findById(id);
    }
}
