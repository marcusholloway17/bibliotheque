package services;

import java.util.List;

import DAO.Memoire_JuryDao;
import classes.Memoire_Jury;

/**
 *
 * @author Logan
 */
public class Memoire_JuryService {

  Memoire_JuryDao memoire_JuryDao = null;

  public Memoire_JuryService() {
    memoire_JuryDao = new Memoire_JuryDao();
  }

  public boolean create(Memoire_Jury memoire_Jury) {
    return memoire_JuryDao.create(memoire_Jury);
  }

  public List<Memoire_Jury> getAll(int memoire_id){
    return memoire_JuryDao.getAll(memoire_id);
  }

  public boolean update(Memoire_Jury memoire_Jury){
    return memoire_JuryDao.update(memoire_Jury);
  }

  public boolean delete(Memoire_Jury memoire_Jury){
    return memoire_JuryDao.delete(memoire_Jury);
  }

  public Memoire_Jury getById(int memoire_id, int jury_id){
    return memoire_JuryDao.getById(memoire_id, jury_id);
  }

}
