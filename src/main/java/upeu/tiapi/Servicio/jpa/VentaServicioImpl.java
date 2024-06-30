package upeu.tiapi.Servicio.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.tiapi.Entity.DetalleVentas;
import upeu.tiapi.Entity.Producto;
import upeu.tiapi.Entity.Venta;
import upeu.tiapi.Repositorio.ProductoRepositorio;
import upeu.tiapi.Repositorio.VentaRepositorio;
import upeu.tiapi.Servicio.IVentasServicio;
import upeu.tiapi.excepcion.RecursoNoEncontradoExcepcion;

import java.util.List;
import java.util.Optional;
@Service
public class VentaServicioImpl implements IVentasServicio {

    @Autowired
    private VentaRepositorio ventaRepositorio;
    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public List<Venta> buscarTodos() {
        return ventaRepositorio.findAll();
    }


    @Override
    public Venta guardar(Venta venta) {
        for (DetalleVentas detalle : venta.getDetalles()) {
            Producto producto = productoRepositorio.findById(detalle.getProducto().getId())
                    .orElseThrow(() -> new RecursoNoEncontradoExcepcion("Producto no encontrado con el id: " + detalle.getProducto().getId()));
            if (producto.getStock() < detalle.getCantidad()) {
                throw new IllegalArgumentException("Stock insuficiente para el producto: " + producto.getNombre());
            }
            producto.setStock(producto.getStock() - detalle.getCantidad());
            productoRepositorio.save(producto);
            detalle.setVenta(venta);
        }
        return ventaRepositorio.save(venta);
    }

    @Override
    public void eliminar(Integer id) {
        ventaRepositorio.deleteById(id);
    }

    @Override
    public Venta actualizar(Venta venta) {
        return ventaRepositorio.save(venta);
    }

    @Override
    public Optional<Venta> buscarPorId(Integer id) {
        return ventaRepositorio.findById(id);
    }

}
