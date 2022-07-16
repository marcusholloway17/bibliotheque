package services;

import DAO.MemoireDao;
import classes.Memoire;
import interfaces.IService;
import java.util.List;

/**
 *
 * @author Logan
 */
public class MemoireService implements IService<Memoire> {

  MemoireDao memoireDao = null;

  public MemoireService() {
    memoireDao = new MemoireDao();
  }

  @Override
  public boolean create(Memoire t) {
    return memoireDao.create(t);
  }

  @Override
  public List<Memoire> findAll() {
    return memoireDao.getAll();
  }

  @Override
  public boolean update(Memoire t) {
    return memoireDao.update(t);
  }

  @Override
  public boolean delete(Memoire t) {
    return memoireDao.delete(t);
  }

  @Override
  public Memoire findOne(int id) {
    return memoireDao.getById(id);
  }

  public List<Memoire> findByTitle(String titre) {
    return memoireDao.findByTitle(titre);
  }
}
