package run;

import com.github.javafaker.Faker;
import dao.AlumnoDao;
import dao.ProyectoDao;
import dao.TutorDao;
import entities.Alumno;
import entities.Proyecto;
import entities.Tutor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Run {
    
    static AlumnoDao aldao;
    static TutorDao tudao;
    static ProyectoDao prdao;
    static Proyecto p;
    static Faker f;
    static EntityManagerFactory emf;
    static EntityManager em;
    static String curso, turno;
    static int n;
    static ArrayList<Alumno> listaAlumnos;
    static ArrayList<Tutor> listaTutores;
    
    public static void main(String[] args) {
        
        // Creamos una nueva conexión a la BD
        // Creamos una nueva BD si no existe ya
        emf = Persistence.createEntityManagerFactory("E:\\Datos\\Estudios\\IES COMERCIO - DUAL_DAM_DAW\\DUAL_DAM_DAW_2\\Acceso_Datos\\objectdb-2.8.8\\db\\institutos.odb");
        em = emf.createEntityManager();
        
        aldao = new AlumnoDao(em);
        tudao= new TutorDao(em);
        prdao= new ProyectoDao(em);
        
        f = new Faker();
        
        listaAlumnos = new ArrayList();
        listaTutores = new ArrayList();
        
        //INSERTAR
            //insertamos 2 alumnos a la BD
            CrearEinsertarAlumnos(2);
            //insertamos 3 tutores a la BD
            CrearEinsertarTutores(3);
            //insertamos 2 proyectos
            CrearEinsertarProyectos(2); 
            
//        //BORRADO
//            //Borrado de un alumno por su ID
//            aldao.borrar(780);
              //Borrado de un tutor por su ID
//              tudao.borrar(973);
              //Borrado de un proyecto por su ID
              //prdao.borrar(468);
//
//        //UPDATE
//            //Update del nombre de un alumno por su ID
//            Alumno nuevo = new Alumno();
//            nuevo.setNombre("NOMBRE MODIFICADO");
//            aldao.modificar(479, nuevo);

            //Update del nombre de un tutor por su ID
//            Tutor nuevo = new Tutor();
//            nuevo.setNombre("TUTOR 208 NOMBRE MODIFICADO");
//            tudao.modificar(208, nuevo);
//            //Update del nombre de un proyecto por su ID
//            Proyecto nuevo2 = new Proyecto();
//            nuevo.setNombre("Prueba 2.0");
//            prdao.modificar(268, nuevo2);
//        //CONSULTA
////          //Consulta de los datos de un alumno por su ID
//            Alumno a = aldao.consultar(479);
//            System.out.println(a.toString());

            //Consulta de los datos de un tutor por su ID
//            Tutor t = tudao.consultar(208);
//            System.out.println(t.toString());
//            //Consulta de los datos de un proyecto por su ID
//            Proyecto p = prdao.consultar(468);
//            System.out.println(t.toString());
//            
//            System.out.println(obtenerIdMasAltoNuevo());
//
    }

    private static void CrearEinsertarAlumnos(int j) {
        for (int i = 0; i < j; i++) {
            ramdomCursoTurno();
            Alumno a = new Alumno(f.random().nextInt(0, 999));
            a.setApellidos(f.name().lastName());
            a.setNombre(f.name().firstName());
            a.setCurso(curso);
            a.setTurno(turno);
            listaAlumnos.add(a);
            //insertamos el alumno a la BD
            aldao.insertar(a);
        }
    }
    
    private static void CrearEinsertarTutores(int j) {
        for (int i = 0; i < j; i++) {
            ramdomCursoTurno();
            Tutor t = new Tutor(f.random().nextInt(0, 999));
            t.setNombre(f.name().firstName());
            t.setTurno(turno);
            t.setCuerpo("cuerpo "+i);
            listaTutores.add(t);
            //insertamos el tutor a la BD
            tudao.insertar(t);
        }
    }
    
    private static void CrearEinsertarProyectos(int j) {
        for (int i = 0; i < j; i++) {
            //si el id del proyecto no esta asignado a ningun proyecto se le asigna, sino salta mensaje de que ese tutor ya esta asignado a un proyecto
            
            Proyecto p = new Proyecto(obtenerIdMasAltoNuevo());
            p.setDescripcion("descripcion "+i);
            p.setHorasEstimadas(f.random().nextInt(0, 500));
            p.setNombre(f.programmingLanguage().name());
            p.setIdAlumno(listaAlumnos.get(f.random().nextInt(0, listaAlumnos.size()-1)));
            p.setIdTutor(listaTutores.get(f.random().nextInt(0, listaTutores.size()-1)));
            //insertamos el proyecto a la BD
            prdao.insertar(p);
        }
    }
    
    /**
     * Metodo que randomizar el valor de las variables curso y turno según un número aleatorio
     */
    private static void ramdomCursoTurno() {
        if(f.random().nextInt(0, 50)>25){
            curso = "DUAL 2";
            turno = "Vespertino";
        } else {
            curso = "DAM2";
            turno = "Diurno";
        }
    }
    
    /**
     * Metodo que devuelve el siguiente valor del id que deberá llevar el siguiente proyecto a insertar en la BD
     * @return id del proyecto con el valor mas alto en la BD + 1
     */
    private static int obtenerIdMasAltoNuevo(){
        int id;
        
        try {
            Query q = em.createQuery("SELECT MAX(f.id) FROM Proyecto f");
            id = ((int)q.getSingleResult());
            System.out.println(id+1);
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
    
//    private static void comprobarIdTutor(Tutor t){
//     
//        try {
//           Query q = em.createQuery("SELECT c FROM Proyecto c WHERE c.idTutor LIKE :idTutor",Proyecto.class);
//            q.setParameter("idTutor", t);
//            List<Proyecto> listaProyectos = q.getResultList();
//            
//        } catch ( NullPointerException e) {
//            //Si no hay ningun proyecto creado, es decir hay 0, la consulta nos devolvera Null, asi que al primer proyecto le asignaremos el valor 1, después ya se autoincrementará
//            System.out.println("El tutor ya esta asignado a otro proyecto");
//        }
//    }
}
