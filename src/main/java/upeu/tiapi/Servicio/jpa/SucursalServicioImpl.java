package upeu.tiapi.Servicio.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.Sucursal;
import upeu.tiapi.Repositorio.SucursalRepositorio;
import upeu.tiapi.Repositorio.UsuarioRepositorio;
import upeu.tiapi.Servicio.ISucursalServicio;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalServicioImpl implements ISucursalServicio {
    @Autowired
    private SucursalRepositorio sucursalRepositorio;

    @Override
    public List<Sucursal> buscarTodos() {
        return sucursalRepositorio.findAll();
    }

    @Override
    public Sucursal guardar(Sucursal sucursal) {
        sucursalRepositorio.save(sucursal);
        return sucursal;
    }

    @Override
    public void eliminar(Integer id) {
        sucursalRepositorio.deleteById(id);
    }

    @Override
    public void actualizar(Sucursal sucursal) {
        sucursalRepositorio.save(sucursal);
    }

    @Override
    public Optional<Sucursal> buscarPorId(Integer id) {
        return sucursalRepositorio.findById(id);
    }
}
