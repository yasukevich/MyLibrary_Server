package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseHelper {

    private Connection dbConnection;

	public Connection getDBConnection() {
        if(dbConnection == null){
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                System.out.println("Драйвер подключен");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.print("ERROR!DRIVER");
                System.out.println(e.getMessage());
            }
            try {
                dbConnection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.56.101:1521:ocp12g", "librarian", "oracle");
                System.out.println("Connection to Oracle has been established.");
                return dbConnection;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return this.dbConnection;
    }

   /* public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Драйвер подключен");


        } catch (ClassNotFoundException e) {
            System.out.print("ERROR!DRIVER");
        }
        try {
            Locale.setDefault(Locale.ENGLISH);
            connection = DriverManager.getConnection(DB_DRIVER,DB_USERNAME,DB_PASSWORD);
            System.out.print("ПОДКЛЮЧЕНИЕ");

        } catch (SQLException e) {
            e.printStackTrace();
            Alert erorconnect = new Alert(Alert.AlertType.INFORMATION);       //Сообщение об ошибке
            erorconnect.setTitle("Ошибка подключения");
            erorconnect.setHeaderText(null);
            erorconnect.setContentText("Не удалось подключиться к базе данных");
            erorconnect.showAndWait();
        }

        return connection;
    }*/
}
