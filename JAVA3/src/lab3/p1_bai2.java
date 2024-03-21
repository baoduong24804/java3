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
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author anhba
 */
public class p1_bai2 extends JFrame implements ActionListener {

    JLabel lblHo, lblTen, lblBidanh, lblMatma, lblQue, lblSothich, lblGhichu, x, xx;
    JTextField txtHo, txtTen, txtBidanh;
    JPasswordField txtMatma;
    JRadioButton rNam, rNu, rKxd;
    JComboBox<Object> cboQue;
    JCheckBox chkAnchoi, chkNhaymua, chkNgunghi;
    JTextArea txtGhichu;
    JScrollPane scr;
    JButton btnOk, btnReset, btnExit;
    JPanel pnl1, pnl2, pnl3, pnl4;
    
    
        @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Exit")){
        System.exit(0);
        }
        
        if(e.getActionCommand().equals("Reset"))
        {
        txtHo.setText("");
        txtTen.setText("");
        txtBidanh.setText("");
        txtMatma.setText("");
        rKxd.setSelected(true);
        chkAnchoi.setSelected(true);
        chkNgunghi.setSelected(true);
        chkNhaymua.setSelected(false);
        txtGhichu.setText("");
        cboQue.setSelectedIndex(0);
        }
        
        
        if(e.getActionCommand().equals("OK")){
         if (txtHo.getText().trim().isEmpty() || txtTen.getText().trim().isEmpty() || txtBidanh.getText().trim().isEmpty()
                    || new String(txtMatma.getPassword()).trim().isEmpty()) {
                return;
            }

            String s = "";
            s += "\nHo: " + txtHo.getText();
            s += "\nTen: " + txtTen.getText();
            s += "\nBi danh:" + txtBidanh.getText();
            s += "\nMat ma: " + new String(txtMatma.getPassword());
            if (rNu.isSelected()) {
                s += "\n" + "Gioi tinh: " + rNu.getText();
            }
            if (rNam.isSelected()) {
                s += "\n" + "Gioi tinh: " + rNam.getText();
            }
            if (rKxd.isSelected()) {
                s += "\n" + "Gioi tinh: " + rKxd.getText();
            }
            s += "\nQue quan: " + cboQue.getSelectedItem();

            if (chkAnchoi.isSelected() || chkNgunghi.isSelected() || chkNhaymua.isSelected()) {
                s += "\n" + "So thich: ";
                if (chkAnchoi.isSelected()) {
                    s += chkAnchoi.getText() + " ";
                }
                if (chkNgunghi.isSelected()) {
                    s += chkNgunghi.getText() + " ";
                }
                if (chkNhaymua.isSelected()) {
                    s += chkNhaymua.getText() + " ";
                }
            }
            
            if(!txtGhichu.getText().trim().isEmpty()){
            s+="\nGhi chu: "+ txtGhichu.getText();
            }
JOptionPane.showMessageDialog(this, s);
        }
        
    //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public p1_bai2() throws HeadlessException {
        setSize(600, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
//        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        setLayout(null);

        pnl1 = new JPanel();
        pnl1.setBounds(0, 0, 585, 100);
        //   pnl1.setBackground(new Color(234, 183, 132));
        pnl1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.green), "Ho ten", TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", 1, 18), new Color(255, 0, 0)));
        pnl1.setBackground(new Color(204, 255, 204));
        FlowLayout ff = new FlowLayout(FlowLayout.CENTER, 20, 10);
        pnl1.setLayout(ff);
        lblHo = new JLabel("Ho:        ");
        txtHo = new JTextField("Dương");
        txtHo.setPreferredSize(new Dimension(200, 20));

        lblTen = new JLabel("Ten:     ");
        lblTen.setSize(new Dimension(200, 20));
        txtTen = new JTextField("Bảo");
        txtTen.setPreferredSize(new Dimension(200, 20));

        lblBidanh = new JLabel("Bi danh:");
        lblBidanh.setSize(new Dimension(200, 20));
        txtBidanh = new JTextField("Tybao");
        txtBidanh.setPreferredSize(new Dimension(200, 20));

        lblMatma = new JLabel("Mat ma:");
        lblMatma.setSize(new Dimension(200, 20));
        txtMatma = new JPasswordField("123");
        txtMatma.setPreferredSize(new Dimension(200, 20));

        pnl1.add(lblHo);
        pnl1.add(txtHo);

        pnl1.add(lblTen);
        pnl1.add(txtTen);

        pnl1.add(lblBidanh);
        pnl1.add(txtBidanh);

        pnl1.add(lblMatma);
        pnl1.add(txtMatma);

        getContentPane().add(pnl1);

        pnl2 = new JPanel(new BorderLayout());
        pnl2.setBounds(0, 110, 585, 80);
        pnl2.setBackground(new Color(255, 255, 153));
        FlowLayout f2 = new FlowLayout(FlowLayout.CENTER, 20, 10);
        pnl2.setLayout(f2);
        pnl2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.green), "Gioi tinh", TitledBorder.LEFT,
                TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", 1, 18), new Color(0, 0, 255)));
        rNu = new JRadioButton("Nu");
        rNu.setBackground(new Color(255, 255, 153));
        rNam = new JRadioButton("Nam");
        rNam.setBackground(new Color(255, 255, 153));
        rKxd = new JRadioButton("Khong xac dinh");
        rKxd.setBackground(new Color(255, 255, 153));
        rKxd.setSelected(true);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rNu);
        bg.add(rNam);
        bg.add(rKxd);

        pnl2.add(rNu);
        pnl2.add(rNam);
        pnl2.add(rKxd);

        getContentPane().add(pnl2);

        pnl3 = new JPanel();
        pnl3.setBounds(0, 200, 585, 250);
        pnl3.setBackground(new Color(255, 204, 204));
        pnl3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.green), "Thong tin khac", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION,
                new Font("Segoe UI", 1, 18), new Color(0, 0, 0)));

        FlowLayout flow = new FlowLayout(FlowLayout.LEFT, 20, 10);
        pnl3.setLayout(flow);

        lblQue = new JLabel("Que quan:");
        cboQue = new JComboBox<>(new Object[]{"Long An", "Ninh Thuan", "TP.HCM", "Ha Noi"});
        cboQue.setSelectedIndex(0);
        cboQue.setPreferredSize(new Dimension(200, 20));
        x = new JLabel("                                                                      ");
        lblSothich = new JLabel("So thich:");
        chkAnchoi = new JCheckBox("An choi");
        chkAnchoi.setSelected(true);
        chkNgunghi = new JCheckBox("Ngu nghi");
        chkNgunghi.setSelected(true);
        chkNhaymua = new JCheckBox("Nhay mua");
        xx = new JLabel("                                               ");

        txtGhichu = new JTextArea(5, 20);
        txtGhichu.setText("hi");

        scr = new JScrollPane(txtGhichu);

        lblGhichu = new JLabel("Ghi chu:                "
                + "                                     "
                + "                                     "
                + "                                     ");

        pnl3.add(lblQue);
        pnl3.add(cboQue);
        pnl3.add(x);
        pnl3.add(lblSothich);
        pnl3.add(chkAnchoi);
        pnl3.add(chkNgunghi);
        pnl3.add(chkNhaymua);

        pnl3.add(xx);
        pnl3.add(lblGhichu);
        pnl3.add(scr);

        getContentPane().add(pnl3);

        pnl4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnl4.setBounds(0, 460, 585, 50);
        btnOk = new JButton("OK");
        btnReset = new JButton("Reset");
        btnExit = new JButton("Exit");
        pnl4.add(btnOk);
        pnl4.add(btnReset);
        pnl4.add(btnExit);
        getContentPane().add(pnl4);
        btnExit.addActionListener(this);
        btnOk.addActionListener(this);
        btnReset.addActionListener(this);

    }

    public static void main(String[] args) {
        new p1_bai2().setVisible(true);
    }



}
