/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DemoUDP_Server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author anhba
 */
public class UDP_Server {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(6789);
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
            while(true){
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                String sentence = new String(receivePacket.getData());
                InetAddress IPAAdress = receivePacket.getAddress();
                int port = receivePacket.getPort();
                String capitalizeSendtence = sentence.toUpperCase();
                sendData = capitalizeSendtence.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAAdress,port);
                serverSocket.send(sendPacket);
            }
        } catch (Exception e) {
        }
    }
}
