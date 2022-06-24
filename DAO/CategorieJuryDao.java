package DAO;
import interfaces.IDao;
import database.Connexion;
import classes.CategorieJury;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Logan
 */
public class CategorieJuryDao implements IDao<CategorieJury>{

    PreparedStatement statement = null;
    Connection connection = null;

    public CategorieJuryDao() {
        connection = new Connexion().getConnexion();
    }

    @Override 
    public boolean create(CategorieJury t){
        boolean status = true;

        try{
            String sql = "insert into categoriejury(titre) values(?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, t.getTitre());
            statement.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            status = false;
        }

        return status;
    }

    @Override
    public List<CategorieJury> getAll() {
        List<CategorieJury> list = new ArrayList<>();
        try{
            String sql = "SELECT * FROM categoriejury WHERE actif=true";
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                list.add(new CategorieJury(result.getInt(1),result.getString(2), result.getBoolean(3)));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public boolean update(CategorieJury t) {
        boolean status = true;
        try{
            String sql = "update categoriejury set titre=?, actif=? where id=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, t.getTitre());
            statement.setBoolean(2, t.isActif());
            statement.setInt(3, t.getId());
            statement.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            status = false;
        }
        return status;
    }

    @Override
    public boolean delete(CategorieJury t) {
        t.setActif(false);
        return update(t);
    }

    @Override
    public CategorieJury getById(Integer id) {
        CategorieJury categorieJury = new CategorieJury();
        try{
            String sql = "SELECT * FROM categoriejury where id=? AND actif=true";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                categorieJury = new CategorieJury(result.getInt(1),result.getString(2), result.getBoolean(3));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return categorieJury;
    }
    
    public List<CategorieJury> getByTitre(String titre) {
        List<CategorieJury> list = new ArrayList<>();
        try{
            String sql = "SELECT * FROM categoriesujet where titre LIKE '%"+ titre + "%' AND actif=true";
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                list.add(new CategorieJury(result.getInt(1),result.getString(2), result.getBoolean(3)));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return list;
    }

}