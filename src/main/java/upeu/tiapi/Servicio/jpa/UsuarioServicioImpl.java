package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.Usuario;
import upeu.tiapi.Repositorio.UsuarioRepositorio;
import upeu.tiapi.Servicio.IUsuarioServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioServicioImpl implements IUsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public List<Usuario> buscarTodos() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        usuarioRepositorio.save(usuario);
        return usuario;
    }

    @Override
    public void eliminar(Integer id) {
        Optional<Usuario> usuarioOpt = usuarioRepositorio.findById(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.setEstado(0);
            usuarioRepositorio.save(usuario);
        } else {
            throw new RecursoNoEncontradoExcepcion("No se encontró el usuario con el id: " + id);
        }
    }


    @Override
    public void actualizar(Usuario usuario) {
        usuarioRepositorio.save(usuario);

    }

    @Override
    public Optional<Usuario> buscarPorId(Integer id) {
        return usuarioRepositorio.findById(id);
    }
}
