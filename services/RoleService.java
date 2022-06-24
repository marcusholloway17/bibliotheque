package services;
import java.util.List;
import DAO.RoleDao;
import classes.Role;
import interfaces.IService;

/**
 * 
 * @author Logan
 */
public class RoleService implements IService<Role> {

    RoleDao roleDao;

    public RoleService() {
        roleDao = new RoleDao();
    }

    @Override
    public boolean create(Role role) {
        return roleDao.create(role);
    }

    @Override
    public List<Role> findAll() {
        return roleDao.getAll();
    }

    @Override
    public boolean update(Role role) {
        return roleDao.update(role);
    }

    @Override
    public boolean delete(Role role) {
        return roleDao.delete(role);
    }

    @Override
    public Role findOne(int id) {
        return roleDao.getById(id);
    }

    public List<Role> findByTitle(String titre) {
        return roleDao.getByTitre(titre);
    }
    
}
