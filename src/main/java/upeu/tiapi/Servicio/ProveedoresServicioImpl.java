package upeu.tiapi.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.Cliente;
import upeu.tiapi.Entity.Proveedores;
import upeu.tiapi.Repositorio.ProveedoresRepositorio;

import java.util.List;
import java.util.Optional;
@Service
public class ProveedoresServicioImpl implements IProveedoresServicio{
    @Autowired
    private ProveedoresRepositorio proveedoresRepositorio;


    @Override
    public List<Proveedores> buscarTodos() {
        return proveedoresRepositorio.findAll();
    }

    @Override
    public Proveedores guardar(Proveedores proveedores) {
        return proveedoresRepositorio.save(proveedores);
    }

    @Override
    public void eliminar(Integer id) {
        proveedoresRepositorio.deleteById(id);
    }

    @Override
    public void actualizar(Proveedores proveedores) {
        proveedoresRepositorio.save(proveedores);
    }

    @Override
    public Optional<Proveedores> buscarPorId(Integer id) {
        return proveedoresRepositorio.findById(id);
    }
}
