package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.Categoria;
import upeu.tiapi.Repositorio.CategoriaRepositorio;
import upeu.tiapi.Servicio.ICategoriaServicio;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServicioImpl implements ICategoriaServicio {
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Override
    public List<Categoria> buscarTodos() {
        return categoriaRepositorio.findAll();
    }

    @Override
    public Categoria guardar(Categoria categoria) {
        categoriaRepositorio.save(categoria);
        return categoria;
    }

    @Override
    public void eliminar(Integer id) {
        categoriaRepositorio.deleteById(id);
    }

    @Override
    public void actualizar(Categoria categoria) {
        categoriaRepositorio.save(categoria);
    }

    @Override
    public Optional<Categoria> buscarPorId(Integer id) {
        return categoriaRepositorio.findById(id);
    }
}
