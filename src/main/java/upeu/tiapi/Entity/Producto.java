package upeu.tiapi.Entity;

import jakarta.persistence.*;

import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity

@ToString
@SQLDelete(sql = "UPDATE producto SET estado = 0 WHERE IDProducto = ?")
@Where(clause = "estado = 1")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IDProducto;
    private String nombre;
    private String descripcion;
    private String precio;
    private String stock;
    private Integer estado;

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Integer getIDProducto() {
        return IDProducto;
    }

    public void setIDProducto(Integer IDProducto) {
        this.IDProducto = IDProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
