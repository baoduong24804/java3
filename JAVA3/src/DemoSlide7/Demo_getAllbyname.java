/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DemoSlide7;

import java.net.InetAddress;

/**
 *
 * @author anhba
 */
public class Demo_getAllbyname {
    public static void main(String[] args) {
        try {
            InetAddress address[] = InetAddress.getAllByName("ne.com");
            for(int i = 0;i<address.length;i++){
                System.out.println("Address: "+address[i]);
            }
        } catch (Exception e) {
        }
    }
}
