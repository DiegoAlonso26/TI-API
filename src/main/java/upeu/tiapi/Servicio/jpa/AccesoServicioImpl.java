package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.Acceso;
import upeu.tiapi.Repositorio.AccesoRepositorio;
import upeu.tiapi.Servicio.IAccesoServicio;

import java.util.List;
import java.util.Optional;

@Service
public class AccesoServicioImpl implements IAccesoServicio {
    @Autowired
    private AccesoRepositorio accesoRepositorio;

    @Override
    public List<Acceso> buscarTodos() {
        return accesoRepositorio.findAll();
    }

    @Override
    public Acceso guardar(Acceso acceso) {
        accesoRepositorio.save(acceso);
        return acceso;
    }

    @Override
    public void eliminar(Integer id) {
        Optional<Acceso> a = accesoRepositorio.findById(id);
        if (a.get().getEstado()==0){
            a.get().setEstado(1);
            accesoRepositorio.save(a.get());
        } else {
            a.get().setEstado(0);
            accesoRepositorio.save(a.get());
        }
    }

    @Override
    public void actualizar(Acceso acceso) {
        accesoRepositorio.save(acceso);
    }

    @Override
    public Optional<Acceso> buscarPorId(Integer id) {
        return accesoRepositorio.findById(id);
    }
}
