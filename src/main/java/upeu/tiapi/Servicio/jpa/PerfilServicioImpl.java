package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.Perfil;
import upeu.tiapi.Repositorio.PerfilRepositorio;
import upeu.tiapi.Servicio.IPerfilesServicio;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilServicioImpl implements IPerfilesServicio {
    @Autowired
    private PerfilRepositorio perfilRepositorio;

    @Override
    public List<Perfil> buscarTodos() {
        return perfilRepositorio.findAll();
    }

    @Override
    public Perfil guardar(Perfil perfil) {
        return perfilRepositorio.save(perfil);
    }

    @Override
    public void eliminar(Integer id) {
        perfilRepositorio.deleteById(id);

    }

    @Override
    public void actualizar(Perfil perfil) {
        perfilRepositorio.save(perfil);

    }

    @Override
    public Optional<Perfil> buscarPorId(Integer id) {
        return perfilRepositorio.findById(id);
    }
}
