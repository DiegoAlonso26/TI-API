package upeu.tiapi.Entity;


import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "lugar")
@SQLDelete(sql = "UPDATE lugar SET estado = 0 WHERE id = ?")
@Where(clause = "estado = 1")
public class Lugar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String tipo;
    private String LugarSuperior;
    @Column(nullable = false)
    private Integer estado = 1;

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

    public String getLugarSuperior() {
        return LugarSuperior;
    }

    public void setLugarSuperior(String lugarSuperior) {
        LugarSuperior = lugarSuperior;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
