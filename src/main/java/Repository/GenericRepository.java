package Repository;

import java.util.List;
public interface GenericRepository<T> {

    public T findById(int id);
    public List<T> findAll();
    public void create(T t);
    public void delete(T t);
    public void update(T t);


}
