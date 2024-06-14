package upeu.tiapi.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "productos")
@SQLDelete(sql = "UPDATE productos SET estado = 0 WHERE id = ?")
@Where(clause = "estado = 1")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String precio_mayor;
    private String precio_menor;
    private String precio_promocion;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_almacen")
    private Almacen almacen;
    private Integer estado;

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

    public String getPrecio_mayor() {
        return precio_mayor;
    }

    public void setPrecio_mayor(String precio_mayor) {
        this.precio_mayor = precio_mayor;
    }

    public String getPrecio_menor() {
        return precio_menor;
    }

    public void setPrecio_menor(String precio_menor) {
        this.precio_menor = precio_menor;
    }

    public String getPrecio_promocion() {
        return precio_promocion;
    }

    public void setPrecio_promocion(String precio_promocion) {
        this.precio_promocion = precio_promocion;
    }
}
