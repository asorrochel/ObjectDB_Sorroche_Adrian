package dao;

import entities.Alumno;
import javax.persistence.EntityManager;

public class AlumnoDao implements IDAO<Alumno>{
    private EntityManager em;
    
    public AlumnoDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean insertar(Alumno o) {
        try {
            if(em.find(Alumno.class, o.getIdAlumno()) == null){
                em.getTransaction().begin();
                em.persist(o);
                em.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return false;
    }

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

    @Override
    public boolean modificar(int idAlumno, Alumno nuevo) {
        em.getTransaction().begin();
        Alumno old = em.find(Alumno.class, idAlumno);
        if (old != null) {
            old.setApellidos(nuevo.getApellidos());
            old.setNombre(nuevo.getNombre());
            old.setCurso(nuevo.getCurso());
            old.setTurno(nuevo.getTurno());
            em.getTransaction().commit();
            return true;
        } else
            em.getTransaction().rollback();
            return false;
    }

    @Override
    public Alumno consultar(int id) {
        return em.find(Alumno.class, id);
    }
}
