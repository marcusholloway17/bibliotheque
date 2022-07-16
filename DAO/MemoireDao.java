package DAO;

import classes.Memoire;
import database.Connexion;
import interfaces.IDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @param Memoire
 * @author Logan
 * @
 */
public class MemoireDao implements IDao<Memoire> {

  PreparedStatement statement = null;
  Connection connection = null;
  FiliereDao filiereDao = null;
  ProfesseurDao professeurDao = null;
  EtudiantDao etudiantDao = null;
  UtilisateurDao utilisateurDao = null;

  public MemoireDao() {
    connection = new Connexion().getConnexion();
    filiereDao = new FiliereDao();
    professeurDao = new ProfesseurDao();
    etudiantDao = new EtudiantDao();
    utilisateurDao = new UtilisateurDao();
  }

  @Override
  public boolean create(Memoire t) {
    boolean status = true;
    try {
      String sql =
        "INSERT INTO memoire(theme, description, dateSoutenance, entreprise, anneeAcademique, idEtudiant, idFiliere, idUtilisateur, idProfesseur) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
      statement = connection.prepareStatement(sql);
      statement.setString(1, t.getTitre());
      statement.setString(2, t.getDescription());
      statement.setObject(3, t.getDateSoutenance());
      statement.setString(4, t.getEntreprise());
      statement.setObject(5, t.getAnneeAcademique());
      statement.setInt(6, t.getEtudiant().getId());
      statement.setInt(7, t.getFiliere().getId());
      statement.setInt(8, t.getUtilisateur().getId());
      statement.setInt(9, t.getProfesseur().getId());
      statement.execute();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      status = false;
    }
    return status;
  }

  @Override
  public List<Memoire> getAll() {
    List<Memoire> list = new ArrayList<Memoire>();
    try {
      String sql = "SELECT * FROM memoire WHERE actif=true";
      statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        list.add(
          new Memoire(
            result.getInt(1),
            result.getString(2),
            result.getString(3),
            result.getObject(4, LocalDateTime.class),
            result.getString(5),
            result.getObject(6, Year.class),
            result.getBoolean(7),
            result.getObject(8, LocalDateTime.class),
            etudiantDao.getById(result.getInt(9)),
            filiereDao.getById(result.getInt(10)),
            utilisateurDao.getById(result.getInt(11)),
            professeurDao.getById(result.getInt(12))
          )
        );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return list;
  }

  @Override
  public boolean update(Memoire t) {
    boolean status = true;
    try {
      String sql =
        "UPDATE memoire SET theme=?, description=?, dateSoutenance=?, entreprise=?, anneeAcademique=?, actif=?, datePublication=?, idEtudiant=?, idFiliere=?, idUtilisateur=?, idProfesseur=? WHERE id=?";
      statement = connection.prepareStatement(sql);
      statement.setString(1, t.getTitre());
      statement.setString(2, t.getDescription());
      statement.setObject(3, t.getDateSoutenance());
      statement.setString(4, t.getEntreprise());
      statement.setObject(5, t.getAnneeAcademique());
      statement.setBoolean(6, t.isActif());
      statement.setObject(7, t.getDatePublication());
      statement.setInt(8, t.getEtudiant().getId());
      statement.setInt(9, t.getFiliere().getId());
      statement.setInt(10, t.getUtilisateur().getId());
      statement.setInt(11, t.getProfesseur().getId());
      statement.setInt(12, t.getId());
      statement.execute();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      status = false;
    }
    return status;
  }

  @Override
  public boolean delete(Memoire t) {
    t.setActif(false);
    return update(t);
  }

  @Override
  public Memoire getById(Integer id) {
    Memoire memoire = null;
    try {
      String sql = "SELECT * FROM memoire WHERE actif=true AND id=?";
      statement = connection.prepareStatement(sql);
      statement.setInt(1, id);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        memoire =
          new Memoire(
            result.getInt(1),
            result.getString(2),
            result.getString(3),
            result.getObject(4, LocalDateTime.class),
            result.getString(5),
            result.getObject(6, Year.class),
            result.getBoolean(7),
            result.getObject(8, LocalDateTime.class),
            etudiantDao.getById(result.getInt(9)),
            filiereDao.getById(result.getInt(10)),
            utilisateurDao.getById(result.getInt(11)),
            professeurDao.getById(result.getInt(12))
          );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return memoire;
  }

  // Find memories by title
  public List<Memoire> findByTitle(String titre) {
    List<Memoire> list = new ArrayList<Memoire>();
    try {
      String sql =
        "SELECT * FROM memoire WHERE actif=true AND theme LIKE %" + titre + "%";
      statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        list.add(
          new Memoire(
            result.getInt(1),
            result.getString(2),
            result.getString(3),
            result.getObject(4, LocalDateTime.class),
            result.getString(5),
            result.getObject(6, Year.class),
            result.getBoolean(7),
            result.getObject(8, LocalDateTime.class),
            etudiantDao.getById(result.getInt(9)),
            filiereDao.getById(result.getInt(10)),
            utilisateurDao.getById(result.getInt(11)),
            professeurDao.getById(result.getInt(12))
          )
        );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return list;
  }
}
