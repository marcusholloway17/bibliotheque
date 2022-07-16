package DAO;

import classes.CategorieSujet;
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
public class CategorieSujetDao implements IDao<CategorieSujet> {

  PreparedStatement statement = null;
  Connection connection = null;

  public CategorieSujetDao() {
    connection = new Connexion().getConnexion();
  }

  @Override
  public boolean create(CategorieSujet t) {
    boolean status = true;
    try {
      String sql = "insert into categoriesujet(titre) values(?)";
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
  public List<CategorieSujet> getAll() {
    List<CategorieSujet> list = new ArrayList<>();
    try {
      String sql = "SELECT * FROM categoriesujet WHERE actif=true";
      statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();

      while (result.next()) {
        list.add(
          new CategorieSujet(
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
  public boolean update(CategorieSujet t) {
    boolean status = true;
    try {
      String sql = "update categoriesujet set titre=?, actif=? where id=?";
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
  public boolean delete(CategorieSujet t) {
    t.setActif(false);
    return update(t);
  }

  @Override
  public CategorieSujet getById(Integer id) {
    CategorieSujet categoriesujet = new CategorieSujet();
    try {
      String sql = "SELECT * FROM categoriesujet where id=? AND actif=true";
      statement = connection.prepareStatement(sql);
      statement.setInt(1, id);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        categoriesujet =
          new CategorieSujet(
            result.getInt(1),
            result.getString(2),
            result.getBoolean(3)
          );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return categoriesujet;
  }

  public List<CategorieSujet> getByTitre(String titre) {
    List<CategorieSujet> list = new ArrayList<>();
    try {
      String sql =
        "SELECT * FROM categoriesujet where actif=true AND titre LIKE '%" +
        titre +
        "%' AND actif=true";
      statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        list.add(
          new CategorieSujet(
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
