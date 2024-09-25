package Repository;

import entities.Carrera;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class CarreraRepository implements GenericRepository<Carrera> {
    private EntityManagerFactory emf;
    public CarreraRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Carrera findById(int id) {
        return emf.createEntityManager().find(Carrera.class, id);
    }

    @Override
    public List<Carrera> findAll() {
        return emf.createEntityManager().createQuery("SELECT c FROM Carrera c").getResultList();
    }

    @Override
    public void create(Carrera carrera) {
        emf.createEntityManager().persist(carrera);
    }

    @Override
    public void delete(Carrera carrera) {
        if (findById(carrera.getId_carrera()) != null) {
            emf.createEntityManager().remove(carrera);
        }
        else {
            throw new RuntimeException("Carrera no encontrada");
        }

    }

    @Override
    public void update(Carrera carrera) {
        if (findById(carrera.getId_carrera()) != null) {
            emf.createEntityManager().merge(carrera);
        }

    }
}
