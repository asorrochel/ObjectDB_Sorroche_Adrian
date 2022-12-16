package run;

import com.github.javafaker.Faker;
import dao.AlumnoDao;
import dao.ProyectoDao;
import dao.TutorDao;
import entities.Alumno;
import entities.Proyecto;
import entities.Tutor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Run {
    public static void main(String[] args) {
        String curso, turno;
        int n;
        Faker f = new Faker();
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("C:\\Users\\Vespertino\\Downloads\\objectdb-2.8.8\\db\\instituto.odb");
        EntityManager em = emf.createEntityManager();
        
        AlumnoDao aldao = new AlumnoDao(em);
        TutorDao tudao = new TutorDao(em);
        ProyectoDao prdao = new ProyectoDao(em);
        
        //INSERTAR
        //Creamos 2 alumnos 2 tutores y 2 proyectos y los insertamos
        for (int i = 0; i < 2; i++) {
            if(f.random().nextInt(0, 50)>25){
                curso = "DUAL 2";
                turno = "Vespertino";
            } else {
                curso = "DAM2";
                turno = "Diurno";
            }
            
            Alumno a = new Alumno(f.random().nextInt(0, 999));
            a.setApellidos(f.name().lastName());
            a.setNombre(f.name().firstName());
            a.setCurso(curso);
            a.setTurno(turno);
            //insertamos el alumno
            aldao.insertar(a);
                      
            Tutor t = new Tutor(f.random().nextInt(0, 999));
            t.setNombre(f.name().firstName());
            t.setTurno(turno);
            t.setCuerpo("cuerpo "+i);
            //insertamos el tutor
            tudao.insertar(t);
            
            Proyecto p = new Proyecto(i);
            p.setDescripcion("descripcion "+i);
            p.setHorasEstimadas(f.random().nextInt(0, 500));
            p.setNombre(f.programmingLanguage().name());
            p.setIdAlumno(a);
            p.setIdTutor(t);
            //insertamos el proyecto
            prdao.insertar(p);
        }
        
        //BORRADO
        aldao.borrar(985);

        //MODIFICACION
        Alumno nuevo = new Alumno();
        nuevo.setNombre("Prueba 2.0");
        aldao.modificar(565, nuevo);
        //CONSULTAR
        Alumno a = aldao.consultar(565);
        System.out.println(a.toString());
    }
}
