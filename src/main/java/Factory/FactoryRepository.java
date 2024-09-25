package Factory;

import Repository.CarreraRepository;
import Repository.EstudianteCarreraRepository;
import Repository.EstudianteRepository;

public abstract class FactoryRepository {

    public static final int MYSQL = 1;

    public abstract CarreraRepository getCarreraRepositorio();
    public abstract EstudianteRepository getEstudianteRepositorio();
    public abstract EstudianteCarreraRepository getEstudianteCarreraRepositorio();

    public static FactoryRepository getFactory(int whichFactory) {
        switch (whichFactory) {
            case MYSQL : return new MySQLFactory();
            default : return null;
        }
    }
}
