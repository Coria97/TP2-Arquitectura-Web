import DTO.CareerWithEnrolledStudentsDTO;
import DTO.ReportDTO;
import Factory.FactoryRepository;
import Factory.MySQLFactory;
import Repository.CareerRepository;
import Repository.StudentCareerRepository;
import Repository.StudentRepository;
import entities.Career;
import entities.Student;
import entities.StudentCareer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FactoryRepository dbManager = new MySQLFactory();

        StudentRepository studentRepository = dbManager.getStudentRepository();
        StudentCareerRepository studentCareerRepository = dbManager.getStudentCareerRepository();
        CareerRepository careerRepository = dbManager.getCareerRepository();

        Career career1 = new Career("Tudai", "Tecnologia", 2);
        Career career2 = new Career("Profesorado", "Matematicas", 4);
        Career career3 = new Career("Sociales", "Humanas", 4);
        careerRepository.create(career1);
        careerRepository.create(career2);
        careerRepository.create(career3);

        Student student1 = new Student("Jose", "Perez", "Tandil", 20, 'M', 40402289, 10001);
        Student student2 = new Student("Clemente", "Rodriguez", "Ayacucho", 23, 'M', 40402278, 10002);
        Student student3 = new Student("Valentina", "Pala", "Balcarce", 21, 'F', 40402288, 10003);
        Student student4 = new Student("Lautaro", "Migueles", "Benito Juarez", 19, 'M', 40402290, 10004);
        studentRepository.create(student1);
        studentRepository.create(student2);
        studentRepository.create(student3);
        studentRepository.create(student4);

        Career careerTudai = careerRepository.getCareerByName("Tudai");
        Career careerProfesorado = careerRepository.getCareerByName("Profesorado");
        Career careerSociales = careerRepository.getCareerByName("Sociales");

        Student student1FromDB = studentRepository.findByStudentNumber(10001);
        Student student2FromDB = studentRepository.findByStudentNumber(10002);
        Student student3FromDB = studentRepository.findByStudentNumber(10003);
        Student student4FromDB = studentRepository.findByStudentNumber(10004);

        StudentCareer studentCareer1 = new StudentCareer(student1FromDB, careerTudai);
        StudentCareer studentCareer2 = new StudentCareer(student1FromDB, careerProfesorado);
        StudentCareer studentCareer3 = new StudentCareer(student2FromDB, careerTudai);
        StudentCareer studentCareer4 = new StudentCareer(student1FromDB, careerSociales);
        StudentCareer studentCareer5 = new StudentCareer(student4FromDB, careerProfesorado);
        StudentCareer studentCareer6 = new StudentCareer(student3FromDB, careerTudai);
        studentCareerRepository.create(studentCareer1);
        studentCareerRepository.create(studentCareer2);
        studentCareerRepository.create(studentCareer3);
        studentCareerRepository.create(studentCareer4);
        studentCareerRepository.create(studentCareer5);
        studentCareerRepository.create(studentCareer6);

        // 2 - a
        System.out.println("-------EJ 2A--------");
        Student student2A = new Student("Agustina", "Schiavi", "Mar Del Plata", 19, 'M', 40402291, 10005);
        studentRepository.create(student2A);

        // 2 - b
        System.out.println("-------EJ 2B--------");
        Career careerFromDB = careerRepository.getCareerByName("Tudai");
        Student studentFromDB = studentRepository.findByStudentNumber(10005);
        StudentCareer studentCareer2B = new StudentCareer(studentFromDB, careerFromDB);
        studentCareerRepository.create(studentCareer2B);

        // 2 - c
        System.out.println("-------EJ 2C--------");
        List<Student> studentListEJ2C = studentRepository.getAllSortedByParam("age","desc");
        studentListEJ2C.forEach(System.out::println);

        // 2 - d
        System.out.println("-------EJ 2D--------");
        Student studentEJ2D = studentRepository.findByStudentNumber(10005);
        System.out.println(studentEJ2D);

        // 2 - e
        System.out.println("-------EJ 2E--------");
        List<Student> studentsListEJ2E = studentRepository.getStudentsByGender('M');
        studentsListEJ2E.forEach(System.out::println);

        // 2 - f
        System.out.println("-------EJ 2F--------");
        List<CareerWithEnrolledStudentsDTO> careerWithEnrolledStudentsDTOListEJ2F = careerRepository.getCareerWithEnrolledStudents();
        careerWithEnrolledStudentsDTOListEJ2F.forEach(System.out::println);

        //2 - g
        System.out.println("-------EJ 2G--------");
        List<Student> studentsListEJ2G = studentRepository.getStudentsByCareerAndCity("TUDAI","Tandil");
        studentsListEJ2G.forEach(System.out::println);

        //3
        System.out.println("-------EJ 3---------");
        List<ReportDTO> reportsEJ3 = careerRepository.getReports();
        reportsEJ3.forEach(System.out::println);

    }
}
