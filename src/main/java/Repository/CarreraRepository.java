package Repository;

import DTO.CarreraConInscriptosDTO;
import DTO.ReportDTO;
import entities.Carrera;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

public class CarreraRepository extends BaseJPARepository<Carrera> {
    private EntityManagerFactory emf;

    public CarreraRepository(EntityManagerFactory emf) {
        super(emf, Carrera.class);
    }


    public List<CarreraConInscriptosDTO> getCarrerasConInscriptos() {
        return super.getEntityManager().createQuery(
                "SELECT new DTO.CarreraConInscriptosDTO(c.id, c.nombre, COUNT(ec)) " +
                        "FROM Carrera c " +
                        "JOIN EstudianteCarrera ec ON ec.carrera.id = c.id " +
                        "GROUP BY c.id, c.nombre " +
                        "HAVING COUNT(ec) > 0 " +
                        "ORDER BY COUNT(ec) DESC",
                CarreraConInscriptosDTO.class).getResultList();
    }

    public List<ReportDTO> getInforme() {

        List<Object[]> resultados = super.getEntityManager().createNativeQuery(
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

        List<ReportDTO> reportes = new ArrayList<>();

        for (Object[] fila : resultados) {
            Integer idCarrera = ((Number) fila[0]).intValue();
            String nombreCarrera = (String) fila[1];
            int anio = fila[2] != null ? ((Number) fila[2]).intValue() : -1;
            int cantInscriptos = fila[3] != null ? ((Number) fila[3]).intValue() : 0;
            int cantRecibidos = fila[4] != null ? ((Number) fila[4]).intValue() : 0;

            reportes.add(new ReportDTO(idCarrera, nombreCarrera, anio, cantInscriptos, cantRecibidos));
        }

        return reportes;
    }


}
