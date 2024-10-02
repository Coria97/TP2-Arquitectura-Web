package Factory;

import Repository.CareerRepository;
import Repository.StudentCareerRepository;
import Repository.StudentRepository;

public abstract class FactoryRepository {
    public static final int MYSQL = 1;

    public abstract CareerRepository getCareerRepository();

    public abstract StudentRepository getStudentRepository();

    public abstract StudentCareerRepository getStudentCareerRepository();

    public static FactoryRepository getFactory(int whichFactory) {
        switch (whichFactory) {
            case MYSQL:
                return MySQLFactory.getInstance();
            default:
                return null;
        }
    }
}
