package dao;

import entities.Tutor;
import javax.persistence.EntityManager;

public class TutorDao implements IDAO<Tutor>{
    private EntityManager em;
    
    public TutorDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean insertar(Tutor o) {
        try {
             if(em.find(Tutor.class, o.getIdTutor()) == null){
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
            Tutor t = em.find(Tutor.class,id);
            em.remove(t);   
            em.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean modificar(int id, Tutor nuevo) {
        em.getTransaction().begin();
        Tutor old = em.find(Tutor.class, id);
        if (old != null) {
            if(nuevo.getCuerpo() != null) {
                old.setCuerpo(nuevo.getCuerpo());
            }
            if (nuevo.getNombre() != null) {
                old.setNombre(nuevo.getNombre());
            }
            if (nuevo.getTurno() != null) {
                old.setTurno(nuevo.getTurno());
            }
            if (nuevo.getTurno() != null) {
                old.setTurno(nuevo.getTurno());
            }
            if (nuevo.getProyecto()!= null) {
                old.setProyecto(nuevo.getProyecto());
            }
            em.getTransaction().commit();
            return true;
        } else
            em.getTransaction().rollback();
            return false;
    }

    @Override
    public Tutor consultar(int id) {
        return em.find(Tutor.class, id);
    }
}
