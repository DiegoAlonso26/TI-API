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
        Optional<Producto> productoExistente = productoRepositorio.findById(producto.getId());
        if (productoExistente.isPresent()) {
            Producto prod = productoExistente.get();
            prod.setNombre(producto.getNombre());
            prod.setDescripcion(producto.getDescripcion());
            prod.setPrecio(producto.getPrecio());
            prod.setCategoria(producto.getCategoria());
            productoRepositorio.save(prod);
        } else {
            throw new RecursoNoEncontradoExcepcion("No se encontró el producto con el id: " + producto.getId());
        }
    }

    @Override
    public Optional<Producto> buscarProductoPorId(Integer id) {
        return productoRepositorio.findById(id);
    }
}
