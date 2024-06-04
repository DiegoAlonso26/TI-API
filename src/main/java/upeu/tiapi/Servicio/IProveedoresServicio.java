package upeu.tiapi.Servicio;


import upeu.tiapi.Entity.Proveedores;

import java.util.List;
import java.util.Optional;

public interface IProveedoresServicio {
    List<Proveedores> buscarTodos();
    Proveedores guardar(Proveedores proveedores);
    void eliminar(Integer id);
    void actualizar(Proveedores proveedores);
    Optional<Proveedores> buscarPorId(Integer id);
}
