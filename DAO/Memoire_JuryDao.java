package DAO;

import classes.Memoire_Jury;
import database.Connexion;
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
public class Memoire_JuryDao {

  PreparedStatement statement = null;
  Connection connection = null;
  MemoireDao memoireDao = null;
  JuryDao juryDao = null;

  public Memoire_JuryDao() {
    connection = new Connexion().getConnexion();
    memoireDao = new MemoireDao();
    juryDao = new JuryDao();
  }

  public boolean create(Memoire_Jury t) {
    boolean status = true;
    try {
      String sql = "insert into memoire_jury(memoire_id, jury_id) values(?, ?)";
      statement = connection.prepareStatement(sql);
      statement.setInt(1, t.getMemoire().getId());
      statement.setInt(2, t.getJury().getId());
      statement.execute();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      status = false;
    }
    return status;
  }

  public List<Memoire_Jury> getAll(int memoire_id) {
    List<Memoire_Jury> list = new ArrayList<Memoire_Jury>();
    try {
      String sql =
        "SELECT * FROM memoire_jury WHERE actif=true AND memoire_id=?";
      statement = connection.prepareStatement(sql);
      statement.setInt(1, memoire_id);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        list.add(
          new Memoire_Jury(
            memoireDao.getById(result.getInt(1)),
            juryDao.getById(result.getInt(2)),
            result.getBoolean(3)
          )
        );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return list;
  }

  public boolean update(Memoire_Jury t) {
    boolean status = true;
    try {
      String sql =
        "update memoire_jury set memoire_id=?, jury_id=?, actif=? where memoire_id=? AND jury_id=?";
      statement = connection.prepareStatement(sql);
      statement.setInt(1, t.getMemoire().getId());
      statement.setInt(2, t.getJury().getId());
      statement.setBoolean(3, t.isActif());
      statement.setInt(4, t.getMemoire().getId());
      statement.setInt(4, t.getJury().getId());
      statement.execute();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      status = false;
    }
    return status;
  }

  public boolean delete(Memoire_Jury t) {
    t.setActif(false);
    return update(t);
  }

  public Memoire_Jury getById(int memoire_id, int jury_id) {
    Memoire_Jury memoire_jury = null;
    try {
      String sql =
        "SELECT * FROM memoire_jury where memoire_id=? AND jury_id=? AND actif=true";
      statement = connection.prepareStatement(sql);
      statement.setInt(1, memoire_id);
      statement.setInt(2, jury_id);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        memoire_jury =
          new Memoire_Jury(
            memoireDao.getById(result.getInt(1)),
            juryDao.getById(result.getInt(2)),
            result.getBoolean(3)
          );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return memoire_jury;
  }
}
