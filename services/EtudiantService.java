package services;
import java.util.List;
import DAO.EtudiantDao;
import classes.Etudiant;
import interfaces.IService;

/**
 * 
 * @author Logan
 */
public class EtudiantService implements IService<Etudiant>{

    EtudiantDao etudiantDao;

    public EtudiantService(){
        etudiantDao = new EtudiantDao();
    }

    @Override
    public boolean create(Etudiant etudiant) {
        return etudiantDao.create(etudiant);
    }

    @Override
    public List<Etudiant> findAll() {
        return etudiantDao.getAll();
    }

    @Override
    public boolean update(Etudiant etudiant) {
        return etudiantDao.update(etudiant);
    }

    @Override
    public boolean delete(Etudiant etudiant) {
        return etudiantDao.delete(etudiant);
    }

    @Override
    public Etudiant findOne(int id) {
        return etudiantDao.getById(id);

    }

    public List<Etudiant> findByName(String nom){
        return etudiantDao.findAll(nom);
    }
    
}
