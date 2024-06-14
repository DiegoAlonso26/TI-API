package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.CuentaFinanciera;
import upeu.tiapi.Repositorio.CuentaFinancieraRepositorio;
import upeu.tiapi.Servicio.ICuentaFinancieraServicio;

import java.util.List;
import java.util.Optional;
@Service
public class CuentaFinancieraServicioImpl implements ICuentaFinancieraServicio {
    @Autowired
    private CuentaFinancieraRepositorio repositorio;
    @Override
    public List<CuentaFinanciera> buscarTodos() {
        return repositorio.findAll();
    }

    @Override
    public CuentaFinanciera guardar(CuentaFinanciera cuentaFinanciera) {
        return repositorio.save(cuentaFinanciera);
    }

    @Override
    public void eliminar(Integer id) {
        repositorio.deleteById(id);
    }

    @Override
    public void actualizar(CuentaFinanciera lugar) {
        repositorio.save(lugar);
    }

    @Override
    public Optional<CuentaFinanciera> buscarPorId(Integer id) {
        return repositorio.findById(id);
    }
}
