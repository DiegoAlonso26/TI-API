package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.Perfil;
import upeu.tiapi.Entity.Sucursal;
import upeu.tiapi.Entity.Usuario;
import upeu.tiapi.Repositorio.PerfilRepositorio;
import upeu.tiapi.Repositorio.SucursalRepositorio;
import upeu.tiapi.Repositorio.UsuarioRepositorio;
import upeu.tiapi.Servicio.IUsuarioServicio;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioServicioImpl implements IUsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private SucursalRepositorio sucursalRepositorio; // Repositorio para Sucursal

    @Autowired
    private PerfilRepositorio perfilRepositorio; // Repositorio para Perfil

    @Override
    public List<Usuario> buscarTodos() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        // Validar y crear la sucursal si es necesario
        if (usuario.getSucursal() != null) {
            if (usuario.getSucursal().getId() == null) {
                // La sucursal no tiene ID, entonces la estamos creando
                Sucursal sucursalCreada = sucursalRepositorio.save(usuario.getSucursal());
                usuario.setSucursal(sucursalCreada); // Actualizar el usuario con la sucursal creada
            } else {
                // Verificar si la sucursal existe en la base de datos
                Optional<Sucursal> sucursalExistente = sucursalRepositorio.findById(usuario.getSucursal().getId());
                if (sucursalExistente.isEmpty()) {
                    throw new IllegalArgumentException("La sucursal especificada no existe en la base de datos");
                }
                // Actualizar el usuario con la sucursal existente
                usuario.setSucursal(sucursalExistente.get());
            }
        } else {
            throw new IllegalArgumentException("La sucursal no puede ser nula");
        }

        // Validar y crear el perfil si es necesario
        if (usuario.getPerfil() != null) {
            if (usuario.getPerfil().getId() == null) {
                // El perfil no tiene ID, entonces lo estamos creando
                Perfil perfilCreado = perfilRepositorio.save(usuario.getPerfil());
                usuario.setPerfil(perfilCreado); // Actualizar el usuario con el perfil creado
            } else {
                // Verificar si el perfil existe en la base de datos (esto es opcional dependiendo de la lógica de tu aplicación)
                // Puedes implementar una verificación similar a la de la sucursal si es necesario
            }
        }

        // Guardar el usuario
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public void eliminar(Integer id) {
        usuarioRepositorio.deleteById(id);
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
