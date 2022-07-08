package DAO;

import classes.Filiere;
import database.Connexion;
import interfaces.IDao;
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
public class FiliereDao implements IDao<Filiere> {

  PreparedStatement statement = null;
  Connection connection = null;

  public FiliereDao() {
    connection = new Connexion().getConnexion();
  }

  @Override
  public boolean create(Filiere t) {
    boolean status = true;

    try {
      String sql = "insert into filiere(titre) values(?)";
      statement = connection.prepareStatement(sql);
      statement.setString(1, t.getTitre());
      statement.execute();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      status = false;
    }

    return status;
  }

  @Override
  public List<Filiere> getAll() {
    List<Filiere> list = new ArrayList<>();

    try {
      String sql = "SELECT * FROM filiere WHERE actif=true";
      statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();

      while (result.next()) {
        list.add(
          new Filiere(
            result.getInt(1),
            result.getString(2),
            result.getBoolean(3)
          )
        );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return list;
  }

  @Override
  public boolean update(Filiere t) {
    boolean status = true;
    try {
      String sql = "update filiere set titre=?, actif=? where id=?";
      statement = connection.prepareStatement(sql);
      statement.setString(1, t.getTitre());
      statement.setBoolean(2, t.isActif());
      statement.setInt(3, t.getId());
      statement.execute();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      status = false;
    }
    return status;
  }

  @Override
  public boolean delete(Filiere t) {
    t.setActif(false);
    return update(t);
  }

  @Override
  public Filiere getById(Integer id) {
    Filiere filiere = new Filiere();
    try {
      String sql = "SELECT * FROM filiere where id=? AND actif=true";
      statement = connection.prepareStatement(sql);
      statement.setInt(1, id);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        filiere =
          new Filiere(
            result.getInt(1),
            result.getString(2),
            result.getBoolean(3)
          );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return filiere;
  }

  public List<Filiere> getByTitre(String titre) {
    List<Filiere> list = new ArrayList<>();
    try {
      String sql =
        "SELECT * FROM filiere where titre LIKE '%" +
        titre +
        "%' AND actif=true";
      statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        list.add(
          new Filiere(
            result.getInt(1),
            result.getString(2),
            result.getBoolean(3)
          )
        );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return list;
  }
}
