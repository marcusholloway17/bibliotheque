package DAO;

import classes.CategorieCours;
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
public class CategorieCoursDao implements IDao<CategorieCours> {

  PreparedStatement statement = null;
  Connection connection = null;

  public CategorieCoursDao() {
    connection = new Connexion().getConnexion();
  }

  @Override
  public boolean create(CategorieCours t) {
    boolean status = true;
    try {
      String sql = "insert into categoriecours(titre) values(?)";
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
  public List<CategorieCours> getAll() {
    List<CategorieCours> list = new ArrayList<>();
    try {
      String sql = "SELECT * FROM categoriecours WHERE actif=true";
      statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();

      while (result.next()) {
        list.add(
          new CategorieCours(
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
  public boolean update(CategorieCours t) {
    boolean status = true;
    try {
      String sql = "update categoriecours set titre=?, actif=? where id=?";
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
  public boolean delete(CategorieCours t) {
    t.setActif(false);
    return update(t);
  }

  @Override
  public CategorieCours getById(Integer id) {
    CategorieCours categorieCours = new CategorieCours();
    try {
      String sql = "SELECT * FROM categoriecours where id=? AND actif=true";
      statement = connection.prepareStatement(sql);
      statement.setInt(1, id);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        categorieCours =
          new CategorieCours(
            result.getInt(1),
            result.getString(2),
            result.getBoolean(3)
          );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return categorieCours;
  }

  public List<CategorieCours> getByTitre(String titre) {
    List<CategorieCours> list = new ArrayList<>();
    try {
      String sql =
        "SELECT * FROM categoriecours where actif=true AND titre LIKE '%" +
        titre +
        "%' AND actif=true";
      statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        list.add(
          new CategorieCours(
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
