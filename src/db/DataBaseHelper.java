package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseHelper {

    private static DataBaseHelper _instance=null;

    private Connection dbConnection;

    //private DataBaseHelper(){}

    public static DataBaseHelper getInstance() {
        if (_instance == null) {
            _instance = new DataBaseHelper();
        }
        return _instance;
    }

	public Connection getDBConnection() {
        if(dbConnection == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Драйвер подключен");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.print("ERROR!DRIVER");
                System.out.println(e.getMessage());
            }
            try {
                dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "oracle");
                System.out.println("Connection to MySql has been established.");
                return dbConnection;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return this.dbConnection;
    }


   public boolean isLogin(String name,String pass){

        return true;
   }
}
