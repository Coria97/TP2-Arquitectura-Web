package Repository;

import entities.Carrera;
import entities.Estudiante;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class EstudianteRepository extends BaseJPARepository<Estudiante> {
    public EstudianteRepository(EntityManagerFactory emf){
        super(emf, Estudiante.class);
    }
}
