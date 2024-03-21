/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author anhba
 */
public class p1_bai1_server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(9999);
            System.out.println("Server is connecting...");
            Socket socket = server.accept();
            System.out.println("Server is connect");
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
             while(true){
               double s1 = in.readDouble();
               double s2 = in.readDouble();
                 System.out.println("Hai so nhan duoc tu client: "+s1+" va "+s2);
                 out.writeDouble(s1+s2);
                 out.flush();
                 System.out.println("Tong 2 so la: "+(s1+s2));
            }
        } catch (Exception e) {
        }
    }
}
