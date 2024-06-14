package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.TransaccionesFinanciera;
import upeu.tiapi.Repositorio.TransaccionesFinancierasRepositorio;
import upeu.tiapi.Servicio.ITransaccionesFinancierasServicio;

import java.util.List;
import java.util.Optional;
@Service
public class TransaccionesFinancieraServicioImpl implements ITransaccionesFinancierasServicio {
    @Autowired
    private TransaccionesFinancierasRepositorio repo;
    @Override
    public List<TransaccionesFinanciera> buscarTodos() {
        return repo.findAll();
    }

    @Override
    public TransaccionesFinanciera guardar(TransaccionesFinanciera transaccionesFinanciera) {
        return repo.save(transaccionesFinanciera);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public void actualizar(TransaccionesFinanciera transaccionesFinanciera) {
        repo.save(transaccionesFinanciera);
    }

    @Override
    public Optional<TransaccionesFinanciera> buscarPorId(Integer id) {
        return repo.findById(id);
    }
}
