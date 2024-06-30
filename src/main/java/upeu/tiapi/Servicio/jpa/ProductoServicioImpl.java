package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.Producto;
import upeu.tiapi.Repositorio.ProductoRepositorio;
import upeu.tiapi.Servicio.IProductoServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicioImpl implements IProductoServicio {
    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> listarTodosProductos() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }

    @Override
    public void eliminarProducto(Integer id) {
        productoRepositorio.deleteById(id);
    }

    @Override
    public void actualizarProducto(Producto producto) {
        productoRepositorio.save(producto);
    }


    @Override
    public Optional<Producto> buscarProductoPorId(Integer id) {
        return productoRepositorio.findById(id);
    }
    @Override
    public List<Producto> listarProductosPorSucursal(Integer sucursalId) {
        return productoRepositorio.findBySucursalId(sucursalId);
    }
    @Override
    public void disminuirStock(int productoId, int cantidad) {
        Producto producto = productoRepositorio.findById(productoId)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("Producto no encontrado con el id: " + productoId));

        if (producto.getStock() < cantidad) {
            throw new IllegalArgumentException("Stock insuficiente");
        }

        producto.setStock(producto.getStock() - cantidad);
        productoRepositorio.save(producto);
    }
}
