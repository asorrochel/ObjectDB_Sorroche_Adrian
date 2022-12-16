package dao;

import entities.Proyecto;
import javax.persistence.EntityManager;

public class ProyectoDao implements IDAO<Proyecto>{
    private EntityManager em;
    
    public ProyectoDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean insertar(Proyecto o) {
        try {
             if(em.find(Proyecto.class, o.getId()) == null){
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
            Proyecto p = em.find(Proyecto.class,id);
            em.remove(p);   
            em.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean modificar(int id, Proyecto nuevo) {
        Proyecto old = em.find(Proyecto.class, id);
        if (old != null) {
            old.setDescripcion(nuevo.getDescripcion());
            old.setNombre(nuevo.getNombre());
            old.setHorasEstimadas(nuevo.getHorasEstimadas());
            old.setIdAlumno(nuevo.getIdAlumno());
            old.setIdTutor(nuevo.getIdTutor());
            return true;
        } else
            return false;
    }

    @Override
    public Proyecto consultar(int id) {
        return em.find(Proyecto.class, id);
    }
}
