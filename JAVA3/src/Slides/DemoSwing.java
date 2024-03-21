/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slides;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author anhba
 */
public class DemoSwing extends JFrame {

    public DemoSwing() throws HeadlessException {
        initComponets();
    }

    public void initComponets() {
        setTitle("Demo");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        JButton btn = new JButton("Login");
        getContentPane().add(btn);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        DemoSwing d = new DemoSwing();
        d.setVisible(true);
    }
}
