package upeu.tiapi.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaccionesfinancieras")
@SQLDelete(sql = "UPDATE transaccionesfinancieras SET estado = 0 WHERE id = ?")
@Where(clause = "estado = 1")
public class TransaccionesFinanciera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fecha;
    private String tipoTransaccion;
    private BigDecimal monto;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_cuentaFinanciera")
    private CuentaFinanciera cuentaFinanciera;

    @ManyToOne
    @JoinColumn(name = "id_categoriaFinanciera")
    private CategoriaFinanciera categoriaFinanciera;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "id_compra")
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(nullable = false)
    private Integer estado = 1;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CuentaFinanciera getCuentaFinanciera() {
        return cuentaFinanciera;
    }

    public void setCuentaFinanciera(CuentaFinanciera cuentaFinanciera) {
        this.cuentaFinanciera = cuentaFinanciera;
    }

    public CategoriaFinanciera getCategoriaFinanciera() {
        return categoriaFinanciera;
    }

    public void setCategoriaFinanciera(CategoriaFinanciera categoriaFinanciera) {
        this.categoriaFinanciera = categoriaFinanciera;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}


