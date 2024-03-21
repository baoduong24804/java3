/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author anhba
 */
public class p1_bai3 extends JFrame {

    JSlider j = new JSlider(0, 50);
    JLabel lbl = new JLabel("Gia tri hien tai:");
    JLabel lblt = new JLabel("Font Size");
    JTextField txt = new JTextField();
    JButton btn = new JButton("Set value");

    public p1_bai3() throws HeadlessException {
        setSize(545, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        j.setMajorTickSpacing(5);
        j.setPreferredSize(new Dimension(500, 100));
        j.setPaintLabels(true);
        j.setPaintTicks(true);
        getContentPane().add(j);

        lbl.setForeground(Color.blue);
        txt.setForeground(Color.blue);
        txt.setPreferredSize(new Dimension(50, 20));

        getContentPane().add(lbl);
        getContentPane().add(txt);
        getContentPane().add(btn);
        getContentPane().add(lblt);
        txt.setText(String.valueOf(j.getValue()));

        lblt.setFont(new Font("Tahoma", 1, j.getValue()));
        lblt.setForeground(Color.BLUE);

        ChangeListener cc = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                txt.setText(String.valueOf(j.getValue()));
                lblt.setFont(new Font("Tahoma", 1, j.getValue()));
                //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };

        j.addChangeListener(cc);

        ActionListener a = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Integer.parseInt(txt.getText()) > 50 || Integer.parseInt(txt.getText()) < 0) {
                        return;
                    }
                    j.setValue(Integer.parseInt(txt.getText()));
                    lblt.setFont(new Font("Tahoma", 1, j.getValue()));
                } catch (Exception ec) {

                }

                //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };

        btn.addActionListener(a);

    }

    public static void main(String[] args) {
        new p1_bai3().setVisible(true);
    }

}
