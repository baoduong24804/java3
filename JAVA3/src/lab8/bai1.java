/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author anhba
 */
public class bai1 extends JFrame {

    JTextField txtuser, txtto, txtsubject;
    JPasswordField txtpass;
    JTextArea txtmes;
    JButton btnsend;

    public bai1() throws HeadlessException {
        initComponet();
        btnsend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            send();
            
            }
        });
        setVisible(true);
    }

    void initComponet() {
        setSize(500, 500);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setLayout(null);
        JLabel lblsendmail = new JLabel("Send Mail");
        lblsendmail.setForeground(Color.blue);
        lblsendmail.setFont(new Font("Arial", 1, 20));
        lblsendmail.setBounds(200, 20, 200, 50);

        JPanel pnl1 = new JPanel();
        pnl1.setLayout(null);
        pnl1.setBounds(20, 80, 450, 130);
        pnl1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Send", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, new Font("Ariral", 1, 10)));
        //  pnl1.setBackground(Color.red);
        JLabel lblusername = new JLabel("Username:");
        lblusername.setBounds(50, 30, 100, 20);

        txtuser = new JTextField();
        txtuser.setText("anhbao5cm@gmail.com");
        txtuser.setBounds(120, 30, 200, 20);

        JLabel lblpass = new JLabel("Password:");
        lblpass.setBounds(50, 80, 100, 20);
        txtpass = new JPasswordField();
        txtpass.setText("uipyfagdfqkmmqea");
        txtpass.setBounds(120, 80, 200, 20);

        JPanel pnl2 = new JPanel();
        pnl2.setLayout(null);
        pnl2.setBounds(20, 220, 450, 200);
        pnl2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Receive", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, new Font("Ariral", 1, 10)));

        JLabel lblto = new JLabel("To:");
        lblto.setBounds(50, 30, 100, 20);
        txtto = new JTextField();
        txtto.setText("ngoczig11@gmail.com");
        txtto.setBounds(120, 30, 200, 20);
        JLabel lblsubject = new JLabel("Subject:");
        lblsubject.setBounds(50, 60, 100, 20);
        txtsubject = new JTextField();
        txtsubject.setText("Test mail");
        txtsubject.setBounds(120, 60, 200, 20);
        JLabel lblmes = new JLabel("Message:");
        lblmes.setBounds(50, 90, 100, 20);
        txtmes = new JTextArea();
        //   txtmes.setBounds(120, 80, 200, 20);
        JScrollPane scr = new JScrollPane(txtmes);
        scr.setBounds(120, 90, 200, 100);
        btnsend = new JButton("Send");
        btnsend.setBounds(330, 160, 80, 30);

        pnl2.add(lblto);
        pnl2.add(lblsubject);
        pnl2.add(lblmes);
        pnl2.add(txtto);
        pnl2.add(txtsubject);
        pnl2.add(scr);
        pnl2.add(btnsend);

        pnl1.add(lblusername);
        pnl1.add(lblpass);
        pnl1.add(txtuser);
        pnl1.add(txtpass);

        add(pnl1);
        add(pnl2);
        add(lblsendmail);
    }

    void send() {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", 587);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        String tk = "anhbao5cm@gmail.com";
        String mk = "uipyfagdfqkmmqea";

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(tk, mk);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(tk));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(txtto.getText().trim())// Gmail nguời nhận
            );
            message.setSubject(txtsubject.getText().trim());// Tiêu đề tin nhắn
            message.setText(txtmes.getText().trim());// Nội dung tin nhắn

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new bai1();
    }
}
