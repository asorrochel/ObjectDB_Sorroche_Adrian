package dao;

import entities.Alumno;
import javax.persistence.EntityManager;

/**
 * DAO DEL OBJETO ALUMNO
 * @author Adrian
 */
public class AlumnoDao implements IDAO<Alumno>{
    private EntityManager em;
    
    public AlumnoDao(EntityManager em) {
        this.em = em;
    }
    /**
     * Metodo para insertar un alumno en la BD pasandole un Objeto Alumno
     * @param o Alumno
     * @return Boolean
     */
    @Override
    public boolean insertar(Alumno o) {
        if(em.find(Alumno.class, o.getIdAlumno()) == null){
            try {
                em.getTransaction().begin();
                em.persist(o);
                em.getTransaction().commit();
                return true;
            } catch(Exception e){
                e.printStackTrace();
                em.getTransaction().rollback();
                return false;
            }
        } else {
            return false;
        }
    }
    
    /**
     * Metodo para borrar un alumno de la BD pasandole un ID
     * @param id Id del alumno que queremos borrar
     * @return Boolean
     */
    @Override
    public boolean borrar(int id) {
        try{
            em.getTransaction().begin();
            Alumno a = em.find(Alumno.class,id);
            em.remove(a);   
            em.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        }
    }
    
    /**
     * Metodo para actualizar un alumno en la BD
     * @param idAlumno id del alumno que queremos modificar
     * @param nuevo Objeto Alumno para aplicar las actualizaciones 
     * @return Boolean
     */
    @Override
    public boolean modificar(int idAlumno, Alumno nuevo) {
        em.getTransaction().begin();
        Alumno old = em.find(Alumno.class, idAlumno);
        if (old != null) {
            //En caso de que el objeto que le pasamos tenga algun campo vacio, ese campo no se actulizará
            //ya que solo queremos actualizar los campos que sean distintos o que tengan contenido
            if(nuevo.getNombre()!= null) {
                old.setNombre(nuevo.getNombre());
            }
            if (nuevo.getApellidos()!= null) {
                old.setApellidos(nuevo.getApellidos());
            }
            if (nuevo.getCurso()!= null) {
                old.setCurso(nuevo.getCurso());
            }
            if (nuevo.getTurno()!= null) {
                old.setTurno(nuevo.getTurno());
            }
            em.getTransaction().commit();
            return true;
        } else
            em.getTransaction().rollback();
            return false;
    }
    
    /**
     * Metodo para consultar un Alumno de la BD por su id
     * @param id id del alumno que queremos consultar
     * @return Objeto Alumno
     */
    @Override
    public Alumno consultar(int id) {
        return em.find(Alumno.class, id);
    }
}
