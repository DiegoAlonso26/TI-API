package upeu.tiapi.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upeu.tiapi.Entity.Venta;
import upeu.tiapi.Servicio.IVentasServicio;
import java.util.List;

@RestController
@RequestMapping("/api-ti")
@CrossOrigin(origins = "*")

public class ReportesControlador {
    @Autowired
    private IVentasServicio ventasServicio;

    @GetMapping("/reportes")
    public List<Venta>Listar(){
        return ventasServicio.buscarTodos();
    }

    @GetMapping("/ventas/sucursal/{sucursal}")
    public List<Venta> obtenerVentasPorSucursal(@PathVariable String sucursal) {
        return ventasServicio.buscarPorSucursal(sucursal);
    }
}
