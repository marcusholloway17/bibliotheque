package services;

import DAO.EvenementDao;
import classes.Evenement;
import interfaces.IService;
import java.util.List;

/**
 * @author Logan
 */
public class EvenementService implements IService<Evenement> {

  EvenementDao evenementDao = new EvenementDao();

  @Override
  public boolean create(Evenement t) {
    return evenementDao.create(t);
  }

  @Override
  public List<Evenement> findAll() {
    return evenementDao.getAll();
  }

  @Override
  public boolean update(Evenement t) {
    return evenementDao.update(t);
  }

  @Override
  public boolean delete(Evenement t) {
    return evenementDao.delete(t);
  }

  @Override
  public Evenement findOne(int id) {
    return evenementDao.getById(id);
  }

  // Find events with the title passed in parameter
  public List<Evenement> findByName(String titre) {
    return evenementDao.findByTitle(titre);
  }
}
