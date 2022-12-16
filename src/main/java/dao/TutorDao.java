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
        Tutor old = em.find(Tutor.class, id);
        if (old != null) {
            old.setCuerpo(nuevo.getCuerpo());
            old.setNombre(nuevo.getNombre());
            old.setTurno(nuevo.getTurno());
            return true;
        } else
            return false;
    }

    @Override
    public Tutor consultar(int id) {
        return em.find(Tutor.class, id);
    }
}
