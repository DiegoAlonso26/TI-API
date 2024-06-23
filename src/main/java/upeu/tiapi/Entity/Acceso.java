package upeu.tiapi.Entity;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "accesos")
@SQLDelete(sql = "UPDATE accesos SET estado = 0 WHERE id = ?")
@Where(clause = "estado = 1")
public class Acceso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "id_modulo")
    private Modulo modulo;

    @Column(nullable = false)
    private Integer estado = 1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
