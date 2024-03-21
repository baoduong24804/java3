/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author anhba
 */
public class p1_bai1 extends JFrame implements ActionListener {

    JButton btnRed, btnGreen, btnYellow,
            btnNorth, btnCenter, btnSouth, btnEast, btnWest,
            btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;
    JTextField txt;
    JPanel pnl1, pnl2, pnl3, pnl4;

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s == null) {
            return;
        }
        if (s.equals("Red") || s.equals("Yellow") || s.equals("Green")) {
            switch (s) {
                case "Red" : {
                    pnl1.setBackground(Color.red);
                    break;
                }

                case "Yellow" : {
                    pnl1.setBackground(Color.yellow);
                    break;
                }

                case "Green" : {
                    pnl1.setBackground(Color.green);
                    break;
                }
            }
            return;
        }

        if (s.equals("North") || s.equals("Center") || s.equals("South") || s.equals("West") || s.equals("East")) {
            switch (s) {
                case "North" : {
                    txt.setText("Ban da chon North");
                    break;
                }
                case "Center" : {
                    txt.setText("Ban da chon Center");
                    break;
                }
                case "South" : {
                    txt.setText("Ban da chon South");
                    break;
                }
                case "West" : {
                    txt.setText("Ban da chon West");
                    break;
                }
                case "East" : {
                    txt.setText("Ban da chon East");
                    break;
                }
            }
            return;
        }

        //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public p1_bai1() throws HeadlessException {
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
//        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        setLayout(null);

        pnl1 = new JPanel();
        pnl1.setBounds(0, 0, 600, 50);
        //   pnl1.setSize(600, 50);
        pnl1.setBackground(new Color(234, 183, 132));

        FlowLayout f = new FlowLayout(FlowLayout.RIGHT);
        f.setHgap(30);
        f.setVgap(10);
        pnl1.setLayout(f);
        btnRed = new JButton("Red");
        btnGreen = new JButton("Green");
        btnYellow = new JButton("Yellow");
        pnl1.add(btnRed);
        pnl1.add(btnGreen);
        pnl1.add(btnYellow);
        getContentPane().add(pnl1);

        pnl2 = new JPanel(new BorderLayout());
        pnl2.setBounds(0, 50, 600, 150);
        //   pnl2.setSize(600, 150);

        btnNorth = new JButton("North");
        btnNorth.setFont(new Font("Segoe UI", 0, 16));
        btnSouth = new JButton("South");
        btnSouth.setFont(new Font("Segoe UI", 0, 16));
        btnCenter = new JButton("Center");
        btnCenter.setFont(new Font("Segoe UI", 0, 16));
        btnWest = new JButton("West");
        btnWest.setFont(new Font("Segoe UI", 0, 16));
        btnEast = new JButton("East");
        btnEast.setFont(new Font("Segoe UI", 0, 16));

        pnl2.add(btnNorth, BorderLayout.NORTH);
        pnl2.add(btnSouth, BorderLayout.SOUTH);
        pnl2.add(btnCenter, BorderLayout.CENTER);
        pnl2.add(btnWest, BorderLayout.WEST);
        pnl2.add(btnEast, BorderLayout.EAST);

        getContentPane().add(pnl2);

        pnl3 = new JPanel();
        pnl3.setBounds(0, 200, 600, 50);
        txt = new JTextField(":3");
        txt.setPreferredSize(new Dimension(500, 40));
        txt.setFont(new Font("Segoe UI", Font.BOLD, 22));
        txt.setForeground(new Color(27, 175, 65));
        pnl3.add(txt);
        //   pnl3.setSize(100, 80);

        getContentPane().add(pnl3);

        pnl4 = new JPanel(new GridLayout(2, 5, 5, 5));
        pnl4.setBackground(new Color(249, 77, 249));
        pnl4.setBounds(25, 250, 550, 100);

        btn1 = new JButton();
        btn2 = new JButton();
        btn3 = new JButton();
        btn4 = new JButton();
        btn5 = new JButton();
        btn6 = new JButton();
        btn7 = new JButton();
        btn8 = new JButton();
        btn9 = new JButton();
        btn10 = new JButton();
        pnl4.add(btn1);
        pnl4.add(btn2);
        pnl4.add(btn3);
        pnl4.add(btn4);
        pnl4.add(btn4);
        pnl4.add(btn5);
        pnl4.add(btn6);
        pnl4.add(btn7);
        pnl4.add(btn8);
        pnl4.add(btn9);
        pnl4.add(btn10);
        getContentPane().add(pnl4);

        btnRed.addActionListener(this);
        btnYellow.addActionListener(this);
        btnGreen.addActionListener(this);
        
        btnNorth.addActionListener(this);
        btnCenter.addActionListener(this);
        btnSouth.addActionListener(this);
        btnWest.addActionListener(this);
        btnEast.addActionListener(this);
    }

    public static void main(String[] args) {
        new p1_bai1().setVisible(true);
    }

}
