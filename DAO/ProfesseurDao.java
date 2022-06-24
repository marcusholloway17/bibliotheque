package DAO;
import classes.Professeur;
import interfaces.IDao;
import database.Connexion;
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
public class ProfesseurDao implements IDao<Professeur>{

    PreparedStatement statement = null;
    Connection connection = null;

    public ProfesseurDao(){
        connection = new Connexion().getConnexion();
    }

    @Override
    public boolean create(Professeur t) {
        boolean status = true;
        try{
            String sql = "INSERT INTO professeur(nom, prenoms) values(?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, t.getNom());
            statement.setString(2, t.getPrenoms());
            statement.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            status = false;
        }
        return status;
    }

    @Override
    public List<Professeur> getAll() {
        List<Professeur> list = new ArrayList<>();

        try{
            String sql = "SELECT * FROM professeur WHERE actif=true";
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                list.add(new Professeur(result.getInt(1), result.getString(2), result.getString(3), result.getBoolean(3)));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public boolean update(Professeur t) {
        boolean status = true;

        try{
            String sql = "UPDATE professeur SET nom=?, prenoms=?, actif=? WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, t.getNom());
            statement.setString(2, t.getPrenoms());
            statement.setInt(3, t.getId());
            statement.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            status = false;
        }

        return status;
    }

    @Override
    public boolean delete(Professeur t) {
        t.setActif(false);
        return update(t);
    }

    @Override
    public Professeur getById(Integer id) {
        Professeur professeur = null;

        try{
            String sql = "SELECT * FROM professeur WHERE id=? AND actif=true";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                professeur = new Professeur(result.getInt(1), result.getString(2), result.getString(3), result.getBoolean(4));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return professeur;
    }

    // Search by name
    public List<Professeur> findByName(String nom) {
        List<Professeur> list = new ArrayList<>();
        try{
            String sql = "SELECT * FROM professeur WHERE actif=true AND nom LIKE %" + nom + "%";
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                list.add(new Professeur(result.getInt(1), result.getString(2), result.getString(3), result.getBoolean(4)));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
    }
    

}
