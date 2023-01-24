package dao;

import entities.Tutor;
import javax.persistence.EntityManager;

/**
 * DAO DEL OBJETO Tutor
 * @author Adrian
 */

public class TutorDao implements IDAO<Tutor>{
    private EntityManager em;
    
    public TutorDao(EntityManager em) {
        this.em = em;
    }

    /**
     * Metodo para insertar un Tutor en la BD pasandole un Objeto Tutor
     * @param o Objeto Tutor
     * @return Boolean
     */
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

    /**
     * Metodo para borrar un tutor de la BD pasandole un ID
     * @param id Id del tutor que queremos borrar
     * @return Boolean
     */
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

   /**
     * Metodo para actualizar un tutor en la BD
     * @param id id del tutor que queremos modificar
     * @param nuevo Objeto Tutor para aplicar las actualizaciones 
     * @return Boolean
     */
    @Override
    public boolean modificar(int id, Tutor nuevo) {
        em.getTransaction().begin();
        Tutor old = em.find(Tutor.class, id);
        if (old != null) {
            //En caso de que el objeto que le pasamos tenga algun campo vacio, ese campo no se actulizará
            //ya que solo queremos actualizar los campos que sean distintos o que tengan contenido
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
    
    /**
     * Metodo para consultar un tutor de la BD por su id
     * @param id id del tutor que queremos consultar
     * @return Objeto Tutor
     */
    @Override
    public Tutor consultar(int id) {
        return em.find(Tutor.class, id);
    }
}
