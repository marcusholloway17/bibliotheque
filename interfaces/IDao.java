package interfaces;

import java.util.List;

/**
 *
 * @author Logan
 * @param <T>
 */

public interface IDao<T> {
  public boolean create(T t);

  public List<T> getAll();

  public boolean update(T t);

  public boolean delete(T t);

  public T getById(Integer id);
}
