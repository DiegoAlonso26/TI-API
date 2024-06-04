package upeu.tiapi.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.Usuario;
import upeu.tiapi.Repositorio.UsuarioRepositorio;

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
        usuarioRepositorio.deleteById(id);
    }

    @Override
    public Usuario actualizar(Usuario usuario) {
        usuarioRepositorio.save(usuario);
        return usuario;
    }

    @Override
    public Optional<Usuario> buscarPorId(Integer id) {
        return usuarioRepositorio.findById(id);
    }
}
