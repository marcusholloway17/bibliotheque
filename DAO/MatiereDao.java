package DAO;

import classes.Matiere;
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
 * @author logan
 */
public class MatiereDao implements IDao<Matiere> {

  PreparedStatement statement = null;
  Connection connection = null;

  public MatiereDao() {
    connection = new Connexion().getConnexion();
  }

  @Override
  public boolean create(Matiere t) {
    boolean status = true;
    try {
      String sql = "insert into matiere(titre) values(?)";
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
  public List<Matiere> getAll() {
    List<Matiere> list = new ArrayList<>();
    try {
      String sql = "SELECT * FROM matiere WHERE actif=true";
      statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();

      while (result.next()) {
        list.add(
          new Matiere(
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
  public boolean update(Matiere t) {
    boolean status = true;
    try {
      String sql = "update matiere set titre=?, actif=? where id=?";
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
  public boolean delete(Matiere t) {
    t.setActif(false);
    return update(t);
  }

  @Override
  public Matiere getById(Integer id) {
    Matiere matiere = new Matiere();
    try {
      String sql = "SELECT * FROM matiere where id=? AND actif=true";
      statement = connection.prepareStatement(sql);
      statement.setInt(1, id);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        matiere =
          new Matiere(
            result.getInt(1),
            result.getString(2),
            result.getBoolean(3)
          );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return matiere;
  }

  public List<Matiere> getByTitre(String titre) {
    List<Matiere> list = new ArrayList<>();
    try {
      String sql =
        "SELECT * FROM matiere where actif=true AND titre LIKE '%" +
        titre +
        "%' AND actif=true";
      statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        list.add(
          new Matiere(
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
