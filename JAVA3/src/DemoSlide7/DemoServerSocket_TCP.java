/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DemoSlide7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author anhba
 */
public class DemoServerSocket_TCP {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6789);
            System.out.println("Dang cho ket noi...");
            while (true) {                
                Socket socket = server.accept();
                System.out.println("Ket noi thanh cong!");
                BufferedReader reader =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter pw = new PrintWriter(socket.getOutputStream());
                String line = reader.readLine();
                System.out.println("Mes: "+line);
                System.out.println("Sent: "+line.toUpperCase());
                pw.print(line.toUpperCase());
                pw.flush();
                reader.close();
                pw.close();
                socket.close();
            }
        } catch (Exception e) {
        }
    }
}
