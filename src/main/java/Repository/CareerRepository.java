package Repository;

import DTO.CareerWithEnrolledStudentsDTO;
import DTO.ReportDTO;
import entities.Career;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

public class CareerRepository extends BaseJPARepository<Career> {
    public CareerRepository(EntityManagerFactory emf) {
        super(emf, Career.class);
    }

    public Career getCareerByName(String name) {
        return super.getEntityManager().createQuery("SELECT c FROM Career c WHERE c.name = :name", Career.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    public List<CareerWithEnrolledStudentsDTO> getCareerWithEnrolledStudents() {
        return super.getEntityManager().createQuery(
                "SELECT new DTO.CareerWithEnrolledStudentsDTO(c.idCareer, c.name, COUNT(ec)) " +
                        "FROM Career c " +
                        "JOIN StudentCareer ec ON ec.career.id = c.idCareer " +
                        "GROUP BY c.idCareer, c.name " +
                        "HAVING COUNT(ec) > 0 " +
                        "ORDER BY COUNT(ec) DESC",
                CareerWithEnrolledStudentsDTO.class).getResultList();
    }

    public List<ReportDTO> getReports() {
        List<Object[]> queryResults = super.getEntityManager().createNativeQuery(
                        "select c.id_carrera, c.nombre, ec.anio, ec.cant_inscriptos, ec.cant_recibidos " +
                                "from Carrera c " +
                                "left join ( " +
                                "    select ec.id_carrera, " +
                                "           count(ec.id_carrera) as cant_inscriptos, " +
                                "           0 as cant_recibidos, " +
                                "           extract(year from ec.fecha_inscripcion) as anio " +
                                "    from EstudianteCarrera ec " +
                                "    group by ec.id_carrera, extract(year from ec.fecha_inscripcion) " +
                                "    union all " +
                                "    select ec.id_carrera, " +
                                "           0 as cant_inscriptos, " +
                                "           count(ec.id_carrera) as cant_recibidos, " +
                                "           extract(year from ec.fecha_graduacion) as anio " +
                                "    from EstudianteCarrera ec " +
                                "    group by ec.id_carrera, extract(year from ec.fecha_graduacion) " +
                                ") ec on ec.id_carrera = c.id_carrera " +
                                "order by c.nombre, ec.anio").getResultList();

        List<ReportDTO> reports = new ArrayList<>();

        for (Object[] fila : queryResults) {
            Integer idCareer = ((Number) fila[0]).intValue();
            String nameCareer = (String) fila[1];
            int year = fila[2] != null ? ((Number) fila[2]).intValue() : -1;
            int amountInscription = fila[3] != null ? ((Number) fila[3]).intValue() : 0;
            int amountGraduates = fila[4] != null ? ((Number) fila[4]).intValue() : 0;

            reports.add(new ReportDTO(idCareer, nameCareer, year, amountInscription, amountGraduates));
        }

        return reports;
    }


}
