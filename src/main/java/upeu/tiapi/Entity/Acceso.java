package upeu.tiapi.Entity;

import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "accesos")
@SQLDelete(sql = "UPDATE accesos SET estado = 0 WHERE id = ?")
@Where(clause = "estado = 1")
@ToString
public class Acceso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String permiso;
    private Integer estado;

    @ManyToOne
    @JoinColumn(name = "idperfil", nullable = false)
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "idmodulo", nullable = false)
    private Modulo modulo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }
}
