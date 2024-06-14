package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.Devolucion;
import upeu.tiapi.Repositorio.DevolucionRepositorio;
import upeu.tiapi.Servicio.IDevolucionServicio;

import java.util.List;
import java.util.Optional;
@Service
public class DevolucionServicioImpl implements IDevolucionServicio {
    @Autowired
    private DevolucionRepositorio repositorio;
    @Override
    public List<Devolucion> buscarTodos() {
        return repositorio.findAll();
    }

    @Override
    public Devolucion guardar(Devolucion devolucion) {
        return repositorio.save(devolucion);
    }

    @Override
    public void eliminar(Integer id) {
        repositorio.deleteById(id);

    }

    @Override
    public void actualizar(Devolucion devolucion) {
        repositorio.save(devolucion);
    }

    @Override
    public Optional<Devolucion> buscarPorId(Integer id) {
        return repositorio.findById(id);
    }
}
