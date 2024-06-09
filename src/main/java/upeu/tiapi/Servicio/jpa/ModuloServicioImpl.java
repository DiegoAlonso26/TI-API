package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.Modulo;
import upeu.tiapi.Repositorio.ModuloRepositorio;
import upeu.tiapi.Servicio.IModuloServicio;

import java.util.List;
import java.util.Optional;

@Service
public class ModuloServicioImpl implements IModuloServicio {
    @Autowired
    private ModuloRepositorio moduloRepositorio;

    @Override
    public List<Modulo> buscarTodos() {
        return moduloRepositorio.findAll();
    }

    @Override
    public Modulo guardar(Modulo modulo) {
        moduloRepositorio.save(modulo);
        return modulo;
    }

    @Override
    public void eliminar(Integer id) {
        moduloRepositorio.deleteById(id);
    }

    @Override
    public void actualizar(Modulo modulo) {
        moduloRepositorio.save(modulo);
    }

    @Override
    public Optional<Modulo> buscarPorId(Integer id) {
        return moduloRepositorio.findById(id);
    }
}
