package Main;

import java.sql.*;

public class DatabaseConnection {
    private Connection connection;
    private ResultSet resultSet;
    private Statement statement;
    private static DatabaseConnection dbConn = null;
    static {
        try{
            dbConn = new DatabaseConnection("library","root","");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    static DatabaseConnection getInstance(){
        return dbConn;
    }
    private DatabaseConnection(String dbName, String username, String password) throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library",username,password);
        statement = connection.createStatement();
    }
}
