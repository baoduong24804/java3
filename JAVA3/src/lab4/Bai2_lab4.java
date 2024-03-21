/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anhba
 */
public class Bai2_lab4 extends JFrame {

    JPanel pnl1, pnl2, pnl3, pnl4, pnl5;
    JTable table;
    JLabel lblmasp, lbltensp, lbldvt, lbldongia, lblnhacc;
    JButton btnThem, btnXoa, btnSua;
    JTextField txtmasp, txttensp, txtdvt, txtdongia, txtnhacc;
    JComboBox<Object> cbodvt;

    String header[] = {"Ma SP", "Ten SP", "DVT", "Don gia", "Nha cung cap"};
    String[][] data = {
        {"SP001", "Dau goi dau HeadH", "Chai", "34000", "Unilevers"},
        {"SP002", "Dau goi dau HeadH", "Chai", "34000", "Unilevers"},
        {"SP003", "Dau goi dau HeadH", "Thung", "34000", "Unilevers"},
        {"SP004", "Dau goi dau HeadH", "Chai", "34000", "Unilevers"},
        {"SP005", "Dau goi dau HeadH", "Chai", "34000", "Unilevers"},
        {"SP006", "Dau goi dau HeadH", "Chai", "34000", "Unilevers"}
    };
    DefaultTableModel model = new DefaultTableModel(data, header);

    public Bai2_lab4(String title) throws HeadlessException {
        super(title);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setLayout(null);

        pnl1 = new JPanel();
        pnl1.setBounds(0, 0, 586, 200);
        pnl1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Danh sach san pham", TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", 1, 20), new Color(255, 0, 0)));
        pnl1.setBackground(Color.pink);

        table = new JTable();
        table.setModel(model);
        JScrollPane sc = new JScrollPane(table);
        sc.setPreferredSize(new Dimension(550, 150));
        pnl1.add(sc);

        pnl2 = new JPanel();
        pnl2.setLayout(null);
        pnl2.setBounds(0, 200, 586, 200);
        pnl2.setBackground(Color.yellow);

        pnl3 = new JPanel();
        pnl3.setBounds(40, 40, 200, 150);
        pnl3.setBackground(Color.yellow);
        lblmasp = new JLabel("  Ma sp");
        txtmasp = new JTextField();
        txtmasp.setPreferredSize(new Dimension(140, 20));

        pnl3.add(lblmasp);
        pnl3.add(txtmasp);

        lbltensp = new JLabel("Ten sp");
        txttensp = new JTextField();
        pnl3.add(lbltensp);
        txttensp.setPreferredSize(new Dimension(140, 20));
        pnl3.add(txttensp);
        lbldvt = new JLabel("     DVT");
        cbodvt = new JComboBox(new Object[]{"Chai", "Thung", "Day"});

        cbodvt.setPreferredSize(new Dimension(140, 20));
        pnl3.add(lbldvt);
        pnl3.add(cbodvt);

        pnl4 = new JPanel();
        pnl4.setBounds(350, 40, 200, 150);
        pnl4.setBackground(Color.yellow);

        lbldongia = new JLabel("Don gia");
        txtdongia = new JTextField();
        txtdongia.setPreferredSize(new Dimension(140, 20));
        pnl4.add(lbldongia);
        pnl4.add(txtdongia);
        lblnhacc = new JLabel("  Nha cc");
        txtnhacc = new JTextField();
        txtnhacc.setPreferredSize(new Dimension(140, 20));
        pnl4.add(lblnhacc);
        pnl4.add(txtnhacc);

        pnl2.add(pnl3);
        pnl2.add(pnl4);

        pnl5 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        pnl5.setBounds(0, 410, 586, 50);
        pnl5.setBackground(Color.green);

        btnThem = new JButton("Them sp");
        btnXoa = new JButton("Xoa sp");
        btnSua = new JButton("Dieu chinh thong tin");
        pnl5.add(btnThem);
        pnl5.add(btnSua);
        pnl5.add(btnXoa);

        add(pnl1);
        add(pnl2);
        add(pnl5);

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int r = table.getSelectedRow();
                if (r < 0) {
                    return;
                }
                txtmasp.setText(table.getValueAt(r, 0).toString());
                txttensp.setText(table.getValueAt(r, 1).toString());
                cbodvt.setSelectedItem(table.getValueAt(r, 2).toString());
                txtdongia.setText(table.getValueAt(r, 3).toString());
                txtnhacc.setText(table.getValueAt(r, 4).toString());

            }
        });

        btnThem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Vector dataRow = new Vector();
                dataRow.add(txtmasp.getText().trim());
                dataRow.add(txttensp.getText().trim());
                dataRow.add(cbodvt.getSelectedItem());
                dataRow.add(txtdongia.getText().trim());
                dataRow.add(txtnhacc.getText().trim());
                model.addRow(dataRow);
            }
        });

        btnXoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(null, "Chua chon");
                    return;
                }
                model.removeRow(row);
            }
        });

        btnSua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row < 0) {
                    return;
                }
                model.setValueAt(txttensp.getText().trim(), row, 1);
                model.setValueAt(cbodvt.getSelectedItem(), row, 2);
                model.setValueAt(txtdongia.getText().trim(), row, 3);
                model.setValueAt(txtnhacc.getText().trim(), row, 4);

            }
        });

    }

    public static void main(String[] args) {
        new Bai2_lab4("Bai 2").setVisible(true);
    }

}
