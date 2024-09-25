package Repository;

import entities.Estudiante;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class EstudianteRepository implements GenericRepository<Estudiante> {
    private EntityManagerFactory emf;


    public EstudianteRepository(EntityManagerFactory emf){
        this.emf = emf;
    }

    @Override
    public Estudiante findById(int id) {
        return emf.createEntityManager().find(Estudiante.class, id);
    }

    @Override
    public List<Estudiante> findAll() {
        return emf.createEntityManager().createQuery("SELECT e FROM Estudiante e").getResultList();
    }

    @Override
    public void create(Estudiante estudiante) {
        emf.createEntityManager().persist(estudiante);
    }

    @Override
    public void delete(Estudiante estudiante) {
        if (findById(estudiante.getId_estudiante()) != null) {
            emf.createEntityManager().remove(estudiante);
        }else {
            throw new RuntimeException("Estudiante no encontrado");
        }
    }

    @Override
    public void update(Estudiante estudiante) {
        if (findById(estudiante.getId_estudiante())!=null){
            emf.createEntityManager().merge(estudiante);
        }
        else{
            create(estudiante);
        }

    }
}
