/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author anhba
 */
public class Lamthem extends JFrame {

    JLabel name, pass, email, country, cboname, title;
    JTextField txtname, txtpass, txtemail, txtcountry;
    JComboBox<Object> cbo;
    JButton btnsubmit;

    public Lamthem() throws HeadlessException {
        initComponets();
        loadata();
    }

    void initComponets() {
        setSize(600, 450);
        setDefaultCloseOperation(3);

        setLocationRelativeTo(null);
        setLayout(null);

        title = new JLabel("INFO EMP DATA");
        title.setFont(new Font("Arial", 1, 22));
        title.setForeground(Color.blue);
        title.setBounds(210, 10, 300, 50);

        cboname = new JLabel("Cbo.Name:");
        cboname.setBounds(100, 100, 100, 20);
        cbo = new JComboBox<>();
        cbo.setBounds(200, 100, 200, 20);

        btnsubmit = new JButton("Submit");
        btnsubmit.setBounds(420, 95, 80, 30);

        name = new JLabel("Name:");
        name.setBounds(100, 150, 100, 20);
        txtname = new JTextField();
        txtname.setBounds(200, 150, 200, 20);

        email = new JLabel("Email:");
        email.setBounds(100, 200, 100, 20);
        txtemail = new JTextField();
        txtemail.setBounds(200, 200, 200, 20);

        pass = new JLabel("Pass:");
        pass.setBounds(100, 250, 100, 20);
        txtpass = new JTextField();
        txtpass.setBounds(200, 250, 200, 20);

        country = new JLabel("Country:");
        country.setBounds(100, 300, 100, 20);
        txtcountry = new JTextField();
        txtcountry.setBounds(200, 300, 200, 20);

        add(title);
        add(cboname);
        add(cbo);
        add(btnsubmit);
        add(name);
        add(email);
        add(pass);
        add(country);
        add(txtname);
        add(txtemail);
        add(txtpass);
        add(txtcountry);

        txtcountry.setEditable(false);
        txtemail.setEditable(false);
        txtname.setEditable(false);
        txtpass.setEditable(false);

        btnsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display();

            }
        });

    }

    void loadata() {
        cbo.removeAllItems();
        try {
            Connection con = Ketnoi.Ketnoisql.conn();
            Statement stm = con.createStatement();
            String sql = "Select demoslide6.UName from demoslide6";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                cbo.addItem(rs.getString("UName"));
            }
            rs.close();
            con.close();
        } catch (Exception e) {
        }

    }

    void Display() {
        try {
            Connection con = Ketnoi.Ketnoisql.conn();
            PreparedStatement pstm = con.prepareStatement("Select * from demoslide6 where UName =?");
            pstm.setString(1, cbo.getSelectedItem().toString());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                txtname.setText(rs.getString("UName"));
                txtemail.setText(rs.getString("UEmail"));
                txtpass.setText(rs.getString("UPass"));
                txtcountry.setText(rs.getString("UCountry"));
            }
        } catch (Exception e) {
        }

    }

    public static void main(String[] args) {
        new Lamthem().setVisible(true);
    }
}
