/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5;

import java.sql.*;

/**
 *
 * @author anhba
 */
public class Bai1 {

    public static void main(String[] args) {
        try {
            //1. Nạp driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Loaded ...");

            //2. Định nghĩa  Connection URL
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=qlsv";
            String user = "sa";
            String password = "123";

            Connection con = DriverManager.getConnection(connectionUrl, user, password);
            System.out.println("Connected ...\nDone\n");

            //     DatabaseMetaData dm = (DatabaseMetaData) con.getMetaData();
            //       System.out.println("Driver name: "+dm.getDriverName());
            //3. Kết nối CSDL bằng đối tượng Connection
            //4. Tạo đối tượng Statement
            //      Statement stm = con.createStatement();
            //5. Thi hành câu truy vấn
            String sql = "select * from Student";
            Statement stm = con.createStatement();
            stm.execute(sql);
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                System.out.print(rs.getString("Masv") + ", ");
                System.out.print(rs.getString("Hoten") + ", ");
                System.out.print(rs.getString("Email") + ", ");
                System.out.print(rs.getString("Sdt") + ", ");
                System.out.println(rs.getString("Gioitinh"));
            }

            stm.close();
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
