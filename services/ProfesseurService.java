package services;
import java.util.List;
import DAO.ProfesseurDao;
import classes.Professeur;
import interfaces.IService;

/**
 * 
 * @author Logan
 */
public class ProfesseurService implements IService<Professeur>{

    ProfesseurDao professeurDao;

    public ProfesseurService(){
        professeurDao = new ProfesseurDao();
    }

    @Override
    public boolean create(Professeur professeur) {
        return professeurDao.create(professeur);
    }

    @Override
    public List<Professeur> findAll() {
        return professeurDao.getAll();
    }

    @Override
    public boolean update(Professeur professeur) {
        return professeurDao.update(professeur);
    }

    @Override
    public boolean delete(Professeur professeur) {
        return professeurDao.delete(professeur);
    }

    @Override
    public Professeur findOne(int id) {
        return professeurDao.getById(id);
    }

    public List<Professeur> findByName(String nom){
        return professeurDao.findByName(nom);
    }
    
}
