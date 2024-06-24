package upeu.tiapi.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;

@Entity
@Table(name = "productos")
@SQLDelete(sql = "UPDATE productos SET estado = 0 WHERE id = ?")
@Where(clause = "estado = 1")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private BigDecimal precio_mayor;
    private BigDecimal precio_menor;
    private BigDecimal precio_promocion;


    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_almacen")
    private Almacen almacen;
    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;

    @Column(nullable = false)
    private Integer estado = 1;

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio_mayor() {
        return precio_mayor;
    }

    public void setPrecio_mayor(BigDecimal precio_mayor) {
        this.precio_mayor = precio_mayor;
    }

    public BigDecimal getPrecio_menor() {
        return precio_menor;
    }

    public void setPrecio_menor(BigDecimal precio_menor) {
        this.precio_menor = precio_menor;
    }

    public BigDecimal getPrecio_promocion() {
        return precio_promocion;
    }

    public void setPrecio_promocion(BigDecimal precio_promocion) {
        this.precio_promocion = precio_promocion;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}
