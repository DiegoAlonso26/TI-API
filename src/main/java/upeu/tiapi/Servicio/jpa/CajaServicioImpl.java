package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.Caja;
import upeu.tiapi.Repositorio.CajaRepositorio;
import upeu.tiapi.Servicio.ICajaServicio;

import java.util.List;
import java.util.Optional;

@Service
public class CajaServicioImpl implements ICajaServicio {
    @Autowired
    private CajaRepositorio cajaRepositorio;

    @Override
    public List<Caja> buscarTodos() {
        return cajaRepositorio.findAll();
    }

    @Override
    public Caja guardar(Caja caja) {
        cajaRepositorio.save(caja);
        return caja;
    }

    @Override
    public void eliminar(Integer id) {
        cajaRepositorio.deleteById(id);
    }

    @Override
    public void actualizar(Caja caja) {
        cajaRepositorio.save(caja);
    }

    @Override
    public Optional<Caja> buscarPorId(Integer id) {
        return cajaRepositorio.findById(id);
    }
}
