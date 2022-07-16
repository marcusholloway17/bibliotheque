package DAO;

import classes.Sujet;
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
 * 
 * @author Logan
 */
public class SujetDao implements IDao<Sujet> {

  PreparedStatement statement = null;
  Connection connection = null;
  FiliereDao filiereDao = null;
  MatiereDao matiereDao = null;
  CategorieSujetDao categorieSujetDao = null;
  UtilisateurDao utilisateurDao = null;

  public SujetDao() {
    connection = new Connexion().getConnexion();
    filiereDao = new FiliereDao();
    matiereDao = new MatiereDao();
    categorieSujetDao = new CategorieSujetDao();
    utilisateurDao = new UtilisateurDao();
  }

  @Override
  public boolean create(Sujet t) {
    boolean status = true;
    try {
      String sql =
        "INSERT INTO sujet(titre, description, duree, type, idFiliere, idMatiere, idUtilisateur, idCategorieSujet) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
      statement = connection.prepareStatement(sql);
      statement.setString(1, t.getTitre());
      statement.setString(2, t.getDescription());
      statement.setString(3, t.getDuree());
      statement.setString(4, t.getType());
      statement.setInt(5, t.getFiliere().getId());
      statement.setInt(6, t.getMatiere().getId());
      statement.setInt(7, t.getUtilisateur().getId());
      statement.setInt(8, t.getCategoriSujet().getId());
      statement.execute();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      status = false;
    }
    return status;
  }

  @Override
  public List<Sujet> getAll() {
    List<Sujet> list = new ArrayList<Sujet>();
    try {
      String sql = "SELECT * FROM sujet WHERE actif=true";
      statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        list.add(
          new Sujet(
            result.getInt(1),
            result.getString(2),
            result.getString(3),
            result.getString(4),
            result.getString(5),
            result.getBoolean(6),
            result.getObject(7, LocalDateTime.class),
            filiereDao.getById(result.getInt(8)),
            matiereDao.getById(result.getInt(9)),
            utilisateurDao.getById(result.getInt(10)),
            categorieSujetDao.getById(result.getInt(11))
          )
        );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return list;
  }

  @Override
  public boolean update(Sujet t) {
    boolean status = true;
    try {
      String sql =
        "UPDATE sujet SET titre=?, description=?, duree=?, type=?, actif=?, datePublication=?, idFiliere=?, idMatiere=?, idUtuilisateur=?, idCategorieSujet=?, WHERE id=?";
      statement = connection.prepareStatement(sql);
      statement.setString(1, t.getTitre());
      statement.setString(2, t.getDescription());
      statement.setString(3, t.getDuree());
      statement.setString(4, t.getType());
      statement.setBoolean(5, t.isActif());
      statement.setObject(6, t.getDatePublication());
      statement.setInt(7, t.getFiliere().getId());
      statement.setInt(8, t.getMatiere().getId());
      statement.setObject(9, t.getUtilisateur().getId());
      statement.setInt(10, t.getCategoriSujet().getId());
      statement.setInt(11, t.getId());
      statement.execute();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      status = false;
    }
    return status;
  }

  @Override
  public boolean delete(Sujet t) {
    t.setActif(false);
    return update(t);
  }

  @Override
  public Sujet getById(Integer id) {
    Sujet sujet = null;
    try {
      String sql = "SELECT * FROM sujet WHERE actif=true AND id=?";
      statement = connection.prepareStatement(sql);
      statement.setInt(1, id);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        sujet =
          new Sujet(
            result.getInt(1),
            result.getString(2),
            result.getString(3),
            result.getString(4),
            result.getString(5),
            result.getBoolean(6),
            result.getObject(7, LocalDateTime.class),
            filiereDao.getById(result.getInt(8)),
            matiereDao.getById(result.getInt(9)),
            utilisateurDao.getById(result.getInt(10)),
            categorieSujetDao.getById(result.getInt(11))
          );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return sujet;
  }

  // Find subject by title
  public List<Sujet> findByTitle(String titre) {
    List<Sujet> list = new ArrayList<Sujet>();
    try {
      String sql =
        "SELECT * FROM sujet WHERE actif=true AND titre LIKE %" + titre + "%";
      statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        list.add(
          new Sujet(
            result.getInt(1),
            result.getString(2),
            result.getString(3),
            result.getString(4),
            result.getString(5),
            result.getBoolean(6),
            result.getObject(7, LocalDateTime.class),
            filiereDao.getById(result.getInt(8)),
            matiereDao.getById(result.getInt(9)),
            utilisateurDao.getById(result.getInt(10)),
            categorieSujetDao.getById(result.getInt(11))
          )
        );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return list;
  }
}
