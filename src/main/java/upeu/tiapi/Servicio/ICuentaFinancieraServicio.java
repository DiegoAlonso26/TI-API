package upeu.tiapi.Servicio;


import upeu.tiapi.Entity.CuentaFinanciera;

import java.util.List;
import java.util.Optional;

public interface ICuentaFinancieraServicio {
    List<CuentaFinanciera> buscarTodos();
    CuentaFinanciera guardar(CuentaFinanciera cuentaFinanciera);
    void eliminar(Integer id);
    void actualizar(CuentaFinanciera lugar);
    Optional<CuentaFinanciera> buscarPorId(Integer id);
}
