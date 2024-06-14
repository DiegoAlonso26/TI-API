package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.Garantia;
import upeu.tiapi.Repositorio.GarantiaRepositorio;
import upeu.tiapi.Servicio.IGarantiaServicio;

import java.util.List;
import java.util.Optional;

@Service
public class GarantiaServicioImpl implements IGarantiaServicio {
    @Autowired
    private GarantiaRepositorio repositorio;
    @Override
    public List<Garantia> buscarTodos() {
        return repositorio.findAll();
    }

    @Override
    public Garantia guardar(Garantia garantia) {
        return repositorio.save(garantia);
    }

    @Override
    public void eliminar(Integer id) {
        repositorio.deleteById(id);

    }

    @Override
    public void actualizar(Garantia garantia) {
        repositorio.save(garantia);

    }

    @Override
    public Optional<Garantia> buscarPorId(Integer id) {
        return repositorio.findById(id);
    }
}
