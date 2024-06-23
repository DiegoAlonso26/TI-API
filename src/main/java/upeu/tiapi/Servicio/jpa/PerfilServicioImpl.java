package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.Acceso;
import upeu.tiapi.Entity.Modulo;
import upeu.tiapi.Entity.Perfil;
import upeu.tiapi.Repositorio.AccesoRepositorio;
import upeu.tiapi.Repositorio.ModuloRepositorio;
import upeu.tiapi.Repositorio.PerfilRepositorio;
import upeu.tiapi.Servicio.IPerfilesServicio;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PerfilServicioImpl implements IPerfilesServicio {
    @Autowired
    private PerfilRepositorio perfilRepositorio;
    @Autowired
    private ModuloRepositorio moduloRepositorio;
    @Autowired
    private AccesoRepositorio accesoRepositorio;

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

    @Override
    public Optional<List<Modulo>> buscarPorModulo(Integer id) {
        return Optional.of(accesoRepositorio.findAll().stream().filter(acceso1 -> acceso1.getPerfil().getId().equals(id)).map(acceso2 -> acceso2.getModulo()).toList());
    }
}
