/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author anhba
 */
public class bai1 extends JFrame implements ActionListener {

    JTextField jt;
    JTextArea jarea;
    JCheckBox jc1, jc2, jc3;
    JButton jb1, jb2;
    JComboBox jcombo;
    JRadioButton jr1, jr2;
    int lengthtext = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Reset")) {
            jt.setText("");
            jarea.setText("");
            jr1.setSelected(true);
            jc1.setSelected(true);
            jcombo.setSelectedIndex(0);
            return;
        }

        if (checkNull()) {
           
            String s = "";
            s = "\nName: " + jt.getText().trim();
            s += "\nAddress: " + jarea.getText().trim();
            s += "\nQualification: " + jcombo.getSelectedItem();

            if (jr1.isSelected()) {
                s += "\nSex: " + "Male";
            }

            if (jr2.isSelected()) {
                s += "\nSex: " + "Female";
            }

            if (jc1.isSelected()) {
                s += "\nHoppy: " + "Reading";
            }
            if (jc2.isSelected()) {
                s += "\nHoppy: " + "Singing";
            }
            if (jc3.isSelected()) {
                s += "\nHoppy: " + "Dancing";
            }
            System.out.println(jarea.getText().trim().length());
            JOptionPane.showMessageDialog(this, s);
        } else {
            String t = "";
            if (jt.getText().trim().isEmpty()) {
                t += "\nName: Empty";
            }

            if (jarea.getText().trim().isEmpty()) {
                t += "\nAddress: Empty";
            }
            JOptionPane.showMessageDialog(this, t);
        }
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public bai1() throws HeadlessException {
        setDefaultCloseOperation(3);
        setSize(700, 500);
        
        setLocationRelativeTo(null);
        setLayout(null);
        JLabel jl1 = new JLabel("Name:");
        jl1.setBounds(20, 25, 80, 20);
        getContentPane().add(jl1);
        //
        jt = new JTextField();
        jt.setBounds(80, 25, 150, 20);
        getContentPane().add(jt);
        // x = 80

        JLabel jl3 = new JLabel("Address:");
        jl3.setBounds(20, 80, 80, 20);
        getContentPane().add(jl3);
        jarea = new JTextArea();
        jarea.setBounds(80, 80, 300, 150);
        jarea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(jarea);

        JLabel jl5 = new JLabel("Sex:");
        jl5.setBounds(20, 250, 80, 20);
        getContentPane().add(jl5);
        JPanel jp1 = new JPanel();
        jp1.setBounds(80, 250, 80, 80);
        jr1 = new JRadioButton("Male");
        jr1.setSelected(true);
        jr2 = new JRadioButton("Female");
        jp1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        jp1.setLayout(new GridLayout(2, 1));
        ButtonGroup group = new ButtonGroup();
        group.add(jr1);
        group.add(jr2);
        jp1.add(jr1);
        jp1.add(jr2);
        getContentPane().add(jp1);

        JLabel jl2 = new JLabel("Qualification:");
        jl2.setBounds(450, 25, 80, 20);
        getContentPane().add(jl2);
        jcombo = new JComboBox(new Object[]{"Graduate", "Student"});
        jcombo.setBounds(530, 25, 80, 20);
        getContentPane().add(jcombo);

        JLabel jl4 = new JLabel("Hoppy:");
        jl4.setBounds(450, 80, 80, 20);
        getContentPane().add(jl4);

        jc1 = new JCheckBox("Reading");
        jc1.setSelected(true);
        jc2 = new JCheckBox("Singing");
        jc3 = new JCheckBox("Dancing");
//        ButtonGroup group2 = new ButtonGroup();
//        group2.add(jc1);
//        group2.add(jc2);
//        group2.add(jc3);
        JPanel jp2 = new JPanel();
        jp2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        jp2.add(jc1);
        jp2.add(jc2);
        jp2.add(jc3);
        jp2.setBounds(530, 80, 80, 100);
        jp2.setLayout(new GridLayout(3, 1));
        getContentPane().add(jp2);

        jb1 = new JButton("Validate");
        jb1.setBounds(240, 380, 80, 20);
        getContentPane().add(jb1);
        jb1.addActionListener(this);

        jb2 = new JButton("Reset");
        jb2.setBounds(340, 380, 80, 20);
        getContentPane().add(jb2);
        jb2.addActionListener(this);

    }

    public static void main(String[] args) {
        bai1 b = new bai1();

//        b.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                Point point = e.getPoint();
//                System.out.println("X: " + point.getX() + ", Y: " + point.getY());
//            }
//        });
        b.setVisible(true);
    }

    public boolean checkNull() {
        if (jt.getText().trim().isEmpty() || jarea.getText().trim().isEmpty()) {
            return false;
        }
        return true;
    }

}
