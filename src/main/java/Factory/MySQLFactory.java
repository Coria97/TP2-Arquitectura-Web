package Factory;

import Repository.CareerRepository;
import Repository.StudentCareerRepository;
import Repository.StudentRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MySQLFactory extends FactoryRepository{

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2-integrador");

    public MySQLFactory(){}

    @Override
    public CareerRepository getCareerRepository() {
        return new CareerRepository(emf);
    }

    @Override
    public StudentRepository getStudentRepository() {
        return new StudentRepository(emf);
    }

    @Override
    public StudentCareerRepository getStudentCareerRepository() {
        return new StudentCareerRepository(emf);
    }
}
