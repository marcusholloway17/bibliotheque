package interfaces;

import java.util.List;

/**
 *
 * @author logan
 * @param <T>
 */

// user interface
public interface IUser<T> {
  public boolean create(T t);

  public List<T> findAll();

  public boolean update(T t);

  public boolean delete(T t);

  public T findOne(int id);

  public T login(T t);
}
