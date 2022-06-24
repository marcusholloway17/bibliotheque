package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Logan
 */
public class Connexion {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/bibliotheque";
    static final String USER = "myuser";
    static final String PASS = "1234";

    public Connection getConnexion(){
        Connection connection = null;

        try{
            // load the driver
            Class.forName( JDBC_DRIVER );
            // etablish connection 
            try{
                connection = DriverManager.getConnection(DATABASE_URL, USER, PASS);
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
