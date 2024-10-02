package Repository;

import entities.StudentCareer;
import javax.persistence.EntityManagerFactory;

public class StudentCareerRepository extends BaseJPARepository<StudentCareer> {
    private static StudentCareerRepository instance;

    private StudentCareerRepository(EntityManagerFactory emf){
        super(emf, StudentCareer.class);
    }

    public static StudentCareerRepository getInstance(EntityManagerFactory emf){
        if (instance == null){
            instance = new StudentCareerRepository(emf);
        }
        return instance;
    }

}
