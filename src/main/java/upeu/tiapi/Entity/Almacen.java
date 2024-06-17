package upeu.tiapi.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "almacenes")
@SQLDelete(sql = "UPDATE almacenes SET estado = 0 WHERE id = ?")
@Where(clause = "estado = 1")
public class Almacen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descripcion;
    private String supervisor;
    private String telefonoSupervisor;
    @Column(nullable = false)
    private Integer estado = 1;
    @ManyToOne
    @JoinColumn(name = "id_lugar")
    private Lugar lugar;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getTelefonoSupervisor() {
        return telefonoSupervisor;
    }

    public void setTelefonoSupervisor(String telefonoSupervisor) {
        this.telefonoSupervisor = telefonoSupervisor;
    }
}
