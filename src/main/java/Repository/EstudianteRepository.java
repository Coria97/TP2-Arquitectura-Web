package Repository;

import entities.Carrera;
import entities.Estudiante;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class EstudianteRepository extends BaseJPARepository<Estudiante> {
    public EstudianteRepository(EntityManagerFactory emf){
        super(emf, Estudiante.class);
    }

    public Estudiante findByLibreta(Integer nroLibreta) {
        return super.getEntityManager().createQuery("SELECT e FROM Estudiante e WHERE nro_libreta_universitaria = :nroLibreta", Estudiante.class)
                .setParameter("nroLibreta", nroLibreta)
                .getSingleResult();
    }

    public List<Estudiante> getAllEstudiantesByGenre(char genero) {
        return super.getEntityManager().createQuery("SELECT e FROM Estudiante e WHERE e.genero = :genero", Estudiante.class)
                .setParameter("genero", genero)
                .getResultList();
    }
}
