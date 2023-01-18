package entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tutor")
public class Tutor implements Serializable{
    @Id
    @Basic(optional = false)
    @Column(name = "idtutor")
    private Integer idTutor;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "cuerpo")
    private String cuerpo;
    @Column(name = "turno")
    private String turno;
    @OneToOne(mappedBy = "idTutor")
    private Proyecto proyecto;
    
    public Tutor() {
    }

    public Tutor(Integer idTutor) {
        this.idTutor = idTutor;
    }

    public Tutor(Integer idTutor, String nombre, String cuerpo, String turno) {
        this.idTutor = idTutor;
        this.nombre = nombre;
        this.cuerpo = cuerpo;
        this.turno = turno;
    }

    public Integer getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(Integer idTutor) {
        this.idTutor = idTutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    
    

    @Override
    public String toString() {
        if(proyecto != null) {
            return "Tutor: " + "\n Id: " + idTutor + "\n Nombre:" + nombre + "\n Cuerpo: " + cuerpo + "\n Turno: " + turno + "\n Proyecto: " + proyecto.getId();
        } else {
            return "Tutor: " + "\n Id: " + idTutor + "\n Nombre:" + nombre + "\n Cuerpo: " + cuerpo + "\n Turno: " + turno + "\n Proyecto: " + "Sin Proyecto asignado";
        }
    }
}
