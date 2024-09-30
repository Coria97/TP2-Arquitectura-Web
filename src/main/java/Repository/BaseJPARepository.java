package Repository;

import entities.EstudianteCarrera;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class BaseJPARepository<T> implements GenericRepository<T> {
    private EntityManagerFactory emf;
    private Class<T> entityClass;

    public BaseJPARepository(EntityManagerFactory emf, Class<T> entityClass) {
        this.emf = emf;
        this.entityClass = entityClass;
    }

    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public T findById(Integer id) {
        return getEntityManager().find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        return getEntityManager().createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass)
                .getResultList();
    }

    public List<T> getAllSortedByParam(String param, String order) {
        String queryString = "SELECT e FROM " + entityClass.getSimpleName() + " e ORDER BY e." + param + " " + order;
        return getEntityManager().createQuery(queryString, entityClass)
                .getResultList();
    }

    @Override
    public void create(T entity) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        if (!(entity instanceof EstudianteCarrera)) {
            em.persist(entity);
        } else {
            em.merge(entity);
        }
        em.getTransaction().commit();
    }

    @Override
    public void delete(T entity) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    @Override
    public void update(T entity) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }
}