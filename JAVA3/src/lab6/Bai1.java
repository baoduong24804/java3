/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author anhba
 */
public class Bai1 extends JFrame {

    JButton btnsearch, btnexit, btndelete;
    JLabel lbltitle;
    JTextField txttitle;
    private String header[] = {"Id", "Title", "Price"};
    private DefaultTableModel tblModel = new DefaultTableModel(header, 0);
    JTable tbl;
    int index = 99;

    public Bai1() throws HeadlessException {
        initComponets();
        btndelete.setEnabled(false);

    }

    void search() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = Ketnoi.Ketnoisql.conn();
// Câu lệnh xem dữ liệu
            String sql = "select * from Books ";
// Nếu tìm kiếm theo title
            if (txttitle.getText().length() > 0) {
                sql = sql + " where title like '%" + txttitle.getText() + "%'";
            }
// Tạo đối tượng thực thi câu lệnh Select
            st = conn.createStatement();
// Thực thi
            rs = st.executeQuery(sql);
            Vector data = null;
            tblModel.setRowCount(0);
// Nếu sách không tồn tại
            if (rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "The book is not available!");
                return;
            }
// Trong khi chưa hết dữ liệu
            while (rs.next()) {
                data = new Vector();
                data.add(rs.getInt("id"));
                data.add(rs.getString("title"));
                data.add(rs.getString("price"));
                // Thêm một dòng vào table model
                tblModel.addRow(data);
            }
            tbl.setModel(tblModel); // Thêm dữ liệu vào table
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    void rf() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = Ketnoi.Ketnoisql.conn();
// Câu lệnh xem dữ liệu
            String sql = "select * from Books ";
// Nếu tìm kiếm theo title

// Tạo đối tượng thực thi câu lệnh Select
            st = conn.createStatement();
// Thực thi
            rs = st.executeQuery(sql);
            Vector data = null;
            tblModel.setRowCount(0);
// Nếu sách không tồn tại
            if (rs.isBeforeFirst() == false) {
                //   JOptionPane.showMessageDialog(this, "The book is not available!");
                return;
            }
// Trong khi chưa hết dữ liệu
            while (rs.next()) {
                data = new Vector();
                data.add(rs.getInt("id"));
                data.add(rs.getString("title"));
                data.add(rs.getString("price"));
                // Thêm một dòng vào table model
                tblModel.addRow(data);
            }
            tbl.setModel(tblModel); // Thêm dữ liệu vào table
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    int click() {
        if (index == 99) {
            return -1;
        }

        return index;

    }

    void de() {
        int ret = JOptionPane.showConfirmDialog(this, "Do you want to delete?", "Confirm",
                JOptionPane.YES_NO_OPTION);
        if (ret != JOptionPane.YES_OPTION) {
            return;
        }
        Connection c = null;
        PreparedStatement ps = null;
        try {
            if (click() == -1 || click() == 99) {
                return;
            }
            c = Ketnoi.Ketnoisql.conn();
            ps = c.prepareStatement("Delete From Books where id = ?");
            int row = Integer.parseInt(tbl.getValueAt(click(), 0).toString());
            ps.setInt(1, row); //giá trị của cột đầu tiên tại dòng được chọn trong table
            ret = ps.executeUpdate();
            if (ret != -1) {
                JOptionPane.showMessageDialog(this, "This book has been deleted");
                rf();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (c != null) {
                    c.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }
    }

    void initComponets() {
        setSize(600, 450);
        setDefaultCloseOperation(3);

        setLocationRelativeTo(null);
        setLayout(null);

        JPanel pnl1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        pnl1.setBounds(20, 20, 400, 100);
        pnl1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Fillter"));
        lbltitle = new JLabel("Title");
        txttitle = new JTextField();
        txttitle.setPreferredSize(new Dimension(200, 20));
        pnl1.add(lbltitle);
        pnl1.add(txttitle);

        JPanel pnl2 = new JPanel();
        pnl2.setBounds(300, 40, 400, 100);
        btnsearch = new JButton("Search");
        pnl2.add(btnsearch);
        btnexit = new JButton("Exit");
        pnl2.add(btnexit);

        JPanel pnl3 = new JPanel();
        pnl3.setBounds(20, 150, 545, 200);
        tbl = new JTable();
        JScrollPane scr = new JScrollPane(tbl);
        scr.setPreferredSize(new Dimension(545, 150));
        // pnl3.setBorder(BorderFactory.createLineBorder(Color.black));
        pnl3.add(scr);

        JPanel pnl4 = new JPanel();
        pnl4.setBounds(480, 350, 100, 50);
        btndelete = new JButton("Delete");
        pnl4.add(btndelete);

        tbl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                index = tbl.getSelectedRow();
                btndelete.setEnabled(true);
                //     System.out.println(tbl.getValueAt(index, 0));
            }
        });

        btndelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                de();
                btndelete.setEnabled(false);
            }
        });

        btnsearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                search();
                return;

            }
        });

        btnexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });

        add(pnl1);
        add(pnl2);
        add(pnl3);
        add(pnl4);
    }

    public static void main(String[] args) {
        new Bai1().setVisible(true);
    }
}
