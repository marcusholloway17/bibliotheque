package DAO;

import classes.Role;
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
public class RoleDao implements IDao<Role> {

  PreparedStatement statement = null;
  Connection connection = null;

  public RoleDao() {
    connection = new Connexion().getConnexion();
  }

  @Override
  public boolean create(Role t) {
    boolean status = true;
    try {
      String sql = "insert into role(titre) values(?)";
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
  public List<Role> getAll() {
    List<Role> list = new ArrayList<>();
    try {
      String sql = "SELECT * FROM role WHERE actif=true";
      statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        list.add(
          new Role(result.getInt(1), result.getString(2), result.getBoolean(3))
        );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return list;
  }

  @Override
  public boolean update(Role t) {
    boolean status = true;
    try {
      String sql = "update role set titre=?, actif=? where id=?";
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
  public boolean delete(Role t) {
    t.setActif(false);
    return update(t);
  }

  @Override
  public Role getById(Integer id) {
    Role role = new Role();
    try {
      String sql = "SELECT * FROM role where id=? AND actif=true";
      statement = connection.prepareStatement(sql);
      statement.setInt(1, id);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        role =
          new Role(result.getInt(1), result.getString(2), result.getBoolean(3));
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return role;
  }

  // find user rôle by title
  public List<Role> getByTitre(String titre) {
    List<Role> list = new ArrayList<>();
    try {
      String sql =
        "SELECT * FROM role where titre LIKE '%" + titre + "%' AND actif=true";
      statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        list.add(
          new Role(result.getInt(1), result.getString(2), result.getBoolean(3))
        );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return list;
  }
}
