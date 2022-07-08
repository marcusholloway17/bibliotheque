package services;

import DAO.MatiereDao;
import classes.Matiere;
import interfaces.IService;
import java.util.List;

/**
 *
 * @author Logan
 */
public class MatiereService implements IService<Matiere> {

  MatiereDao matiereDao;

  public MatiereService() {
    matiereDao = new MatiereDao();
  }

  @Override
  public boolean create(Matiere matiere) {
    return matiereDao.create(matiere);
  }

  @Override
  public List<Matiere> findAll() {
    return matiereDao.getAll();
  }

  @Override
  public boolean update(Matiere matiere) {
    return matiereDao.update(matiere);
  }

  @Override
  public boolean delete(Matiere matiere) {
    return matiereDao.delete(matiere);
  }

  @Override
  public Matiere findOne(int id) {
    return matiereDao.getById(id);
  }

  public List<Matiere> findByTitle(String titre) {
    return matiereDao.getByTitre(titre);
  }
}
