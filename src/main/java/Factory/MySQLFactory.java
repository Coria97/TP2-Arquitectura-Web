package Factory;

import Repository.CarreraRepository;
import Repository.EstudianteCarreraRepository;
import Repository.EstudianteRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MySQLFactory extends FactoryRepository{

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2-integrador");

    public MySQLFactory(){}

    @Override
    public CarreraRepository getCarreraRepositorio() {
        return new CarreraRepository(emf);
    }

    @Override
    public EstudianteRepository getEstudianteRepositorio() {
        return new EstudianteRepository(emf);
    }

    @Override
    public EstudianteCarreraRepository getEstudianteCarreraRepositorio() {
        return new EstudianteCarreraRepository(emf);
    }
}
