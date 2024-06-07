package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.Proveedor;
import upeu.tiapi.Repositorio.ProveedoresRepositorio;
import upeu.tiapi.Servicio.IProveedoresServicio;

import java.util.List;
import java.util.Optional;
@Service
public class ProveedoresServicioImpl implements IProveedoresServicio {
    @Autowired
    private ProveedoresRepositorio proveedoresRepositorio;


    @Override
    public List<Proveedor> buscarTodos() {
        return proveedoresRepositorio.findAll();
    }

    @Override
    public Proveedor guardar(Proveedor proveedores) {
        return proveedoresRepositorio.save(proveedores);
    }

    @Override
    public void eliminar(Integer id) {
        proveedoresRepositorio.deleteById(id);
    }

    @Override
    public void actualizar(Proveedor proveedores) {
        proveedoresRepositorio.save(proveedores);
    }

    @Override
    public Optional<Proveedor> buscarPorId(Integer id) {
        return proveedoresRepositorio.findById(id);
    }
}
