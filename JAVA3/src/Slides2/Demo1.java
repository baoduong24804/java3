/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slides2;


import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author anhba
 */
public class Demo1 extends JFrame implements ActionListener {

    ImageIcon vnIcon = new ImageIcon("src\\Icons\\VietNam.png");
    ImageIcon ameIcon = new ImageIcon("src\\Icons\\america-usa.png");
    ImageIcon uniIcon = new ImageIcon("src\\Icons\\united-kingdom.png");

    
    
    public Demo1() throws HeadlessException {

        setSize(550, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p1 = new JPanel();
        p1.setBorder(new TitledBorder("Demo"));
        JButton b1 = new JButton("Click it", vnIcon);
        JButton b2 = new JButton("Click it", ameIcon);
        JButton b3 = new JButton("Click it", uniIcon);

        b1.setRolloverIcon(uniIcon);// re chuot
        b1.setPressedIcon(ameIcon);// chon

        b1.addActionListener(this);

        p1.add(b1);
        p1.add(b3);
        p1.add(b2);
        getContentPane().add(p1);
        
  
        setVisible(true);
    }

    public static void main(String[] args) {
        Demo1 d = new Demo1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Ban da chon vn");
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
