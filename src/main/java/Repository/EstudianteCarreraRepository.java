package Repository;

import entities.EstudianteCarrera;
import javax.persistence.EntityManagerFactory;

public class EstudianteCarreraRepository extends BaseJPARepository<EstudianteCarrera> {
    public EstudianteCarreraRepository(EntityManagerFactory emf){
        super(emf, EstudianteCarrera.class);
    }
}
