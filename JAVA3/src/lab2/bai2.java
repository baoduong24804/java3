/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author anhba
 */
public class bai2 extends JFrame implements ActionListener {

    JLabel lbl1, lbl2;
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20;
    private long a = 0;
    private long c = 0;
    private String pheptoan = "";
    int check = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("C")) {
            lbl2.setText("");
            a = 0;
            return;
        }
        if (lbl2.getText().length() > 12) {
            return;
        }
        if (s.equals("0")) {
            lbl2.setText(lbl2.getText() + "0");
        }
        if (s.equals("1")) {
            lbl2.setText(lbl2.getText() + "1");
        }
        if (s.equals("2")) {
            lbl2.setText(lbl2.getText() + "2");
        }
        if (s.equals("3")) {
            lbl2.setText(lbl2.getText() + "3");
        }
        if (s.equals("4")) {
            lbl2.setText(lbl2.getText() + "4");
        }
        if (s.equals("5")) {
            lbl2.setText(lbl2.getText() + "5");
        }
        if (s.equals("6")) {
            lbl2.setText(lbl2.getText() + "6");
        }
        if (s.equals("7")) {
            lbl2.setText(lbl2.getText() + "7");
        }
        if (s.equals("8")) {
            lbl2.setText(lbl2.getText() + "8");
        }
        if (s.equals("9")) {
            lbl2.setText(lbl2.getText() + "9");
        }

        if (s.equals("+") && Long.parseLong(lbl2.getText()) != 0) {
            a = Long.parseLong(lbl2.getText());
            pheptoan = "+";
            lbl2.setText("");
        }

        if (s.equals("-") && Long.parseLong(lbl2.getText()) != 0) {
            a = Long.parseLong(lbl2.getText());
            pheptoan = "-";
            lbl2.setText("");
        }

        if (s.equals("/") && Long.parseLong(lbl2.getText()) != 0) {
            a = Long.parseLong(lbl2.getText());
            pheptoan = "/";
            lbl2.setText("");
        }
        
         if (s.equals("%") && Long.parseLong(lbl2.getText()) != 0) {
            a = Long.parseLong(lbl2.getText());
            pheptoan = "%";
            lbl2.setText("");
        }

        if (s.equals("*") && Long.parseLong(lbl2.getText()) != 0) {
            a = Long.parseLong(lbl2.getText());
            pheptoan = "*";
            lbl2.setText("");
        }

        if (s.equals("+/-") && Long.parseLong(lbl2.getText()) != 0) {
            a = Long.parseLong(lbl2.getText());
            pheptoan = "+/-";
            lbl2.setText("");
            check = 2;
        }

        if (s.equals("sqrt") && Long.parseLong(lbl2.getText()) != 0) {
            
            lbl2.setText(String.valueOf(Math.round(Math.sqrt(Long.parseLong(lbl2.getText())))));
        }
        
          if (s.equals("1/x") && Long.parseLong(lbl2.getText()) != 0) {
            lbl2.setText(String.valueOf(Math.round(-1/(Long.parseLong(lbl2.getText())*2))));
        }
//        if (lbl2.getText() != "") {
//            a = Long.parseLong(lbl2.getText());
//        }

        if (s.equals("=") && pheptoan == "+/-" && check == 2) {
            c = Long.parseLong(lbl2.getText());
            check = 0;
        }

        if (s.equals("=") && pheptoan != "" && lbl2.getText() != "") {
            long kq = 0;
            long b = Long.parseLong(lbl2.getText());

            if (pheptoan.equals("+/-")) {

                if (check == 0) {

                    kq = a + c;

                    check = 1;
                    lbl2.setText(String.valueOf(kq));
                    pheptoan = "+/-";
                    return;
                }

                if (check == 1) {

                    kq = a - c;
                    check = 0;
                    lbl2.setText(String.valueOf(kq));
                    pheptoan = "+/-";
                    return;
                }

            }

            if (pheptoan.equals("+")) {
                kq = a + b;
                lbl2.setText(String.valueOf(kq));
            }
            if (pheptoan.equals("-")) {
                kq = a - b;
                lbl2.setText(String.valueOf(kq));
            }
            if (pheptoan.equals("*")) {
                kq = a * b;
                lbl2.setText(String.valueOf(kq));
            }
            if (pheptoan.equals("/")) {
                kq = a / b;
                lbl2.setText(String.valueOf(kq));
            }
             if (pheptoan.equals("%")) {
                kq = a % b;
                lbl2.setText(String.valueOf(kq));
            }

            pheptoan = "";
        }

        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public bai2() throws HeadlessException {
        setDefaultCloseOperation(3);
        setSize(400, 490);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setLayout(null);
        //  setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JPanel pnl1 = new JPanel();
        pnl1.setBounds(0, 0, 385, 80);
        lbl1 = new JLabel("CASIO");
        lbl1.setBounds(300, 20, 80, 40);
        lbl1.setFont(new Font("Arial", Font.BOLD, 20));
        getContentPane().add(lbl1);
        getContentPane().add(pnl1);

        JPanel pnl2 = new JPanel();
        pnl2.setBounds(0, 80, 385, 80);
        pnl2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lbl2 = new JLabel("");
        lbl2.setBounds(0, 100, 385, 40);
        lbl2.setFont(new Font("Arial", 0, 18));
        lbl2.setForeground(Color.BLUE);
        lbl2.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(lbl2);
        getContentPane().add(pnl2);

        JLabel pnl3 = new JLabel();
        pnl3.setBounds(0, 160, 385, (355 - 60));
        pnl3.setLayout(new GridLayout(4, 5));
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("/");
        btn5 = new JButton("sqrt");

        btn6 = new JButton("4");
        btn7 = new JButton("5");
        btn8 = new JButton("6");
        btn9 = new JButton("*");
        btn10 = new JButton("%");

        btn11 = new JButton("7");
        btn12 = new JButton("8");
        btn13 = new JButton("9");
        btn14 = new JButton("-");
        btn15 = new JButton("1/x");

        btn16 = new JButton("0");
        btn17 = new JButton("+/-");
        btn18 = new JButton("C");
        btn19 = new JButton("+");
        btn20 = new JButton("=");

        pnl3.add(btn1);
        pnl3.add(btn2);
        pnl3.add(btn3);
        pnl3.add(btn4);
        pnl3.add(btn5);
        pnl3.add(btn6);
        pnl3.add(btn7);
        pnl3.add(btn8);
        pnl3.add(btn9);
        pnl3.add(btn10);

        pnl3.add(btn10);
        pnl3.add(btn11);
        pnl3.add(btn12);
        pnl3.add(btn13);
        pnl3.add(btn14);
        pnl3.add(btn15);
        pnl3.add(btn16);
        pnl3.add(btn17);
        pnl3.add(btn18);
        pnl3.add(btn19);
        pnl3.add(btn20);

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btn10.addActionListener(this);
        btn11.addActionListener(this);
        btn12.addActionListener(this);
        btn13.addActionListener(this);
        btn14.addActionListener(this);
        btn15.addActionListener(this);
        btn16.addActionListener(this);
        btn17.addActionListener(this);
        btn18.addActionListener(this);
        btn19.addActionListener(this);
        btn20.addActionListener(this);

        getContentPane().add(pnl3);

    }

    public static void main(String[] args) {
        new bai2().setVisible(true);
    }

}
