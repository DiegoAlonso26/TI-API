package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.Almacen;
import upeu.tiapi.Repositorio.AlmacenRepositorio;
import upeu.tiapi.Servicio.IAlmacenServicio;

import java.util.List;
import java.util.Optional;
@Service
public class AlmacenServicioImpl implements IAlmacenServicio {

    @Autowired
    private AlmacenRepositorio almacenRepositorio;
    @Override
    public List<Almacen> buscarTodos() {
        return  almacenRepositorio.findAll();
    }

    @Override
    public Almacen guardar(Almacen almacen) {
        return almacenRepositorio.save(almacen);
    }

    @Override
    public void eliminar(Integer id) {
        almacenRepositorio.deleteById(id);
    }

    @Override
    public void actualizar(Almacen almacen) {
        almacenRepositorio.save(almacen);
    }

    @Override
    public Optional<Almacen> buscarPorId(Integer id) {
        return almacenRepositorio.findById(id);
    }
}
