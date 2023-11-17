/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConectaBanco;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

    private static final String USERNAME = "root";

    private static final String PASSWORD = "050621";

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenciaviagem";


    public static Connection createConnectionToMySQL() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver"); //Faz com que a classe seja carregada pela JVM
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        return connection;
    }

}
