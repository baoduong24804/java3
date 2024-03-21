/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.PrintWriter;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import static javax.swing.KeyStroke.getKeyStroke;

/**
 *
 * @author anhba
 */
public class Bai1 extends JFrame {

    JMenuBar jmenubar;
    JMenu jmenufile, jmenucolor, jmenusystem;
    JMenuItem jmenuitemnew, jmenuitemopen, jmenuitemsave, jmenuitemtextcolor, jmenuitemabout, jmenuitemexit;
    JRadioButtonMenuItem jrdored, jrdogreen, jrdoblue, jrdowhite;
    JToolBar jtoolbar;
    JTextField txt;
    JScrollPane jscrpane;
    JEditorPane txteditPane;
    JButton btnfile, btnuser, btnexit;

    public Bai1(String title) throws HeadlessException {
        super(title);
        setSize(600, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setLayout(null);

        jmenubar = new JMenuBar();// thanh task bar menu
        jmenubar.setSize(600, 30);

        jmenufile = new JMenu();
        jmenufile.setText("File");
        jmenuitemnew = new JMenuItem("New", new ImageIcon("src//Icons//Add.png"));// item tren thanh task bar menu
        jmenuitemnew.setMnemonic('N');// set nút mở nhanh
        //  jmenuitemnew.setToolTipText("");// set thông báo khi rê chuột vào
        jmenuitemnew.setAccelerator(getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));// set tổ hợp phím mở nhanh
        jmenuitemnew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             txt.setText("");
             txteditPane.setText("");
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });

        jmenuitemopen = new JMenuItem("Open", new ImageIcon("src//Icons//Open folder.png"));// item tren thanh task bar menu
        jmenuitemopen.setMnemonic('O');// set nút mở nhanh
        //    jmenuitemopen.setToolTipText("New");// set thông báo khi rê chuột vào
        jmenuitemopen.setAccelerator(getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));// set tổ hợp phím mở nhanh
        jmenuitemopen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             abtnFile();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });

        jmenuitemsave = new JMenuItem("Save", new ImageIcon("src//Icons//Save.png"));// item tren thanh task bar menu
        jmenuitemsave.setMnemonic('S');// set nút mở nhanh
        // jmenuitemsave.setToolTipText("New");// set thông báo khi rê chuột vào
        jmenuitemsave.setAccelerator(getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));// set tổ hợp phím mở nhanh
        jmenuitemsave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              abtnSave();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });

        jmenucolor = new JMenu();
        jmenucolor.setText("Color");

        jrdored = new JRadioButtonMenuItem("Red");
        jrdored.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rRed();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });

        jrdogreen = new JRadioButtonMenuItem("Green");
        jrdogreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             rGreen();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });

        jrdoblue = new JRadioButtonMenuItem("Blue");
        jrdoblue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               rBlue();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });

        jrdowhite = new JRadioButtonMenuItem("White");
        jrdowhite.setSelected(true);
        jrdowhite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rWhite();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });

        jmenuitemtextcolor = new JMenuItem("Text color");
        jmenuitemtextcolor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abtncolor();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });



        jmenusystem = new JMenu();
        jmenusystem.setText("System");
        jmenuitemabout = new JMenuItem("About us");
        jmenuitemabout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               showAb();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });

        jmenuitemexit = new JMenuItem("Exit");
        jmenuitemexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });

        jmenufile.add(jmenuitemnew);
        jmenufile.add(jmenuitemopen);
        jmenufile.add(jmenuitemsave);

        jmenucolor.add(jrdowhite);
        jmenucolor.add(jrdored);
        jmenucolor.add(jrdogreen);
        jmenucolor.add(jrdoblue);

        jmenusystem.add(jmenuitemabout);
        jmenusystem.add(jmenuitemexit);

        jmenucolor.add(jmenuitemtextcolor);
        ButtonGroup br = new ButtonGroup();
        br.add(jrdoblue);
        br.add(jrdowhite);
        br.add(jrdored);
        br.add(jrdogreen);

        jmenubar.add(jmenufile);
        jmenubar.add(jmenucolor);
        jmenubar.add(jmenusystem);

        jtoolbar = new JToolBar();
        jtoolbar.setBounds(0, 30, 600, 50);

        btnfile = new JButton();
        btnfile.setIcon(new ImageIcon("src//Icons//Add.png"));
        btnfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
             
            }
        });
        btnuser = new JButton();
        btnuser.setIcon(new ImageIcon("src//Icons//User.png"));
        btnuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });
        btnexit = new JButton();
        btnexit.setIcon(new ImageIcon("src//Icons//Stop.png"));
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOptionPane.showMessageDialog(null, "btn3");
            }
        });

        txteditPane = new JEditorPane();
        txteditPane.setBorder(BorderFactory.createLineBorder(Color.black));
        jscrpane = new JScrollPane(txteditPane);
        jscrpane.setBounds(10, 120, 565, 200);
        add(jscrpane);

        txt = new JTextField();
        txt.setBounds(10, 350, 565, 50);
        txt.setFont(new Font("Arial", 1, 20));
        txt.setHorizontalAlignment(JLabel.CENTER);
        txt.setText("FPOLY");

        add(txt);
        jtoolbar.add(btnfile);
        jtoolbar.add(btnuser);
        jtoolbar.add(btnexit);

        add(jmenubar);
        add(jtoolbar);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Bai1("Bai1");
    }

    void abtnFile() {
        JFileChooser fchooser = new JFileChooser();
        int result = fchooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                txteditPane.setPage("file:///" + fchooser.getSelectedFile().getPath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void rRed() {
        txt.setBackground(Color.red);
    }

    void rBlue() {
        txt.setBackground(Color.blue);
    }

    void rGreen() {
        txt.setBackground(Color.green);
    }

    void rWhite() {
        txt.setBackground(Color.white);
    }

    void abtnSave() {
        JFileChooser fc = new JFileChooser();
        int result = fc.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fname = fc.getSelectedFile();
            try {
                PrintWriter pw = new PrintWriter(fname);
                pw.println(txteditPane.getText());
                pw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void abtncolor() {
        Color c = JColorChooser.showDialog(null, "Chon mau chua", Color.white);
        txt.setForeground(c);
    }

    void showAb() {
        String str = "Program Demo Menu";
        str += "\nAuthor: tybao";
        JOptionPane.showMessageDialog(null, str, "Gioi thieu", JOptionPane.INFORMATION_MESSAGE);
    }

}
