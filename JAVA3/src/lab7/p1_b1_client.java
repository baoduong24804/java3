/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author anhba
 */
public class p1_b1_client {
    public static void main(String[] args) {
     //   26.17.96.165
        try {
            System.out.println("Client is Connecting...");
            Socket socket = new Socket("26.17.96.165", 9999);
            System.out.println("Client is Connect");
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            while(true){
                System.out.println("Nhap so thu 1:");
                out.writeDouble(new Scanner(System.in).nextDouble());
                out.flush();
                System.out.println("Nhap so thu 2:");
                out.writeDouble(new Scanner(System.in).nextDouble());
                out.flush();
                System.out.println("Tong 2 so: "+in.readDouble());
                System.out.print("Tiep tuc?(y/n):");
                
                if(new Scanner(System.in).nextLine().equalsIgnoreCase("n")){
                break;
                }
            }
        } catch (Exception e) {
        }
    }
}
