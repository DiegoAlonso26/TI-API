package upeu.tiapi.Servicio;


import upeu.tiapi.Entity.Proveedor;

import java.util.List;
import java.util.Optional;

public interface IProveedoresServicio {
    List<Proveedor> buscarTodos();
    Proveedor guardar(Proveedor proveedores);
    void eliminar(Integer id);
    void actualizar(Proveedor proveedores);
    Optional<Proveedor> buscarPorId(Integer id);
}
