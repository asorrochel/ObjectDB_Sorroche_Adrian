package dao;

import entities.Proyecto;
import entities.Tutor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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
                if(comprobarIdTutor(o.getIdTutor().getIdTutor()) == true) {
                    em.persist(o);
                    em.getTransaction().commit();
                    return true;
                } else {
                System.out.println("No se puede insertar el proyecto ya que el tutor ya tiene un proyecto asignado");
                }
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
        em.getTransaction().begin();
        Proyecto old = em.find(Proyecto.class, id);
        if (old != null) {
            if(nuevo.getDescripcion()!= null) {
                old.setDescripcion(nuevo.getDescripcion());
            }
            if (nuevo.getNombre() != null) {
                old.setNombre(nuevo.getNombre());
            }
            if (nuevo.getHorasEstimadas()!= null) {
                old.setHorasEstimadas(nuevo.getHorasEstimadas());
            }
            if (nuevo.getIdAlumno()!= null) {
                old.setIdAlumno(nuevo.getIdAlumno());
            }
            if (nuevo.getIdTutor()!= null) {
                old.setIdTutor(nuevo.getIdTutor());
            }
            em.getTransaction().commit();
            return true;
        } else
            em.getTransaction().rollback();
            return false;
    }

    @Override
    public Proyecto consultar(int id) {
        return em.find(Proyecto.class, id);
    }
    
    /**
     * Metodo que comprueba si un Tutor tiene asignado un proyecto o no
     * @param t
     * @return 
     */
    private boolean comprobarIdTutor(int t){
        Query q = em.createQuery("SELECT c FROM Tutor c WHERE c.idTutor = :idTutor",Tutor.class);
        q.setParameter("idTutor", t);
        List<Tutor> listaTutores = q.getResultList();
        
        Proyecto pa = listaTutores.get(0).getProyecto();
        if(pa == null) {
            System.out.println("El tutor no tiene proyecto");
            return true;
        } else {
            System.out.println("El tutor tiene proyecto asignado");
            return false;
        }
    }
}
