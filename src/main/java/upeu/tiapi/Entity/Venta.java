package upeu.tiapi.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ventas")
@SQLDelete(sql = "UPDATE ventas SET estado = 0 WHERE id = ?")
@Where(clause = "estado = 1")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer estado = 1;

    // Relación de clave foránea con la clase Usuario
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    // Relación de clave foránea con la clase Usuario
    @ManyToOne
    @JoinColumn(name = "id_sucursal", nullable = false)
    private Sucursal  sucursal ;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fecha;
    private String tipoPago;
    private String devolucion;
    private BigDecimal total;

    public String getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(String devolucion) {
        this.devolucion = devolucion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}