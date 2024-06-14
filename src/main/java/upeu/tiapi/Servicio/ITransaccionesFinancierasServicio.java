package upeu.tiapi.Servicio;


import upeu.tiapi.Entity.TransaccionesFinanciera;

import java.util.List;
import java.util.Optional;

public interface ITransaccionesFinancierasServicio {
    List<TransaccionesFinanciera> buscarTodos();
    TransaccionesFinanciera guardar(TransaccionesFinanciera transaccionesFinanciera);
    void eliminar(Integer id);
    void actualizar(TransaccionesFinanciera transaccionesFinanciera);
    Optional<TransaccionesFinanciera> buscarPorId(Integer id);
}
