package Repository;

import entities.EstudianteCarrera;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class EstudianteCarreraRepository implements GenericRepository<EstudianteCarrera>{
    private EntityManagerFactory emf;
    public EstudianteCarreraRepository(EntityManagerFactory emf){
        this.emf = emf;
    }

    @Override
    public EstudianteCarrera findById(int id) {
        return emf.createEntityManager().find(EstudianteCarrera.class, id);
    }

    @Override
    public List<EstudianteCarrera> findAll() {
        return emf.createEntityManager().createQuery("SELECT e FROM EstudianteCarrera e").getResultList();
    }

    @Override
    public void create(EstudianteCarrera estudianteCarrera) {
        emf.createEntityManager().persist(estudianteCarrera);
    }

    @Override
    public void delete(EstudianteCarrera estudianteCarrera) {
        if (findById(estudianteCarrera.getId_estudiante_carrera()) != null) {
            emf.createEntityManager().remove(estudianteCarrera);
        }
        else {
            throw new RuntimeException("EstudianteCarrera no encontrado");
        }

    }

    @Override
    public void update(EstudianteCarrera estudianteCarrera) {
        if (findById(estudianteCarrera.getId_estudiante_carrera()) != null) {
            emf.createEntityManager().merge(estudianteCarrera);
        }

    }
}
