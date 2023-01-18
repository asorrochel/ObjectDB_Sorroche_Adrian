package run;

import entities.Alumno;
import entities.Proyecto;
import entities.Tutor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import static run.Run.em;
import static run.Run.emf;

public class Consultas {
    
    static EntityManagerFactory emf;
    static EntityManager em;
        
    public static void main(String[] args) {
        // Creamos una nueva conexión a la BD
        // Creamos una nueva BD si no existe ya
        emf = Persistence.createEntityManagerFactory("E:\\Datos\\Estudios\\IES COMERCIO - DUAL_DAM_DAW\\DUAL_DAM_DAW_2\\Acceso_Datos\\objectdb-2.8.8\\db\\institutos.odb");
        //emf = Persistence.createEntityManagerFactory("C:\\Users\\Vespertino\\Downloads\\objectdb-2.8.8\\db\\institutos.odb");
        em = emf.createEntityManager();
        
        
        //Consulta 1:N proyectos con los alumnos y tutores de cada uno
        //consulta1NProyectos();
        //Consulta 1:1 Todos los tutores y los proyectos de cada uno
        //consulta11Tutores();
        //Consulta where
        //consultaWhereAlumnoTurno("Vespertino");
        //Consulta Between
        //consultaBetwennProyectoHorasEstimadas(250,350);
        //Consulta Where con operadores AND o OR
        //consultaProyectosConTutorYAlumno();
        
        //EJEMPLOS JPQL
        //System.out.println(obtenerIdMasAltoProyecto());
        //System.out.println(comprobarIdTutor(2));
        //consultarAlumno(1);
        //consultarNombresTutores();
        
        //EJEMPLOS CRITERIA
        //consulta1NProyectosCRITERIA();
        //consulta11TutoresCRITERIA();
        //consultaWhereAlumnoTurnoCRITERIA("Vespertino");
        //consultaProyectosConTutorYAlumnoCRITERIA();
        //comprobarIdTutorCRITERIA(3);
        //consultarAlumnoCRITERIA(2);
        //consultarNombresTutoresCRITERIA();
    }

    private static void consulta1NProyectos() {
        Query q = em.createQuery("SELECT c FROM Proyecto c",Proyecto.class);
        
        List<Proyecto> listaProyectos = q.getResultList();
        
        for (Proyecto proyecto : listaProyectos) {
            System.out.println(proyecto.toString());
        }
    }
    private static void consulta11Tutores() {
        Query q = em.createQuery("SELECT c FROM Tutor c",Tutor.class);
        
        List<Tutor> listaTutores = q.getResultList();
        
        for (Tutor tutor : listaTutores) {
            System.out.println(tutor.toString());
        }
    }
    private static void consultaWhereAlumnoTurno(String turno) {
        Query q = em.createQuery("SELECT c FROM Alumno c WHERE c.turno == :turno",Alumno.class);
        q.setParameter("turno", turno);
        List<Alumno> listaALumnos = q.getResultList();
        if(listaALumnos.size() > 0) {
            for (Alumno alumno : listaALumnos) {
            System.out.println(alumno.toString());
            }
        } else {
            System.out.println("No hay alumnos con ese turno");
        }
        
    }
    private static void consultaProyectosConTutorYAlumno() {
        Query q = em.createQuery("SELECT c FROM Proyecto c WHERE c.idAlumno != null AND c.idTutor != null",Proyecto.class);
        List<Proyecto> listaProyectos = q.getResultList();
        if(!listaProyectos.isEmpty()) {
            for (Proyecto proyecto : listaProyectos) {
            System.out.println(proyecto.toString());
            }
        } else {
            System.out.println("No hay proyectos que tengan asignado tanto alumno como tutor");
        }
    }
    
    // EJEMPLOS CONSULTAR DOCUMENTACION
    
    //JPQL
    
    private static int obtenerIdMasAltoProyecto(){
        int id;
        
        try {
            Query q = em.createQuery("SELECT MAX(f.id) FROM Proyecto f");
            id = ((int)q.getSingleResult());
            if(id == 0) {
                return 1;
            } else {
                return id+1;
            }
        } catch ( NullPointerException e) {
            //Si no hay ningun proyecto creado, es decir hay 0, la consulta nos devolvera Null, asi que al primer proyecto le asignaremos el valor 1, después ya se autoincrementará
            return 1;
        }
    }
    private static boolean comprobarIdTutor(int t){
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
    private static void consultarAlumno(int id){
        Query q = em.createQuery("SELECT c FROM Alumno c WHERE c.idAlumno == :id",Alumno.class);
        q.setParameter("id", id);
        List<Alumno> listaAlumnos = q.getResultList();
        
        for (Alumno alumno : listaAlumnos) {
            System.out.println(alumno.toString());
        }
    }
    private static void consultarNombresTutores() {
        Query q = em.createQuery("SELECT c FROM Tutor c",Tutor.class);
        List<Tutor> listaTutor = q.getResultList();
        
        for (Tutor tutor : listaTutor) {
            System.out.println(tutor.getNombre());
        }
    }

    //CRITERIA
    
    private static void consulta1NProyectosCRITERIA() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        
        CriteriaQuery<Proyecto> criteria = builder.createQuery(Proyecto.class);
        Root<Proyecto> root = criteria.from(Proyecto.class);
        criteria.select(root);
        
        //criteria.where(builder.equal(root.get("codCentro"), 15));
        
        List<Proyecto> proyectos = em.createQuery(criteria).getResultList();
         for (Proyecto proyecto : proyectos) {
             System.out.println(proyecto.toString());
        }
    }
    private static void consulta11TutoresCRITERIA() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        
        CriteriaQuery<Tutor> criteria = builder.createQuery(Tutor.class);
        Root<Tutor> root = criteria.from(Tutor.class);
        criteria.select(root);
        
        List<Tutor> tutores = em.createQuery(criteria).getResultList();
         for (Tutor tutor : tutores) {
             System.out.println(tutor.toString());
        }
    }
    private static void consultaWhereAlumnoTurnoCRITERIA(String turno) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        
        CriteriaQuery<Alumno> criteria = builder.createQuery(Alumno.class);
        Root<Alumno> root = criteria.from(Alumno.class);
        criteria.select(root);
        
        criteria.where(builder.equal(root.get("turno"), turno));
        
        List<Alumno> alumnos = em.createQuery(criteria).getResultList();
        
        if(alumnos.size() == 0) {
            System.out.println("No hay alumnos con ese turno");
        } else {
           for (Alumno alumno : alumnos) {
                System.out.println(alumno.toString());
            }  
        } 
    }
    private static void consultaProyectosConTutorYAlumnoCRITERIA() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        
        CriteriaQuery<Proyecto> criteria = builder.createQuery(Proyecto.class);
        Root<Proyecto> root = criteria.from(Proyecto.class);
        criteria.select(root);
        
        Predicate pred1 = builder.isNotNull(root.get("idAlumno"));
        Predicate pred2 = builder.isNotNull(root.get("idTutor"));
        criteria.where(builder.and(pred1,pred2));
        
        List<Proyecto> proyectos = em.createQuery(criteria).getResultList();
        if(!proyectos.isEmpty()) {
            for (Proyecto proyecto : proyectos) {
            System.out.println(proyecto.toString());
            }
        } else {
            System.out.println("No hay proyectos que tengan asignado tanto alumno como tutor");
        }
    }
    private static boolean comprobarIdTutorCRITERIA(int t) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        
        CriteriaQuery<Tutor> criteria = builder.createQuery(Tutor.class);
        Root<Tutor> root = criteria.from(Tutor.class);
        criteria.select(root);
        
        criteria.where(builder.equal(root.get("idTutor"), t));
        
        List<Tutor> tutores = em.createQuery(criteria).getResultList();
        
        Proyecto pa = tutores.get(0).getProyecto();
        if(pa == null) {
            System.out.println("El tutor no tiene proyecto");
            return true;
        } else {
            System.out.println("El tutor tiene proyecto asignado");
            return false;
        }
    }
    private static void consultarAlumnoCRITERIA(int id) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        
        CriteriaQuery<Alumno> criteria = builder.createQuery(Alumno.class);
        Root<Alumno> root = criteria.from(Alumno.class);
        criteria.select(root);
        
        criteria.where(builder.equal(root.get("idAlumno"), id));
        
        List<Alumno> alumnos = em.createQuery(criteria).getResultList();
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.toString());
        }
    }
    private static void consultarNombresTutoresCRITERIA() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        
        CriteriaQuery<Tutor> criteria = builder.createQuery(Tutor.class);
        Root<Tutor> root = criteria.from(Tutor.class);
        criteria.select(root);
        
        List<Tutor> tutores = em.createQuery(criteria).getResultList();
         for (Tutor tutor : tutores) {
             System.out.println(tutor.getNombre());
        }
    }
}
