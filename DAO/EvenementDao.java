package DAO;

import classes.Evenement;
import database.Connexion;
import interfaces.IDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Logan
 */
public class EvenementDao implements IDao<Evenement> {

  PreparedStatement statement = null;
  Connection connection = null;
  UtilisateurDao utilisateurDao = null;

  public EvenementDao() {
    connection = new Connexion().getConnexion();
    utilisateurDao = new UtilisateurDao();
  }

  @Override
  public boolean create(Evenement t) {
    boolean status = true;
    try {
      String sql =
        "INSERT INTO evenement(titre, description, date, idUtilisateur) VALUES(?, ?, ?, ?)";
      statement = connection.prepareStatement(sql);
      statement.setString(1, t.getTitre());
      statement.setString(2, t.getDescription());
      statement.setObject(3, t.getDate());
      statement.setInt(1, t.getUtilisateur().getId());
      statement.execute();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      status = false;
    }
    return status;
  }

  @Override
  public List<Evenement> getAll() {
    List<Evenement> list = new ArrayList<>();
    try {
      String sql = "SELECT * FROM evenement WHERE actif=true";
      statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        list.add(
          new Evenement(
            result.getInt(1),
            result.getString(2),
            result.getString(3),
            result.getObject(4, LocalDateTime.class),
            result.getBoolean(5),
            utilisateurDao.getById(result.getInt(6)),
            result.getObject(7, LocalDateTime.class)
          )
        );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return list;
  }

  @Override
  public boolean update(Evenement t) {
    boolean status = true;
    try {
      String sql =
        "UPDATE evenement SET titre=?, description=?, date=?, actif=?, idUtuilisateur=?, datePublication=? WHERE id=?";
      statement = connection.prepareStatement(sql);
      statement.setString(1, t.getTitre());
      statement.setString(2, t.getDescription());
      statement.setObject(3, t.getDate());
      statement.setBoolean(4, t.isActif());
      statement.setInt(5, t.getUtilisateur().getId());
      statement.setObject(6, t.getDatePublication());
      statement.setInt(7, t.getId());
      statement.execute();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      status = false;
    }
    return status;
  }

  @Override
  public boolean delete(Evenement t) {
    t.setActif(false);
    return update(t);
  }

  @Override
  public Evenement getById(Integer id) {
    Evenement evenement = null;
    try {
      String sql = "SELECT * FROM evenement WHERE actif=true AND id=?";
      statement = connection.prepareStatement(sql);
      statement.setInt(1, id);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        evenement =
          new Evenement(
            result.getInt(1),
            result.getString(2),
            result.getString(3),
            result.getObject(4, LocalDateTime.class),
            result.getBoolean(5),
            utilisateurDao.getById(result.getInt(6)),
            result.getObject(7, LocalDateTime.class)
          );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return evenement;
  }

  // Find all events that have this title
  public List<Evenement> findByTitle(String titre) {
    List<Evenement> list = new ArrayList<>();
    try {
      String sql =
        "SELECT * FROM evenement WHERE actif=true AND titre LIKE %" +
        titre +
        "%";
      statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        list.add(
          new Evenement(
            result.getInt(1),
            result.getString(2),
            result.getString(3),
            result.getObject(4, LocalDateTime.class),
            result.getBoolean(5),
            utilisateurDao.getById(result.getInt(6)),
            result.getObject(7, LocalDateTime.class)
          )
        );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return list;
  }
}
