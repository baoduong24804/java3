/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DemoUDP_Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author anhba
 */
public class UDP_Client {

    public static void main(String[] args) {

        try {
            BufferedReader inFormUser = new BufferedReader(new InputStreamReader(System.in));
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress myost = InetAddress.getLocalHost();
            InetAddress IPAAdress = InetAddress.getByName(myost.getHostAddress());
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
            System.out.println("Nhap chuoi ki tu");
            String sentence = inFormUser.readLine();
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAAdress, 6789);
            clientSocket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String modifieSentence = new String(receivePacket.getData());
            System.out.println("FROM SERVER:" + modifieSentence);
            clientSocket.close();
        } catch (Exception e) {
        }

    }
}
