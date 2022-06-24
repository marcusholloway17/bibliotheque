package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.BCrypt;
import classes.Utilisateur;
import database.Connexion;
import interfaces.IDao;

/**
 * 
 * @author Logan
 */
public class UtilisateurDao implements IDao<Utilisateur> {

    PreparedStatement statement = null;
    Connection connection = null;
    RoleDao roleDao = null;

    public UtilisateurDao(){
        connection = new Connexion().getConnexion();
        roleDao = new RoleDao();
    }

    @Override
    public boolean create(Utilisateur t) {
        boolean status = true;

        if(!existingLogin(t.getLogin())){
            try{
                String sql = "INSERT INTO utilisateur(login, password, idRole) values(?, ?, ?)";
                statement = connection.prepareStatement(sql);
                statement.setString(1, t.getLogin());
                statement.setString(2, BCrypt.hashpw(t.getPassword(), BCrypt.gensalt()));
                statement.setInt(3, t.getRole().getId());
                statement.execute();
            }catch(SQLException e){
                System.out.println(e.getMessage());
                status = false;
            }
        }else{
            status = false;
        }

        return status;
    }

    @Override
    public List<Utilisateur> getAll() {
        List<Utilisateur> list = new ArrayList<>();
        try{
            String sql = "SELECT * FROM utilisateur WHERE actif=true";
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                list.add(new Utilisateur(result.getInt(1), result.getString(2), result.getString(3), result.getBoolean(4), roleDao.getById(result.getInt(5))));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public boolean update(Utilisateur t) {
        boolean status = true;
        try{
            String sql = "UPDATE utilisateur SET password=?, actif=?, idRole=? WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, BCrypt.hashpw(t.getPassword(), BCrypt.gensalt()));
            statement.setBoolean(2, t.isActif());
            statement.setInt(3, t.getRole().getId());
            statement.setInt(4, t.getId());
            statement.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            status = false;
        }
        return status;
    }

    @Override
    public boolean delete(Utilisateur t) {
        t.setActif(false);
        return update(t);
    }

    @Override
    public Utilisateur getById(Integer id) {
        Utilisateur utilisateur = null;
        try{
            String sql = "SELECT * FROM utilisateur WHERE id=? AND actif=true";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                utilisateur = new Utilisateur(result.getInt(1), result.getString(2), result.getString(3), result.getBoolean(4), roleDao.getById(result.getInt(5)));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return utilisateur;
    }

    // login 
    public Utilisateur login(Utilisateur t) {
        Utilisateur utilisateur = null;
        try{
            String sql = "SELECT id, login, password, idRole FROM utilisateur WHERE login=? AND actif=true LIMIT 1";
            statement = connection.prepareStatement(sql);
            statement.setString(1, t.getLogin());
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                if (BCrypt.checkpw(t.getPassword(), result.getString(3))){
                    utilisateur = new Utilisateur(result.getInt(1), result.getString(2), roleDao.getById(result.getInt(4)));
                }
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return utilisateur;
    }

    // check if user login already exists
    public boolean existingLogin(String login){
        boolean status = true;

        try{
            String sql = "SELECT login FROM utilisateur WHERE login=? LIMIT 1";
            statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            ResultSet result = statement.executeQuery();

            if(result.next()){
                status = true;
            }else{
                status = false;
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
            status = false;
        }

        return status;
    }
    
}
