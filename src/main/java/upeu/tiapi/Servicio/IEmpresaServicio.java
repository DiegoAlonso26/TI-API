package upeu.tiapi.Servicio;


import upeu.tiapi.Entity.Empresa;

import java.util.List;
import java.util.Optional;

public interface IEmpresaServicio {
    List<Empresa> buscarTodos();
    Empresa guardar(Empresa empresa);
    void eliminar(Integer id);
    void actualizar(Empresa empresa);
    Optional<Empresa> buscarPorId(Integer id);

}
