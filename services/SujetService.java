package services;

import DAO.SujetDao;
import classes.Sujet;
import interfaces.IService;
import java.util.List;

/**
 *
 * @author Logan
 */
public class SujetService implements IService<Sujet> {

  SujetDao sujetDao = null;

  public SujetService() {
    sujetDao = new SujetDao();
  }

  @Override
  public boolean create(Sujet t) {
    return sujetDao.create(t);
  }

  @Override
  public List<Sujet> findAll() {
    return sujetDao.getAll();
  }

  @Override
  public boolean update(Sujet t) {
    return sujetDao.update(t);
  }

  @Override
  public boolean delete(Sujet t) {
    return sujetDao.delete(t);
  }

  @Override
  public Sujet findOne(int id) {
    return sujetDao.getById(id);
  }

  // find Subject by title
  public List<Sujet> findByTitle(String titre) {
    return sujetDao.findByTitle(titre);
  }
}
