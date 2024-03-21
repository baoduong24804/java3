/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ketnoi;

import java.sql.*;

/**
 *
 * @author anhba
 */
public class Ketnoisql {

    public static Connection conn() {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       //     System.out.println("Loaded ...");

            //2. Định nghĩa  Connection URL
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=test";//qlsv //EMPDB
            String user = "sa";
            String password = "123";
            con = DriverManager.getConnection(connectionUrl, user, password);
            System.out.println("Ket noi thanh cong");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
    public static void main(String[] args) {
        conn();
    }
}
