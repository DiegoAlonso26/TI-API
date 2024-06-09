package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.Pago;
import upeu.tiapi.Repositorio.PagoRepositorio;
import upeu.tiapi.Servicio.IPagoServicio;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServicioImpl implements IPagoServicio {
    @Autowired
    private PagoRepositorio pagoRepositorio;

    @Override
    public List<Pago> buscarTodos() {
        return pagoRepositorio.findAll();
    }

    @Override
    public Pago guardar(Pago pago) {
        pagoRepositorio.save(pago);
        return pago;
    }

    @Override
    public void eliminar(Integer id) {
        pagoRepositorio.deleteById(id);
    }

    @Override
    public void actualizar(Pago pago) {
        pagoRepositorio.save(pago);
    }

    @Override
    public Optional<Pago> buscarPorId(Integer id) {
        return pagoRepositorio.findById(id);
    }
}
