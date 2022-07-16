package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.Ressource_Evenements;
import database.Connexion;

public class Ressource_EvenementDao {
    PreparedStatement statement = null;
  Connection connection = null;
  EvenementDao evenementDao = null;

  public Ressource_EvenementDao() {
    connection = new Connexion().getConnexion();
    evenementDao = new EvenementDao();
  }

  public boolean create(Ressource_Evenements t) {
    boolean status = true;
    try {
      String sql =
        "insert into ressource_evenements(titre, description, taille, chemin, idEvenement) values(?, ?, ?, ?, ?)";
      statement = connection.prepareStatement(sql);
      statement.setString(1, t.getTitre());
      statement.setString(2, t.getDescription());
      statement.setLong(3, t.getTaille());
      statement.setString(4, t.getChemin());
      statement.setInt(5, t.getEvenement().getId());
      statement.execute();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      status = false;
    }

    return status;
  }

  public List<Ressource_Evenements> getAll() {
    List<Ressource_Evenements> list = new ArrayList<>();
    try {
      String sql = "SELECT * FROM ressource_evenements WHERE actif=true";
      statement = connection.prepareStatement(sql);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        list.add(
          new Ressource_Evenements(
            result.getInt(1),
            result.getString(2),
            result.getString(3),
            result.getLong(4),
            result.getString(5),
            result.getBoolean(6),
            evenementDao.getById(result.getInt(7))
          )
        );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return list;
  }

  public boolean update(Ressource_Evenements t){
    boolean status = true;
    try {
        String sql =
          "UPDATE ressource_evenements SET titre=?, description=?, taille=?, chemin=? ,actif=?, idEvenement=? WHERE id=?";
        statement = connection.prepareStatement(sql);
        statement.setString(1, t.getTitre());
        statement.setString(2, t.getDescription());
        statement.setLong(3, t.getTaille());
        statement.setString(4, t.getChemin());
        statement.setBoolean(5, t.isActif());
        statement.setInt(6, t.getEvenement().getId());
        statement.setInt(6, t.getId());
        statement.execute();
      } catch (SQLException e) {
        System.out.println(e.getMessage());
        status = false;
      }
    return status;
  }

  public boolean delete(Ressource_Evenements t){
    t.setActif(false);
    return update(t);
  }

  public Ressource_Evenements getById(int id){
    Ressource_Evenements ressource_Evenements = null;
    try {
        String sql = "SELECT * FROM ressource_evenements WHERE actif=true AND id=?";
        statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            ressource_Evenements =
            new Ressource_Evenements(
            result.getInt(1),
            result.getString(2),
            result.getString(3),
            result.getLong(4),
            result.getString(5),
            result.getBoolean(6),
            evenementDao.getById(result.getInt(7))
            );
        }
      } catch (SQLException e) {
        System.out.println(e.getMessage());
      }
      return ressource_Evenements;
  }


}
