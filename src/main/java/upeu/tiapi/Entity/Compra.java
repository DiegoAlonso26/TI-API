package upeu.tiapi.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.Random;

@Entity
@Table(name = "compras")
@SQLDelete(sql = "UPDATE compras SET estado = 0 WHERE id = ?")
@Where(clause = "estado = 1")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "codigo_remision", nullable = false, unique = true)
    private String codigoRemision;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fecha;


    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

    @Column(nullable = false)
    private Integer estado = 1;


    @PrePersist
    protected void onCreate() {
        this.codigoRemision = generarCodigoGuia();
        this.fecha = LocalDateTime.now();
    }

    private String generarCodigoGuia() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(1000000); // Genera un número aleatorio de 6 dígitos
        return String.format("%06d", numeroAleatorio); // Formatea el número a 6 dígitos con ceros a la izquierda
    }

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoRemision() {
        return codigoRemision;
    }

    public void setCodigoRemision(String codigoRemision) {
        this.codigoRemision = codigoRemision;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }



    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
