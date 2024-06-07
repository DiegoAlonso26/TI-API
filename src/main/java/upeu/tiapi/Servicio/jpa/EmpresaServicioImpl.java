package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.Empresa;
import upeu.tiapi.Repositorio.EmpresaRepositorio;
import upeu.tiapi.Repositorio.UsuarioRepositorio;
import upeu.tiapi.Servicio.IEmpresaServicio;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServicioImpl implements IEmpresaServicio {
    @Autowired
    private EmpresaRepositorio empresaRepositorio;

    @Override
    public List<Empresa> buscarTodos() {
        return empresaRepositorio.findAll();
    }

    @Override
    public Empresa guardar(Empresa empresa) {
        empresaRepositorio.save(empresa);
        return empresa;
    }

    @Override
    public void eliminar(Integer id)  {
        empresaRepositorio.deleteById(id);
    }

    @Override
    public void actualizar(Empresa empresa) {
        empresaRepositorio.save(empresa);
    }

    @Override
    public Optional<Empresa> buscarPorId(Integer id) {
        return empresaRepositorio.findById(id);
    }
}
