/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DemoSlide7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author anhba
 */
public class DemoClientSocket_TCP {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("26.17.96.165", 6789);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            pw.print(s);
            pw.flush();
            reader.close();
            pw.close();
            socket.close();
        } catch (Exception e) {
        }
    }
}
