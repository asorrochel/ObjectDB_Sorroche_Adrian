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
import javax.persistence.PersistenceException;
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
        //emf = Persistence.createEntityManagerFactory("C:\\Users\\Vespertino\\Downloads\\objectdb-2.8.8\\db\\institutos.odb");
        em = emf.createEntityManager();
        
        aldao = new AlumnoDao(em);
        tudao= new TutorDao(em);
        prdao= new ProyectoDao(em);
        
        f = new Faker();
        
        listaAlumnos = new ArrayList();
        listaTutores = new ArrayList();
        
        //INSERTAR
        
            //insertamos 2 ALUMNOS a la BD
            //CrearEinsertarAlumnos(2);
            //insertamos 3 TUTORES a la BD
            //CrearEinsertarTutores(3);
            //insertamos 2 PROYECTOS
            //CrearEinsertarProyectos(2); 
            
        //BORRADO
        
            //Borrado de un ALUMNO por su ID
//            aldao.borrar(780);
            //Borrado de un TUTOR por su ID
//          tudao.borrar(973);
            //Borrado de un PROYECTO por su ID
            //prdao.borrar(1);

        //UPDATE
        
            //Update del nombre de un ALUMNO por su ID
//            Alumno nuevo = new Alumno();
//            nuevo.setNombre("NOMBRE MODIFICADO");
//            aldao.modificar(1, nuevo);

            //Update del nombre de un TUTOR por su ID
//            Tutor nuevo = new Tutor();
//            nuevo.setNombre("TUTOR 1 NOMBRE MODIFICADO");
//            tudao.modificar(1, nuevo);

            //Update del nombre de un PROYECTO por su ID
//            Proyecto nuevo2 = new Proyecto();
//            nuevo2.setNombre("Proyecto 2 actualizado");
//            prdao.modificar(2, nuevo2);

        //CONSULTA
        
            //Consulta de los datos de un ALUMNO por su ID
//            Alumno a = aldao.consultar(479);
//            System.out.println(a.toString());

            //Consulta de los datos de un TUTOR por su ID
//            Tutor t = tudao.consultar(208);
//            System.out.println(t.toString());

            //Consulta de los datos de un PROYECTO por su ID
//            Proyecto p = prdao.consultar(2);
//            System.out.println(p.toString());


            //INSERTAR UN ALUMNO
//            Alumno aPrueba = new Alumno(obtenerIdMasAltoAlumno());
//            aPrueba.setNombre("Adrian");
//            aPrueba.setApellidos("Sorroche");
//            aPrueba.setCurso("2º MULWEB");
//            aPrueba.setTurno("Vespertino");
//            aldao.insertar(aPrueba);
////            //INSERTAR UN TUTOR
//            Tutor tPrueba = new Tutor(obtenerIdMasAltoTutor());
//            tPrueba.setNombre("Pedro");
//            tPrueba.setTurno("Vespertino");
//            tudao.insertar(tPrueba);
//            //INSERTAR UN PROYECTO
//            Proyecto pPrueba = new Proyecto(obtenerIdMasAltoProyecto());
//            pPrueba.setNombre("Proyecto Prueba");
//            pPrueba.setDescripcion("Proyecto de prueba para probar");
//            pPrueba.setHorasEstimadas(50);
//            pPrueba.setIdAlumno(aPrueba);
//            pPrueba.setIdTutor(tPrueba);
//            prdao.insertar(pPrueba);
    }

    private static void CrearEinsertarAlumnos(int j) {
        for (int i = 0; i < j; i++) {
            ramdomCursoTurno();
            //Alumno a = new Alumno(f.random().nextInt(0, 999));
            Alumno a = new Alumno(obtenerIdMasAltoAlumno());
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
            Tutor t = new Tutor(obtenerIdMasAltoTutor());
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
            Tutor tTemp = listaTutores.get(f.random().nextInt(0, listaTutores.size()-1));
            Alumno tAlum = listaAlumnos.get(f.random().nextInt(0, listaAlumnos.size()-1));
            
            Proyecto p = new Proyecto(obtenerIdMasAltoProyecto());
            p.setDescripcion("descripcion "+i);
            p.setHorasEstimadas(f.random().nextInt(0, 500));
            p.setNombre(f.programmingLanguage().name());
            p.setIdAlumno(tAlum);
            p.setIdTutor(tTemp);
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
    private static int obtenerIdMasAltoAlumno(){
        int id;
        
        try {
            Query q = em.createQuery("SELECT MAX(f.idAlumno) FROM Alumno f");
            id = ((int)q.getSingleResult());
            
            if(id == 0) {
                return 1;
            } else {
                return id+1;
            }
        } catch ( PersistenceException e) {
            //Si no hay ningun proyecto creado, es decir hay 0, la consulta nos devolvera Null, asi que al primer proyecto le asignaremos el valor 1, después ya se autoincrementará
            return 1;
        }
    }
    /**
     * Metodo que devuelve el siguiente valor del id que deberá llevar el siguiente tutor a insertar en la BD
     * @return id del proyecto con el valor mas alto en la BD + 1
     */
    private static int obtenerIdMasAltoTutor(){
        int id;
        
        try {
            Query q = em.createQuery("SELECT MAX(f.idTutor) FROM Tutor f");
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
}
