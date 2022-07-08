package services;

import DAO.CategorieSujetDao;
import classes.CategorieSujet;
import interfaces.IService;
import java.util.List;

/**
 *
 * @author Logan
 */
public class CategorieSujetService implements IService<CategorieSujet> {

  CategorieSujetDao categorieSujetDao;

  public CategorieSujetService() {
    categorieSujetDao = new CategorieSujetDao();
  }

  @Override
  public boolean create(CategorieSujet categorieSujet) {
    return categorieSujetDao.create(categorieSujet);
  }

  @Override
  public List<CategorieSujet> findAll() {
    return categorieSujetDao.getAll();
  }

  @Override
  public boolean update(CategorieSujet categorieSujet) {
    return categorieSujetDao.update(categorieSujet);
  }

  @Override
  public boolean delete(CategorieSujet categorieSujet) {
    return categorieSujetDao.delete(categorieSujet);
  }

  @Override
  public CategorieSujet findOne(int id) {
    return categorieSujetDao.getById(id);
  }

  public List<CategorieSujet> findAll(String titre) {
    return categorieSujetDao.getByTitre(titre);
  }
}
