package upeu.tiapi.Entity;
import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "sucursalproductos")
@SQLDelete(sql = "UPDATE sucursalproductos SET estado = 0 WHERE id = ?")
@Where(clause = "estado = 1")
@ToString
public class SucursalProductos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @ManyToOne
    @JoinColumn( name = "idproducto", nullable = false)
    private Producto producto;
    private String cantidad;
    @Column(nullable = false)
    private Integer estado = 1;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
