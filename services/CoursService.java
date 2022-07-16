package services;

import DAO.CoursDao;
import classes.Cours;
import interfaces.IService;
import java.util.List;
/**
 * 
 * @author Logan
 */
public class CoursService implements IService<Cours> {

  CoursDao coursDao;

  public CoursService() {
    coursDao = new CoursDao();
  }

  @Override
  public boolean create(Cours t) {
    return coursDao.create(t);
  }

  @Override
  public List<Cours> findAll() {
    return coursDao.getAll();
  }

  @Override
  public boolean update(Cours t) {
    return coursDao.update(t);
  }

  @Override
  public boolean delete(Cours t) {
    return coursDao.delete(t);
  }

  @Override
  public Cours findOne(int id) {
    return coursDao.getById(id);
  }
}
