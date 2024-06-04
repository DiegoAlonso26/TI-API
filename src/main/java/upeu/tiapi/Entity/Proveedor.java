package upeu.tiapi.Entity;
import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@SQLDelete(sql = "UPDATE proveedor SET estado = 0 WHERE IDProveedor = ?")
@Where(clause = "estado = 1")
@ToString
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer IDProveedor;
    private String nombre;
    private String direccion;
    private String telefono;
    private Integer estado;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getIDProveedor() {
        return IDProveedor;
    }

    public void setIDProveedor(Integer IDProveedor) {
        this.IDProveedor = IDProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
