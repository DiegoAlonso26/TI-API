package upeu.tiapi.Servicio;

import upeu.tiapi.Entity.Producto;
import java.util.List;
import java.util.Optional;

public interface IProductoServicio {
    List<Producto> listarTodosProductos();
    Producto guardarProducto(Producto producto);
    void eliminarProducto(Integer id);
    Producto actualizarProducto(Producto producto);
    Optional<Producto> buscarProductoPorId(Integer id);
}
