/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7;

import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;


/**
 *
 * @author anhba
 */
public class p2_bai2_sv_pbcu extends JFrame implements Runnable {

    String head[] = {""};
    JScrollPane scr;
    JButton btnsend, btnstar, btnxoa;
    static DefaultListModel<Object> model = new DefaultListModel<>();
    DataInputStream in;
    DataOutputStream out;
    JTextField txtport, txtmes;
    boolean send = false;
    boolean connect = false;
    ServerSocket sv = null;
    Socket socket = null;
    static JList<Object> list = null;
    static int mesindex = -1;
    static boolean dele = false;
    static String s = "";

    public p2_bai2_sv_pbcu() {
    }
    Thread t2 = new Thread(p2_bai2_sv_pbcu.this);

    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                sv = new ServerSocket(getPort());
                model.addElement("Dang doi client");
                socket = sv.accept();
                model.addElement("Ket noi voi client thanh cong");
                model.addElement("Xoa tin nhan trong 3 giay");
                btnstar.setEnabled(false);
                btnsend.setEnabled(false);
                btnxoa.setEnabled(false);
                for (int i = 3; i > 0; i--) {
                    try {
                        model.addElement(i);
                        TimeUnit.SECONDS.sleep(1);
                    } catch (Exception e) {
                    }
                }
                model.removeAllElements();
                btnsend.setEnabled(true);
                btnxoa.setEnabled(true);
                if (socket != null) {
                    t2.start();
                    //   model.addElement("Da bat ham doc");
                }

            } catch (Exception e) {
            }

        }
    });

    public p2_bai2_sv_pbcu(String title) throws HeadlessException {
        super(title);
        initComponets();
        //  delete.start();
    }

    void initComponets() {
        model.addElement("Nhap port de tao Server");
        setSize(500, 400);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblport = new JLabel("Port No.");
        lblport.setBounds(50, 20, 50, 20);
        txtport = new JTextField();
        txtport.setBounds(100, 20, 200, 20);
        btnstar = new JButton("Star");
        btnstar.setBounds(310, 20, 100, 20);

        JLabel lblchat = new JLabel("Chat");
        lblchat.setBounds(50, 260, 50, 20);
        txtmes = new JTextField();
        txtmes.setBounds(100, 260, 200, 20);
        btnsend = new JButton("Send");
        btnsend.setBounds(310, 260, 100, 20);
        btnxoa = new JButton("Delete");
        btnxoa.setBounds(310, 300, 100, 20);

        JLabel lblsv = new JLabel("Client");
        lblsv.setBounds(50, 50, 50, 20);
        list = new JList<>(model);
        scr = new JScrollPane(list);

        scr.setBounds(100, 50, 300, 200);

        ListDataListener l = new ListDataListener() {
            @Override
            public void intervalAdded(ListDataEvent e) {

                scr.getViewport().setViewPosition(new Point(0, scr.getViewport().getMaximumSize().height));

                //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void intervalRemoved(ListDataEvent e) {
                scr.getViewport().setViewPosition(new Point(0, scr.getViewport().getMaximumSize().height));
                //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void contentsChanged(ListDataEvent e) {

                //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };

        list.getModel().addListDataListener(l);
        add(lblport);
        add(lblchat);
        add(txtport);
        add(txtmes);
        add(btnstar);
        add(btnsend);
      //  add(btnxoa);
        add(lblsv);
        add(scr);
        txtport.setText("5555");
        txtmes.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
               //     chat();
                }
            }
        });
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                mesindex = list.getSelectedIndex();
            }
        });
        btnsend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chat();
            }
        });

        btnstar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createServer();

            }
        });

        btnxoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mesindex == -1) {
                    return;
                }
                dele = true;
                delete();

            }
        });

    }

    static void delete() {
        try {

            if (p2_bai2.dele == true && p2_bai2.mesindex != -1) {

                dele = p2_bai2.dele;
                mesindex = p2_bai2.mesindex;
                model.setElementAt("Tin nhan da bi client xoa", mesindex);
                p2_bai2.dele = dele = false;
                p2_bai2.mesindex = mesindex = -1;
                return;
            }
            if (mesindex != -1 && dele) {
                s = list.getModel().getElementAt(mesindex).toString();
                if (s.startsWith("Client:") || s.equals("Tin nhan da bi client xoa")) {
                    mesindex = -1;
                    dele = false;
                    return;
                }
                if (mesindex == -1 || !dele) {
                    return;
                }
                model.setElementAt("Server da xoa tin nhan", mesindex);
                //  p2_bai2.dele = dele = false;
                //  p2_bai2.mesindex = mesindex = -1;
            }

//        mesindex = -1;
            p2_bai2.delete();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    void chat() {
        if (socket != null && txtmes.getText().trim().length() > 0) {
            try {
                if (out == null) {
                    out = new DataOutputStream(socket.getOutputStream());
                }
                if (txtmes.getText().trim().isEmpty()) {
                    return;
                }
                out.writeUTF(txtmes.getText());
                out.flush();
             //   model.addElement("Server:" + txtmes.getText());
                txtmes.setText("");
                txtmes.requestFocus();
                //   model.addElement("Da chat");
            } catch (Exception ex) {
            }

        }
    }

    int getPort() {
        try {
            if (txtport.getText().trim().isEmpty()) {
                return -1;
            }
            return Integer.parseInt(txtport.getText().trim());
        } catch (Exception e) {
            return -1;
        }
    }

    void createServer() {

        if (getPort() == -1) {
            return;
        }

        try {
            t.start();
            if (socket == null) {
                return;
            }

        } catch (Exception e) {
            System.out.println("Loi ket noi");
        }

    }

    public static void main(String[] args) {
        new p2_bai21_pbcu("Client").setVisible(true);
        new p2_bai2_sv_pbcu("Server").setVisible(true);

    }

    @Override
    public void run() {
        try {

            while (true) {

                if (in == null) {
                    in = new DataInputStream(socket.getInputStream());
                }

                model.addElement("Client:" + in.readUTF());

            }

        } catch (Exception e) {
        }

    }
}
