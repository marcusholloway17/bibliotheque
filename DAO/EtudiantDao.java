package DAO;

import classes.Etudiant;
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
public class EtudiantDao implements IDao<Etudiant> {

  PreparedStatement statement = null;
  Connection connection = null;
  FiliereDao filiereDao = null;

  public EtudiantDao() {
    connection = new Connexion().getConnexion();
    filiereDao = new FiliereDao();
  }

  @Override
  public boolean create(Etudiant t) {
    boolean status = true;
    try {
      String sql =
        "INSERT INTO etudiant(nom, prenoms, idFiliere) values(?, ?, ?)";
      statement = connection.prepareStatement(sql);
      statement.setString(1, t.getNom());
      statement.setString(2, t.getPrenoms());
      statement.setInt(3, t.getFiliere().getId());
      statement.execute();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      status = false;
    }
    return status;
  }

  @Override
  public List<Etudiant> getAll() {
    List<Etudiant> list = new ArrayList<>();
    try {
      String sql = "SELECT * FROM etudiant WHERE actif=true";
      statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();

      while (result.next()) {
        list.add(
          new Etudiant(
            result.getInt(1),
            result.getString(2),
            result.getString(3),
            result.getBoolean(4),
            filiereDao.getById(result.getInt(5))
          )
        );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return list;
  }

  @Override
  public boolean update(Etudiant t) {
    boolean status = true;
    try {
      String sql =
        "UPDATE etudiant SET nom=?, prenoms=?, actif=?, idFiliere=? WHERE id=?";
      statement = connection.prepareStatement(sql);
      statement.setString(1, t.getNom());
      statement.setString(2, t.getPrenoms());
      statement.setBoolean(3, t.isActif());
      statement.setInt(4, t.getFiliere().getId());
      statement.setInt(5, t.getId());
      statement.execute();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      status = false;
    }
    return status;
  }

  @Override
  public boolean delete(Etudiant t) {
    t.setActif(false);
    return update(t);
  }

  @Override
  public Etudiant getById(Integer id) {
    Etudiant etudiant = null;
    try {
      String sql = "SELECT * FROM etudiant WHERE id=? AND actif=true";
      statement = connection.prepareStatement(sql);
      statement.setInt(1, id);
      ResultSet result = statement.executeQuery();

      while (result.next()) {
        etudiant =
          new Etudiant(
            result.getInt(1),
            result.getString(2),
            result.getString(3),
            result.getBoolean(4),
            filiereDao.getById(result.getInt(5))
          );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return etudiant;
  }

  // Search by name
  public List<Etudiant> findAll(String nom) {
    List<Etudiant> list = new ArrayList<>();
    try {
      String sql =
        "SELECT * FROM etudiant WHERE actif=true AND nom LIKE %" + nom + "%";
      statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();

      while (result.next()) {
        list.add(
          new Etudiant(
            result.getInt(1),
            result.getString(2),
            result.getString(3),
            result.getBoolean(4),
            filiereDao.getById(result.getInt(5))
          )
        );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return list;
  }
}
