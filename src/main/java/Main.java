import DTO.CarreraConInscriptosDTO;
import DTO.ReportDTO;
import Factory.FactoryRepository;
import Factory.MySQLFactory;
import Repository.CarreraRepository;
import Repository.EstudianteCarreraRepository;
import Repository.EstudianteRepository;
import entities.Carrera;
import entities.Estudiante;
import entities.EstudianteCarrera;
import entities.EstudianteCarreraPK;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FactoryRepository dbManager = new MySQLFactory();
        EstudianteRepository estudianteRepository = dbManager.getEstudianteRepository();

        EstudianteCarreraRepository estudianteCarreraRepository = dbManager.getEstudianteCarreraRepository();

        CarreraRepository carreraRepository = dbManager.getCarreraRepository();
        //Carrera carrera = new Carrera("Tudai", "Tecnologia", 2);
        //carreraRepository.create(carrera);

        // 2 - a
        Estudiante estudiante = new Estudiante("Martin", "Palermo", "Tandil", 32, 'X', 123456789, 123456);
        //estudianteRepository.create(estudiante);

        // 2 - b
        // To Do: hacer metodos para buscar por libreta y nombre de carrera
        Carrera carreraFromDB = carreraRepository.findById(1);
        Estudiante estudianteFromDB = estudianteRepository.findById(1);
        EstudianteCarrera estudianteCarrera = new EstudianteCarrera(estudianteFromDB,carreraFromDB);
        //estudianteCarreraRepository.create(estudianteCarrera);

        // 2 - c
        Estudiante estudiante2 = new Estudiante("Jose", "Perez", "Tandil", 50, 'M', 123456789, 123466);
        //estudianteRepository.create(estudiante2);
        Estudiante estudiante3 = new Estudiante("Clemente", "Rodriguez", "Tandil", 43, 'X', 123456789, 123656);
        //estudianteRepository.create(estudiante3);
        System.out.println("-------EJ 2C--------");
        List<Estudiante> estudianteList = estudianteRepository.getAllSortedByParam("edad","desc");
        estudianteList.forEach(System.out::println);

        // 2 - d
        System.out.println("-------EJ 2D--------");
        Estudiante estudianteEJ2D = estudianteRepository.findByLibreta(123456);
        System.out.println(estudianteEJ2D);

        // 2 - e
        System.out.println("-------EJ 2E--------");
        List<Estudiante> estudianteListByGenre = estudianteRepository.getAllEstudiantesByGenre('X');
        estudianteListByGenre.forEach(System.out::println);

        // 2 - f
        System.out.println("-------EJ 2F--------");
        List<CarreraConInscriptosDTO> carrera_inscriptos = carreraRepository.getCarrerasConInscriptos();
        carrera_inscriptos.forEach(System.out::println);

        //2 - g
        System.out.println("-------EJ 2G--------");
        List<Estudiante> estudiantesListByCarrerAndCiudad = estudianteRepository.getEstudiantesByCarreraAndCiudad("TUDAI","Tandil");
        estudiantesListByCarrerAndCiudad.forEach(System.out::println);

        //3
        System.out.println("-------EJ 3---------");
        List<ReportDTO> reporte = carreraRepository.getInforme();
        reporte.forEach(System.out::println);

    }
}
