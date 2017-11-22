package dao;

import java.util.List;

/**
 *
 * @author Martin_Ruediger
 */
public interface IDao<T> {
    
    public T findById(int id);
    public List<T> findAll() ;
    public void update(T object);
    public void create(T object);
    public void delete(T object);
    public void delete(int id);
    
}

