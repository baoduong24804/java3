/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slides2;

import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author anhba
 */
public class Demo2 {
    
    
    
    
    public static void main(String[] args) {
        JFrame j = new JFrame("Demo2");
        j.setSize(400, 300);
        j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel p = new JPanel(new GridLayout(2,2));
        
        JCheckBox c1 = new JCheckBox("C/C++");
        JCheckBox c2 = new JCheckBox("C#");
        JCheckBox c3 = new JCheckBox("PHP");
        JCheckBox c4 = new JCheckBox("JAVA");
        
        p.add(c1);
        p.add(c2);
        p.add(c3);
        p.add(c4);
        
        ButtonGroup gr = new ButtonGroup();
        gr.add(c1);
        gr.add(c2);
        gr.add(c3);
        gr.add(c4);
        
        j.getContentPane().add(p);
       
        
        j.pack();
        j.setVisible(true);
    }
}
