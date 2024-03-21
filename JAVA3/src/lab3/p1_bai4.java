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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author anhba
 */
public class p1_bai4 extends JFrame implements ActionListener {

    JPanel pnl1, pnl2, pnl3, pnl4;
    JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lbl9, lbl10;
    JButton btn1, btn2, btn3;
    JTextArea txtAddress;
    JTextField txtFirstName, txtLastName, txtContact, txtHQ, txtSpec, txtEn, txtHo, txtSport;

    public p1_bai4() throws HeadlessException {
        setSize(500, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        pnl1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));

        pnl1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Personal Details"));
        pnl1.setPreferredSize(new Dimension(450, 220));

        lbl1 = new JLabel("             First Name:");
        txtFirstName = new JTextField();
        txtFirstName.setPreferredSize(new Dimension(200, 20));
        pnl1.add(lbl1);
        pnl1.add(txtFirstName);

        lbl2 = new JLabel("              Last Name:");
        txtLastName = new JTextField();
        txtLastName.setPreferredSize(new Dimension(200, 20));
        pnl1.add(lbl2);
        pnl1.add(txtLastName);

        lbl3 = new JLabel("                   Contact:");
        txtContact = new JTextField();
        txtContact.setPreferredSize(new Dimension(200, 20));
        pnl1.add(lbl3);
        pnl1.add(txtContact);

        lbl4 = new JLabel("                 Address:");
        txtAddress = new JTextArea(5, 20);
        JScrollPane j = new JScrollPane(txtAddress);
        pnl1.add(lbl4);
        pnl1.add(j);

        lbl10 = new JLabel("STUDENT REGISTRATION");
        lbl10.setFont(new Font("Segoe UI", 1, 22));
        lbl10.setForeground(new Color(204, 0, 204));

        pnl2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));

        pnl2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Acameidc Details"));
        pnl2.setPreferredSize(new Dimension(450, 130));

        lbl5 = new JLabel("        Highest Qualification:");
        txtHQ = new JTextField();
        txtHQ.setPreferredSize(new Dimension(200, 20));
        pnl2.add(lbl5);
        pnl2.add(txtHQ);

        lbl6 = new JLabel("                      Specification:");
        txtSpec = new JTextField();
        txtSpec.setPreferredSize(new Dimension(200, 20));
        pnl2.add(lbl6);
        pnl2.add(txtSpec);

        lbl7 = new JLabel("                           Enroll For:");
        txtEn = new JTextField();
        txtEn.setPreferredSize(new Dimension(200, 20));
        pnl2.add(lbl7);
        pnl2.add(txtEn);

        pnl3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));

        pnl3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Extracurricular Details"));
        pnl3.setPreferredSize(new Dimension(450, 100));

        lbl8 = new JLabel("                  Hobbies:");
        txtHo = new JTextField();
        txtHo.setPreferredSize(new Dimension(200, 20));
        pnl3.add(lbl8);
        pnl3.add(txtHo);

        lbl9 = new JLabel("                       Sport:");
        txtSport = new JTextField();
        txtSport.setPreferredSize(new Dimension(200, 20));
        pnl3.add(lbl9);
        pnl3.add(txtSport);

        pnl4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        pnl4.setBorder(BorderFactory.createLineBorder(Color.black));
        pnl4.setPreferredSize(new Dimension(450, 50));
        btn1 = new JButton("Save");

        pnl4.add(btn1);
        btn2 = new JButton("Reset");
        //  btn1.setBorder(BorderFactory.createLineBorder(Color.black));

        pnl4.add(btn2);
        btn3 = new JButton("Exit");
        //  btn1.setBorder(BorderFactory.createLineBorder(Color.black));

        pnl4.add(btn3);

        getContentPane().add(lbl10);
        getContentPane().add(pnl1);
        getContentPane().add(pnl2);
        getContentPane().add(pnl3);
        getContentPane().add(pnl4);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);

    }

    public static void main(String[] args) {
        new p1_bai4().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
        
        
        if (e.getActionCommand().equals("Reset")) {
txtFirstName.setText("");txtLastName.setText("");txtContact.setText("");txtAddress.setText("");txtHQ.setText("");
txtHo.setText("");txtEn.setText("");txtSpec.setText("");txtSport.setText("");
return;
        }
        
        if (e.getActionCommand().equals("Save")) {
            if (txtAddress.getText().trim().isEmpty() || txtContact.getText().trim().isEmpty() || txtEn.getText().trim().isEmpty()
                    || txtFirstName.getText().trim().isEmpty() || txtHQ.getText().trim().isEmpty() || txtHo.getText().trim().isEmpty()
                    || txtLastName.getText().trim().isEmpty() || txtSpec.getText().trim().isEmpty() || txtSport.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui long dien day du thong tin");
                return;
            }
            JOptionPane.showMessageDialog(this, txtFirstName.getText()+"\n"+txtLastName.getText()+"\n"+txtContact.getText()
            +"\n"+txtAddress.getText()+"\n"+txtHQ.getText()+"\n"+txtSpec.getText()+"\n"+txtEn.getText()+"\n"+txtHo.getText()+"\n"+txtSport.getText());
        }
        

//  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
