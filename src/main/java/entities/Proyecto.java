package entities;
//s
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "proyecto")
public class Proyecto implements Serializable {
    @Id
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "horas_estimadas")
    private Integer horasEstimadas;
    @JoinColumn(name = "idAlumno", referencedColumnName = "idAlumno")
    @ManyToOne(optional = false)
    private Alumno idAlumno;
    @JoinColumn(name = "idTutor", referencedColumnName = "idtutor")
    @OneToOne(optional = false)
    private Tutor idTutor;

    public Proyecto() {
    }

    public Proyecto(Integer id) {
        this.id = id;
    }

    public Proyecto(Integer id, String nombre, String descripcion, Integer horasEstimadas, Alumno idAlumno, Tutor idTutor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horasEstimadas = horasEstimadas;
        this.idAlumno = idAlumno;
        this.idTutor = idTutor;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getHorasEstimadas() {
        return horasEstimadas;
    }

    public void setHorasEstimadas(Integer horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }

    public Alumno getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Tutor getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(Tutor idTutor) {
        this.idTutor = idTutor;
    }

    @Override
    public String toString() {
        return "Proyecto: " +id + "\n Nombre: " + nombre + "\n Descripcion: " + descripcion + "\n Horas Estimadas: " + horasEstimadas + "\n" + idAlumno +"\n" + idTutor;
    }
    
    
}
