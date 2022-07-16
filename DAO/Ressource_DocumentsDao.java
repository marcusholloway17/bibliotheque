package DAO;

import classes.Ressource_documents;
import database.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Ressource_DocumentsDao {

  PreparedStatement statement = null;
  Connection connection = null;
  CoursDao coursDao = null;
  SujetDao sujetDao = null;
  MemoireDao memoireDao = null;

  public Ressource_DocumentsDao() {
    connection = new Connexion().getConnexion();
    coursDao = new CoursDao();
    sujetDao = new SujetDao();
    memoireDao = new MemoireDao();
  }

  public boolean create(Ressource_documents t) {
    boolean status = true;
    try {
      String sql =
        "insert into ressource_documents(titre, description, taille, chemin, idDocument) values(?, ?, ?, ?, ?)";
      statement = connection.prepareStatement(sql);
      statement.setString(1, t.getTitre());
      statement.setString(2, t.getDescription());
      statement.setLong(3, t.getTaille());
      statement.setString(4, t.getChemin());
      statement.setInt(5, t.getDocument().getId());
      statement.execute();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      status = false;
    }

    return status;
  }

  // retrun a list of documents of courses
  public List<Ressource_documents> getAllCourses() {
    List<Ressource_documents> list = new ArrayList<>();
    try {
      String sql = "SELECT * FROM ressource_documents WHERE actif=true";
      statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        list.add(
          new Ressource_documents(
            result.getInt(1),
            result.getString(2),
            result.getString(3),
            result.getLong(4),
            result.getString(5),
            result.getBoolean(6),
            coursDao.getById(result.getInt(7))
          )
        );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return list;
  }

  // retrun a list of documents of Subjects
  public List<Ressource_documents> getAllSubjects() {
    List<Ressource_documents> list = new ArrayList<>();
    try {
      String sql = "SELECT * FROM ressource_documents WHERE actif=true";
      statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        list.add(
          new Ressource_documents(
            result.getInt(1),
            result.getString(2),
            result.getString(3),
            result.getLong(4),
            result.getString(5),
            result.getBoolean(6),
            sujetDao.getById(result.getInt(7))
          )
        );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return list;
  }
  
  // retrun a list of documents of memories
  public List<Ressource_documents> getAllMemories() {
    List<Ressource_documents> list = new ArrayList<>();
    try {
      String sql = "SELECT * FROM ressource_documents WHERE actif=true";
      statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        list.add(
          new Ressource_documents(
            result.getInt(1),
            result.getString(2),
            result.getString(3),
            result.getLong(4),
            result.getString(5),
            result.getBoolean(6),
            memoireDao.getById(result.getInt(7))
          )
        );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return list;
  }


  public boolean update(Ressource_documents t) {
    boolean status = true;
    try {
        String sql =
          "UPDATE ressource_documents SET titre=?, description=?, taille=?, chemin=? ,actif=?, idDocument=? WHERE id=?";
        statement = connection.prepareStatement(sql);
        statement.setString(1, t.getTitre());
        statement.setString(2, t.getDescription());
        statement.setLong(3, t.getTaille());
        statement.setString(4, t.getChemin());
        statement.setBoolean(5, t.isActif());
        statement.setInt(6, t.getDocument().getId());
        statement.setInt(6, t.getId());
        statement.execute();
      } catch (SQLException e) {
        System.out.println(e.getMessage());
        status = false;
      }
    return status;
  }

  public boolean delete(Ressource_documents t) {
    t.setActif(false);
    return update(t);
  }

  // return a null or a doc of courses
  public Ressource_documents getCoursById(Integer id) {
    Ressource_documents ressource_documents = null;
    try {
        String sql = "SELECT * FROM ressource_documents WHERE actif=true AND id=?";
        statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            ressource_documents =
            new Ressource_documents(
            result.getInt(1),
            result.getString(2),
            result.getString(3),
            result.getLong(4),
            result.getString(5),
            result.getBoolean(6),
            coursDao.getById(result.getInt(7))
            );
        }
      } catch (SQLException e) {
        System.out.println(e.getMessage());
      }
      return ressource_documents;
  }

  // return a null or a doc of subject
  public Ressource_documents getSubjectById(Integer id) {
    Ressource_documents ressource_documents = null;
    try {
        String sql = "SELECT * FROM ressource_documents WHERE actif=true AND id=?";
        statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            ressource_documents =
            new Ressource_documents(
            result.getInt(1),
            result.getString(2),
            result.getString(3),
            result.getLong(4),
            result.getString(5),
            result.getBoolean(6),
            sujetDao.getById(result.getInt(7))
            );
        }
      } catch (SQLException e) {
        System.out.println(e.getMessage());
      }
      return ressource_documents;
  }

  // return a null or a doc of memory
  public Ressource_documents getMemoryById(Integer id) {
    Ressource_documents ressource_documents = null;
    try {
        String sql = "SELECT * FROM ressource_documents WHERE actif=true AND id=?";
        statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            ressource_documents =
            new Ressource_documents(
            result.getInt(1),
            result.getString(2),
            result.getString(3),
            result.getLong(4),
            result.getString(5),
            result.getBoolean(6),
            memoireDao.getById(result.getInt(7))
            );
        }
      } catch (SQLException e) {
        System.out.println(e.getMessage());
      }
      return ressource_documents;
  }

}
