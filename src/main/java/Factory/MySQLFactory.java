package Factory;

import Repository.CareerRepository;
import Repository.StudentCareerRepository;
import Repository.StudentRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MySQLFactory extends FactoryRepository{
    private EntityManagerFactory emf;
    private static MySQLFactory instance;

    private MySQLFactory() {
        this.emf = Persistence.createEntityManagerFactory("tp2-integrador");
    }

    @Override
    public CareerRepository getCareerRepository() {
        return CareerRepository.getInstance(emf);
    }

    @Override
    public StudentRepository getStudentRepository() {
        return StudentRepository.getInstance(emf);
    }

    @Override
    public StudentCareerRepository getStudentCareerRepository() {
        return StudentCareerRepository.getInstance(emf);
    }

    public static MySQLFactory getInstance() {
        if (instance == null) {
            instance = new MySQLFactory();
        }
        return instance;
    }
}

