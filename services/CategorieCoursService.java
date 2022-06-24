package services;
import java.util.List;
import DAO.CategorieCoursDao;
import classes.CategorieCours;
import interfaces.IService;

/**
 * 
 * @author Logan
 */
public class CategorieCoursService implements IService<CategorieCours> {

    CategorieCoursDao categorieCoursDao;

    public CategorieCoursService(){
        categorieCoursDao = new CategorieCoursDao();
    } 

    @Override
    public boolean create(CategorieCours categorieCours) {
        return categorieCoursDao.create(categorieCours);
    }

    @Override
    public List<CategorieCours> findAll() {
        return categorieCoursDao.getAll();
    }

    @Override
    public boolean update(CategorieCours categorieCours) {
        return categorieCoursDao.update(categorieCours);
    }

    @Override
    public boolean delete(CategorieCours categorieCours) {
        return categorieCoursDao.delete(categorieCours);
    }

    @Override
    public CategorieCours findOne(int id) {
        return categorieCoursDao.getById(id);
    }
    
    public List<CategorieCours> findAll(String titre){
        return categorieCoursDao.getByTitre(titre);
    }
}
