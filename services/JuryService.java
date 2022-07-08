package services;

import DAO.JuryDao;
import classes.Jury;
import interfaces.IService;
import java.util.List;

/**
 *
 * @author Logan
 */
public class JuryService implements IService<Jury> {

  JuryDao juryDao;

  public JuryService() {
    juryDao = new JuryDao();
  }

  @Override
  public boolean create(Jury t) {
    return juryDao.create(t);
  }

  @Override
  public List<Jury> findAll() {
    return juryDao.getAll();
  }

  @Override
  public boolean update(Jury t) {
    return juryDao.update(t);
  }

  @Override
  public boolean delete(Jury t) {
    return juryDao.delete(t);
  }

  @Override
  public Jury findOne(int id) {
    return juryDao.getById(id);
  }

  public List<Jury> findByName(String nom) {
    return juryDao.getByName(nom);
  }
}
