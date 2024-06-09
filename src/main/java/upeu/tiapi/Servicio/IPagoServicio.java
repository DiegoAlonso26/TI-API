package upeu.tiapi.Servicio;

import upeu.tiapi.Entity.Pago;

import java.util.List;
import java.util.Optional;

public interface IPagoServicio {
    List<Pago> buscarTodos();
    Pago guardar(Pago pago);
    void eliminar(Integer id);
    void actualizar(Pago pago);
    Optional<Pago> buscarPorId(Integer id);
}
