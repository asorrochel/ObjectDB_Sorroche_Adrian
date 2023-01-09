package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "alumno")
public class Alumno implements Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "idAlumno")
    private Integer idAlumno;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "turno")
    private String turno;
    @Column(name = "curso")
    private String curso;
    @OneToMany(mappedBy = "idAlumno")
    private List<Proyecto> listaProyectos;

    public Alumno() {
    }

    public Alumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Alumno(Integer idAlumno, String nombre, String apellidos, String turno, String curso) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.turno = turno;
        this.curso = curso;
    }
    
    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

//    public Collection<Proyecto> getProyectoCollection() {
//        return listaProyectos;
//    }
//
//    public void setProyectoCollection(Collection<Proyecto> listaProyectos) {
//        this.listaProyectos = listaProyectos;
//    }
    
    

    @Override
    public String toString() {
        return "Alumno: " + "\n ID: " + idAlumno + "\n Nombre: " + nombre + "\n Apellidos: " + apellidos + "\n Turno: " + turno + "\n Curso: " + curso;
    }
    
    
}
