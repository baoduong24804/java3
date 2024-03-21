/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slides;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author anhba
 */
public class DemoJpanel extends JFrame {
    
    public DemoJpanel(String title) throws HeadlessException {
        super(title);
        initComponets();
    }
    
    private void initComponets() {
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jpanel = new JPanel(new GridLayout(3, 3));
        jpanel.setBorder(BorderFactory.createTitledBorder("jpane"));
        
        JButton jbutton[] = new JButton[9];
        for(int i = 0; i < 9; i++){
        jbutton[i] =  new JButton("Button "+(i+1));
        jpanel.add(jbutton[i]);
        }
        
        
        
        getContentPane().add(jpanel);
    }
    
    public static void main(String[] args) {
        DemoJpanel d = new DemoJpanel("DemoJpanel");
        d.setVisible(true);
        d.setLocationRelativeTo(null);
    }
}
