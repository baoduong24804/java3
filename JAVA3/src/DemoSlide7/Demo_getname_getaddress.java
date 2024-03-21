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
public class Demo_getname_getaddress {
    public static void main(String[] args) {
        try {
            InetAddress myost = InetAddress.getLocalHost();
            System.out.println("Host address: "+myost.getHostAddress());
            System.out.println("Host name: "+myost.getHostName());
            
        } catch (Exception e) {
        }
    }
}
