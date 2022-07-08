package services;

import DAO.FiliereDao;
import classes.Filiere;
import interfaces.IService;
import java.util.List;

/**
 *
 * @author Logan
 */
public class FiliereService implements IService<Filiere> {

  FiliereDao filiereDao;

  public FiliereService() {
    filiereDao = new FiliereDao();
  }

  @Override
  public boolean create(Filiere filiere) {
    return filiereDao.create(filiere);
  }

  @Override
  public List<Filiere> findAll() {
    return filiereDao.getAll();
  }

  @Override
  public boolean update(Filiere filiere) {
    return filiereDao.update(filiere);
  }

  @Override
  public boolean delete(Filiere filiere) {
    return filiereDao.delete(filiere);
  }

  @Override
  public Filiere findOne(int id) {
    return filiereDao.getById(id);
  }

  public List<Filiere> findByTitle(String titre) {
    return filiereDao.getByTitre(titre);
  }
}
