package DAO;

import classes.Cours;
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
public class CoursDao implements IDao<Cours> {

  PreparedStatement statement = null;
  Connection connection = null;
  FiliereDao filiereDao = null;
  MatiereDao matiereDao = null;
  CategorieCoursDao categorieCoursDao = null;
  UtilisateurDao utilisateurDao = null;

  public CoursDao() {
    connection = new Connexion().getConnexion();
    filiereDao = new FiliereDao();
    matiereDao = new MatiereDao();
    categorieCoursDao = new CategorieCoursDao();
    utilisateurDao = new UtilisateurDao();
  }

  @Override
  public boolean create(Cours t) {
    boolean status = true;
    try {
      String sql =
        "INSERT INTO cours(titre, description, datePublication, idUtilisateur, idCategorieCours, idFiliere, idMatiere) VALUES(?, ?, ?, ?, ?, ?, ?)";
      statement = connection.prepareStatement(sql);
      statement.setString(1, t.getTitre());
      statement.setString(2, t.getDescription());
      statement.setObject(3, t.getDatePublication());
      statement.setInt(4, t.getUtilisateur().getId());
      statement.setInt(5, t.getCategorieCours().getId());
      statement.setInt(6, t.getFiliere().getId());
      statement.setInt(7, t.getMatiere().getId());
      statement.execute();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      status = false;
    }
    return status;
  }

  @Override
  public List<Cours> getAll() {
    List<Cours> list = new ArrayList<>();
    try {
      String sql = "SELECT * FROM cours WHERE actif=true";
      statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        list.add(
          new Cours(
            result.getInt(1),
            result.getString(2),
            result.getString(3),
            result.getBoolean(4),
            result.getObject(5, LocalDateTime.class),
            utilisateurDao.getById(result.getInt(6)),
            categorieCoursDao.getById(result.getInt(7)),
            filiereDao.getById(result.getInt(8)),
            matiereDao.getById(result.getInt(9))
          )
        );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return list;
  }

  @Override
  public boolean update(Cours t) {
    boolean status = true;
    try {
      String sql =
        "UPDATE cours SET titre=?, description=?, actif=?, datePublication=?, idUtuilisateur=?, idCategorieCours=?, idFiliere=?, idMatiere=? WHERE id=?";
      statement = connection.prepareStatement(sql);
      statement.setString(1, t.getTitre());
      statement.setString(2, t.getDescription());
      statement.setBoolean(3, t.isActif());
      statement.setObject(4, t.getDatePublication());
      statement.setInt(5, t.getUtilisateur().getId());
      statement.setInt(6, t.getCategorieCours().getId());
      statement.setObject(7, t.getFiliere().getId());
      statement.setInt(8, t.getMatiere().getId());
      statement.setInt(9, t.getId());
      statement.execute();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      status = false;
    }
    return status;
  }

  @Override
  public boolean delete(Cours t) {
    t.setActif(false);
    return update(t);
  }

  @Override
  public Cours getById(Integer id) {
    Cours cours = null;
    try {
      String sql = "SELECT * FROM cours WHERE actif=true AND id=?";
      statement = connection.prepareStatement(sql);
      statement.setInt(1, id);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        cours =
          new Cours(
            result.getInt(1),
            result.getString(2),
            result.getString(3),
            result.getBoolean(4),
            result.getObject(5, LocalDateTime.class),
            utilisateurDao.getById(result.getInt(6)),
            categorieCoursDao.getById(result.getInt(7)),
            filiereDao.getById(result.getInt(8)),
            matiereDao.getById(result.getInt(9))
          );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return cours;
  }

  // find courses by title
  public List<Cours> findByTitle(String titre) {
    List<Cours> list = new ArrayList<>();
    try {
      String sql =
        "SELECT * FROM cours WHERE actif=true AND LIKE %" + titre + "%";
      statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        list.add(
          new Cours(
            result.getInt(1),
            result.getString(2),
            result.getString(3),
            result.getBoolean(4),
            result.getObject(5, LocalDateTime.class),
            utilisateurDao.getById(result.getInt(6)),
            categorieCoursDao.getById(result.getInt(7)),
            filiereDao.getById(result.getInt(8)),
            matiereDao.getById(result.getInt(9))
          )
        );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return list;
  }
}
