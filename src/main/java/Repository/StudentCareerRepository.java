package Repository;

import entities.StudentCareer;
import javax.persistence.EntityManagerFactory;

public class StudentCareerRepository extends BaseJPARepository<StudentCareer> {
    public StudentCareerRepository(EntityManagerFactory emf){
        super(emf, StudentCareer.class);
    }
}
