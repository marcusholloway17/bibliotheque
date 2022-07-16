package services;

import java.util.List;

import DAO.Ressource_EvenementDao;
import classes.Ressource_Evenements;
import interfaces.IService;

public class Ressource_EvenementService implements IService<Ressource_Evenements>{
    Ressource_EvenementDao ressource_EvenementDao = null;

    public Ressource_EvenementService(){
        ressource_EvenementDao = new Ressource_EvenementDao();
    }
    @Override
    public boolean create(Ressource_Evenements t) {
        return ressource_EvenementDao.create(t);
    }

    @Override
    public List<Ressource_Evenements> findAll() {
        return ressource_EvenementDao.getAll();
    }

    @Override
    public boolean update(Ressource_Evenements t) {
        return ressource_EvenementDao.update(t);
    }

    @Override
    public boolean delete(Ressource_Evenements t) {
        return ressource_EvenementDao.delete(t);
    }

    @Override
    public Ressource_Evenements findOne(int id) {
        return ressource_EvenementDao.getById(id);
    }
    
}
