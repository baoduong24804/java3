/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author anhba
 */
public class p2_bai2 extends JFrame implements ActionListener {

    public p2_bai2() throws HeadlessException {
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2, 5,5));
        JButton jb1 = new JButton("Message Dialog");
        JButton jb2 = new JButton("Input Dialog");
        JButton jb3 = new JButton("Comfirm Dialog");
        JButton jb4 = new JButton("Option Dialog");
        getContentPane().add(jb1);
        getContentPane().add(jb2);
        getContentPane().add(jb3);
        getContentPane().add(jb4);

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
    }

    public static void main(String[] args) {
        p2_bai2 p = new p2_bai2();
        p.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Message Dialog")) {
            JOptionPane.showMessageDialog(this, "Please input your name");
            return;
        }

        if (s.equals("Input Dialog")) {
            String ss = JOptionPane.showInputDialog(this, "Please input your name");
            if(ss!=null){
            JOptionPane.showMessageDialog(this, "Your name: "+ss);
            }
            return;
        }

        if (s.equals("Comfirm Dialog")) {
            int choice = JOptionPane.showConfirmDialog(this, "Are u sure", "Comfirm Dialog", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (choice == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, "Yes");
            }

            if (choice == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(this, "No");
            }
            return;
        }

        String a[] = {"Java", "C++", "VB", "PHP","Perl"};

        if (s.equals("Option Dialog")) {
            int choice = JOptionPane.showOptionDialog(this, "Ban hay chon Option", "Title", 0, JOptionPane.QUESTION_MESSAGE, null, a, a[0]);
            if (choice == -1) {
                return;
            }

            JOptionPane.showMessageDialog(this, a[choice]);
            return;
        }

        //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
