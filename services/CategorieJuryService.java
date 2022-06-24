package services;
import java.util.List;
import DAO.CategorieJuryDao;
import classes.CategorieJury;
import interfaces.IService;

/**
 * 
 * @author Logan
 */
public class CategorieJuryService implements IService<CategorieJury> {

    CategorieJuryDao categorieJuryDao;

    public CategorieJuryService(){
        categorieJuryDao = new CategorieJuryDao();
    } 

    @Override
    public boolean create(CategorieJury categorieJury) {
        return categorieJuryDao.create(categorieJury);
    }

    @Override
    public List<CategorieJury> findAll() {
        return categorieJuryDao.getAll();
    }

    @Override
    public boolean update(CategorieJury categorieJury) {
        return categorieJuryDao.update(categorieJury);
    }

    @Override
    public boolean delete(CategorieJury categorieJury) {
        return categorieJuryDao.delete(categorieJury);
    }

    @Override
    public CategorieJury findOne(int id) {
        return categorieJuryDao.getById(id);
    }
    
    public List<CategorieJury> findAll(String titre){
        return categorieJuryDao.getByTitre(titre);
    }
}
