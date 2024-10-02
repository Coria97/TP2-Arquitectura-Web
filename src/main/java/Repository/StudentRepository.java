package Repository;

import entities.Student;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class StudentRepository extends BaseJPARepository<Student> {
    public StudentRepository(EntityManagerFactory emf){
        super(emf, Student.class);
    }

    public Student findByStudentNumber(Integer stundetNumber) {
        return super.getEntityManager().createQuery("SELECT e FROM Student e WHERE e.studentNumber = :stundetNumber", Student.class)
                .setParameter("stundetNumber", stundetNumber)
                .getSingleResult();
    }

    public List<Student> getStudentsByGender(char gender) {
        return super.getEntityManager().createQuery("SELECT e FROM Student e WHERE e.gender = :gender", Student.class)
                .setParameter("gender", gender)
                .getResultList();
    }

    public List<Student> getStudentsByCareerAndCity(String nameCareer, String city) {
        return super.getEntityManager().createQuery(
                        "SELECT e " +
                                "FROM Student e " +
                                "WHERE e.city = :city " +
                                "AND e.idStudent IN (SELECT ec.student.idStudent " +
                                "             FROM StudentCareer ec " +
                                "             JOIN ec.career c " +
                                "             WHERE c.name = :nameCareer)", Student.class)
                .setParameter("nameCareer", nameCareer)
                .setParameter("city", city)
                .getResultList();
    }

}
