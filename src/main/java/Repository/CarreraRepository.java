package Repository;

import entities.Carrera;

import javax.persistence.EntityManagerFactory;

public class CarreraRepository extends BaseJPARepository<Carrera> {
    private EntityManagerFactory emf;

    public CarreraRepository(EntityManagerFactory emf) {
        super(emf, Carrera.class);
    }






}
