package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.CategoriaFinanciera;
import upeu.tiapi.Repositorio.CategoriaFinancieraRepositorio;
import upeu.tiapi.Servicio.ICategoriaFinancieraServicio;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaFinancieraServicioImpl implements ICategoriaFinancieraServicio {
    @Autowired
    private CategoriaFinancieraRepositorio repositorio;

    @Override
    public List<CategoriaFinanciera> buscarTodos() {
        return repositorio.findAll();
    }

    @Override
    public CategoriaFinanciera guardar(CategoriaFinanciera categoriaFinanciera) {
        return repositorio.save(categoriaFinanciera);
    }

    @Override
    public void eliminar(Integer id) {
        repositorio.deleteById(id);

    }

    @Override
    public void actualizar(CategoriaFinanciera categoriaFinanciera) {
            repositorio.save(categoriaFinanciera);
    }

    @Override
    public Optional<CategoriaFinanciera> buscarPorId(Integer id) {
        return repositorio.findById(id);
    }


}
