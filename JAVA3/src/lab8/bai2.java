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
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
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
public class bai2 extends JFrame {

    JTextField txtuser, txtto, txtto2, txtsubject, txtfile, txtcc;
    JPasswordField txtpass;
    JTextArea txtmes;
    JButton btnsend, btnfile, btnadd, btnsend2;
    String filepath = "";
    JList<Object> list = new JList<>();
    DefaultListModel<Object> model = new DefaultListModel<>();

    public bai2() throws HeadlessException {
        initComponet();
        btnsend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                send();

            }
        });
        btnfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                file();

            }
        });
        btnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add();

            }
        });
        btnsend2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                send2();

            }
        });
        txtfile.setEditable(false);
        setVisible(true);
    }

    void initComponet() {
        setSize(800, 600);
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
        txtpass.setText("ckcozxcuxzomzcof");
        txtpass.setBounds(120, 80, 200, 20);

        JPanel pnl2 = new JPanel();
        pnl2.setLayout(null);
        pnl2.setBounds(20, 220, 450, 300);
        pnl2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Receive", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, new Font("Ariral", 1, 10)));

        JLabel lblto = new JLabel("To:");
        lblto.setBounds(50, 110, 100, 20);
        txtto = new JTextField();
        txtto.setText("hongntt8x@gmail.com");
        txtto.setBounds(120, 110, 200, 20);
        JLabel lblsubject = new JLabel("Subject:");
        lblsubject.setBounds(50, 140, 100, 20);
        txtsubject = new JTextField();
        txtsubject.setText("Test mail");
        txtsubject.setBounds(120, 140, 200, 20);
        JLabel lblmes = new JLabel("Message:");
        lblmes.setBounds(50, 180, 100, 20);
        txtmes = new JTextArea();
        JScrollPane scr = new JScrollPane(txtmes);
        scr.setBounds(120, 180, 200, 100);
        btnsend = new JButton("Send");
        btnsend.setBounds(330, 248, 80, 30);
        btnfile = new JButton("Attach");
        btnfile.setBounds(330, 200, 80, 30);
        JLabel lblfile = new JLabel("File:");
        lblfile.setBounds(50, 30, 100, 20);
        txtfile = new JTextField();
        txtfile.setBounds(120, 30, 200, 20);
        JLabel lblcc = new JLabel("CC:");
        lblcc.setBounds(50, 80, 100, 20);
        txtcc = new JTextField();
        txtcc.setText("uaowao@gmail.com");
        txtcc.setBounds(120, 80, 200, 20);
        list.setModel(model);
        JScrollPane srclist = new JScrollPane(list);
        srclist.setBounds(500, 88, 250, 300);
        btnadd = new JButton("Add");
        btnadd.setBounds(500, 430, 80, 30);
        btnsend2 = new JButton("Send");
        btnsend2.setBounds(600, 430, 80, 30);
        txtto2 = new JTextField("ngoczig11@gmail.com");
        txtto2.setBounds(500, 400, 250, 20);

        pnl2.add(lblto);
        pnl2.add(lblsubject);
        pnl2.add(lblmes);
        pnl2.add(txtto);
        pnl2.add(txtsubject);
        pnl2.add(scr);
        pnl2.add(btnsend);
        pnl2.add(btnfile);
        pnl2.add(lblfile);
        pnl2.add(txtfile);
        pnl2.add(lblcc);
        pnl2.add(txtcc);

        pnl1.add(lblusername);
        pnl1.add(lblpass);
        pnl1.add(txtuser);
        pnl1.add(txtpass);

        add(pnl1);
        add(pnl2);
        add(lblsendmail);
        add(srclist);
        add(btnadd);
        add(txtto2);
        add(btnsend2);
        //duylephuc48.it@gmail.com
        //jfbdzobyvlkzlszm
    }

    void send2() {
        for (int i = 0; i < model.getSize(); i++) {
            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", 587);
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true"); //TLS

            String tk = txtuser.getText().trim();
            String mk = new String(txtpass.getPassword()).trim();

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
                        InternetAddress.parse(model.getElementAt(i).toString())
                );
                if (!txtcc.getText().trim().isEmpty()) {
                    message.addRecipients(
                            Message.RecipientType.CC,
                            InternetAddress.parse(txtcc.getText().trim()));
                }

                message.setSubject(txtsubject.getText().trim());
                message.setText(txtmes.getText().trim());

                MimeBodyPart contentPath = new MimeBodyPart();
                contentPath.setContent(txtmes.getText(), "text/html; charset=utf-8");
                Multipart mp = new MimeMultipart();
                mp.addBodyPart(contentPath);
                if (filepath != "") {
                    MimeBodyPart attach = new MimeBodyPart();
                    FileDataSource fds = new FileDataSource(filepath);
                    attach.setDataHandler(new DataHandler(fds));
                    attach.setFileName(fds.getName());
                    mp.addBodyPart(attach);
                }
                message.setContent(mp);

                Transport.send(message);

                System.out.println("Done: " + (i + 1));
                if (i >= model.size() - 1) {
                    System.out.println("Done all");
                }

            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }

    void add() {
        model.addElement(txtto2.getText().trim());

    }

    void file() {
        JFileChooser jf = new JFileChooser();
        int i = jf.showOpenDialog(null);
        if (i == JFileChooser.APPROVE_OPTION) {
            txtfile.setText(jf.getSelectedFile().getName());
            filepath = jf.getSelectedFile().getPath();
        }
    }

    void send() {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", 587);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        String tk = txtuser.getText().trim();
        String mk = new String(txtpass.getPassword()).trim();

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
                    InternetAddress.parse(txtto.getText().trim())
            );
            if (!txtcc.getText().trim().isEmpty()) {
                message.addRecipients(
                        Message.RecipientType.CC,
                        InternetAddress.parse(txtcc.getText().trim()));
            }

            message.setSubject(txtsubject.getText().trim());
            message.setText(txtmes.getText().trim());

            MimeBodyPart contentPath = new MimeBodyPart();
            contentPath.setContent(txtmes.getText(), "text/html; charset=utf-8");
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(contentPath);
            if (filepath != "") {
                MimeBodyPart attach = new MimeBodyPart();
                FileDataSource fds = new FileDataSource(filepath);
                attach.setDataHandler(new DataHandler(fds));
                attach.setFileName(fds.getName());
                mp.addBodyPart(attach);
            }
            message.setContent(mp);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new bai2();
    }
}
