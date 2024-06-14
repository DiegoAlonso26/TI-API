package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.Lugar;
import upeu.tiapi.Repositorio.LugarRepositorio;
import upeu.tiapi.Servicio.ILugarServicio;

import java.util.List;
import java.util.Optional;

@Service
public class LugarServicioImpl  implements ILugarServicio {
    @Autowired
    private LugarRepositorio lugarRepositorio;

    @Override
    public List<Lugar> buscarTodos() {
        return lugarRepositorio.findAll();
    }

    @Override
    public Lugar guardar(Lugar lugar) {
        return lugarRepositorio.save(lugar);
    }

    @Override
    public void eliminar(Integer id) {
        lugarRepositorio.deleteById(id);
    }

    @Override
    public void actualizar(Lugar lugar) {
        lugarRepositorio.save(lugar);
    }

    @Override
    public Optional<Lugar> buscarPorId(Integer id) {
        return lugarRepositorio.findById(id);
    }
}
