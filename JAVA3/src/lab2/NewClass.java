/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author anhba
 */
public class NewClass {
    public static void main(String[] args) {
         JFrame frame = new JFrame();
        frame.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        Point point = e.getPoint();
        System.out.println("X: " + point.getX() + ", Y: " + point.getY());
    }
});
        
        frame.setSize(800,600);
        frame.setVisible(true);
        
    }
    
    
   


}
