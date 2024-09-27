import Factory.FactoryRepository;
import Factory.MySQLFactory;
import Repository.CarreraRepository;
import Repository.EstudianteCarreraRepository;
import Repository.EstudianteRepository;
import entities.Carrera;
import entities.Estudiante;
import entities.EstudianteCarrera;
import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        FactoryRepository dbManager = new MySQLFactory();
        EstudianteRepository estudianteRepository = dbManager.getEstudianteRepository();
        CarreraRepository carreraRepository = dbManager.getCarreraRepository();
        EstudianteCarreraRepository estudianteCarreraRepository = dbManager.getEstudianteCarreraRepository();

        // 2 - a
        Estudiante estudiante = new Estudiante("Fabricio", "Trolardium", "Tandil", 32, 'X', 1122334455, 1122334455);
        estudianteRepository.create(estudiante);

        // 2 - b
        Carrera carrera = new Carrera("Tudai", "Tecnologia", 2);
        carreraRepository.create(carrera);

        Estudiante estudiante1 = estudianteRepository.findById(6);
        Carrera carrera1 = carreraRepository.findById(7);
        EstudianteCarrera estudianteCarrera = new EstudianteCarrera(estudiante1, carrera1, new Date(2024,9,27), false);
        estudianteCarreraRepository.create(estudianteCarrera);

    }
}
