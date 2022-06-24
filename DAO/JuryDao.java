package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import classes.Jury;
import database.Connexion;
import interfaces.IDao;

/**
 * 
 * @author Logan
 */
public class JuryDao implements IDao<Jury> {

    PreparedStatement statement = null;
    Connection connection = null;
    CategorieJuryDao categorieJuryDao = null;


    public JuryDao() {
        connection = new Connexion().getConnexion();
        categorieJuryDao = new CategorieJuryDao();
    }


    @Override
    public boolean create(Jury t) {
        boolean status = true;
        try{
            String sql = "INSERT INTO jury(nom, prenoms, idCategorieJury) values(?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, t.getNom());
            statement.setString(2, t.getPrenoms());
            statement.setInt(3, t.getCategorieJury().getId());
            statement.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            status = false;
        }

        return status;
    }

    @Override
    public List<Jury> getAll() {
        List<Jury> list = new ArrayList<>();
        try{
            String sql = "SELECT * FROM jury WHERE actif=true";
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                list.add(new Jury(result.getInt(1), result.getString(2), result.getString(3), result.getBoolean(4), categorieJuryDao.getById(result.getInt(5))));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public boolean update(Jury t) {
        boolean status = true;
        try{
            String sql = "UPDATE jury SET nom=?, prenoms=?, actif=?, idCategorieJury=? WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, t.getNom());
            statement.setString(2, t.getPrenoms());
            statement.setBoolean(3, t.isActif());
            statement.setInt(4, t.getCategorieJury().getId());
            statement.setInt(5, t.getId());
            statement.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            status = false;
        }
        return status;
    }

    @Override
    public boolean delete(Jury t) {
        t.setActif(false);
        return update(t);
    }

    @Override
    public Jury getById(Integer id) {
        Jury jury = null;
        try{
            String sql = "SELECT * FROM jury WHERE id=? AND actif=true";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                jury = new Jury(result.getInt(1), result.getString(2), result.getString(3), result.getBoolean(4), categorieJuryDao.getById(result.getInt(5)));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return jury;
    }

    public List<Jury> getByName(String nom){
        List<Jury> list = new ArrayList<>();

        try{
            String sql = "SELECT * FROM jury WHERE actif=true AND nom LIKE %" + nom + "%";
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                list.add(new Jury(result.getInt(1), result.getString(2), result.getString(3), result.getBoolean(4), categorieJuryDao.getById(result.getInt(5))));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return list;
    }
    
}
