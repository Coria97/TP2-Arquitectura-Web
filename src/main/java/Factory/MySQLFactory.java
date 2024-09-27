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
    public CarreraRepository getCarreraRepository() {
        return new CarreraRepository(emf);
    }

    @Override
    public EstudianteRepository getEstudianteRepository() {
        return new EstudianteRepository(emf);
    }

    @Override
    public EstudianteCarreraRepository getEstudianteCarreraRepository() {
        return new EstudianteCarreraRepository(emf);
    }
}
