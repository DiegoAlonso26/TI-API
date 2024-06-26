package upeu.tiapi.Servicio;

import upeu.tiapi.Entity.Producto;
import java.util.List;
import java.util.Optional;

public interface IProductoServicio {
    List<Producto> listarTodosProductos();
    Producto guardarProducto(Producto producto);
    void eliminarProducto(Integer id);
    void actualizarProducto(Producto producto);
    Optional<Producto> buscarProductoPorId(Integer id);
    List<Producto> listarProductosPorSucursal(Integer sucursalId);
    void disminuirStock(int productoId, int cantidad);
}
