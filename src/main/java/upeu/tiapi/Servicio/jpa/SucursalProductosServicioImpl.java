package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.SucursalProductos;
import upeu.tiapi.Repositorio.SucursalProductosRepositorio;
import upeu.tiapi.Servicio.ISucursalProductosServicio;
import upeu.tiapi.Servicio.ISucursalServicio;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalProductosServicioImpl implements ISucursalProductosServicio {
    @Autowired
    private SucursalProductosRepositorio sucursalProductosRepositorio;

    @Override
    public List<SucursalProductos> buscarTodos() {
        return sucursalProductosRepositorio.findAll();
    }

    @Override
    public SucursalProductos guardar(SucursalProductos sucursalProductos) {
        sucursalProductosRepositorio.save(sucursalProductos);
        return sucursalProductos;
    }

    @Override
    public void eliminar(Integer id) {
        sucursalProductosRepositorio.deleteById(id);
    }

    @Override
    public void actualizar(SucursalProductos sucursalProductos) {
        sucursalProductosRepositorio.save(sucursalProductos);
    }

    @Override
    public Optional<SucursalProductos> buscarPorId(Integer id) {
        return sucursalProductosRepositorio.findById(id);
    }
}
