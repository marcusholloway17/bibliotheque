package services;

import DAO.UtilisateurDao;
import classes.Utilisateur;
import interfaces.IUser;
import java.util.List;

/**
 *
 * @author Logan
 */
public class utilisateurService implements IUser<Utilisateur> {

  UtilisateurDao utilisateurDao;

  public utilisateurService() {
    utilisateurDao = new UtilisateurDao();
  }

  @Override
  public boolean create(Utilisateur t) {
    return utilisateurDao.create(t);
  }

  @Override
  public List<Utilisateur> findAll() {
    return utilisateurDao.getAll();
  }

  @Override
  public boolean update(Utilisateur t) {
    return utilisateurDao.update(t);
  }

  @Override
  public boolean delete(Utilisateur t) {
    return utilisateurDao.delete(t);
  }

  @Override
  public Utilisateur findOne(int id) {
    return utilisateurDao.getById(id);
  }

  @Override
  public Utilisateur login(Utilisateur t) {
    return utilisateurDao.login(t);
  }
}
