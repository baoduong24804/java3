/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author anhba
 */
public class Bai2 extends JFrame {

    JTextField txtMasv, txtHoten, txtEmail, txtSodt;
    JRadioButton rNam, rNu;
    JTextArea txtDiachi;
    JLabel lblMasv, lblHoten, lblEmail, lblSodt, lblGioitinh, lblDiachi, x;
    JButton btnDe, btnUp, btnNew, btnSave, btnleft, btnleft2, btnright, btnright2, btnSearch;
    ArrayList<Students> list = new ArrayList<>();
    int current = 0;
    String user = "sa";
    String pass = "123";
    String url = "jdbc:sqlserver://localhost:1433;databaseName=qlsv";

    public Bai2() {
    }

    DefaultTableModel model = new DefaultTableModel();

    public Bai2(String title) throws HeadlessException {
        super(title);
        initComponents();
        Sk();
        loadDataToArray();
        showA();
        setVisible(true);

    }

    void showA() {
        if (list.size() <= 0) {
            add();
            return;
        }
        current = 0;
        Display(0);
    }

    void Display(int i) {
        Students sv = list.get(i);
        txtDiachi.setText(sv.Diachi);
        txtHoten.setText(sv.Hoten);
        txtMasv.setText(sv.Masv);
        txtEmail.setText(sv.Email);
        txtSodt.setText(sv.Sdt);
        boolean gt = sv.Gioitinh;
        if (gt == true) {
            rNam.setSelected(true);
            return;
        }
        rNu.setSelected(true);

    }

    void loadDataToArray() {
        try {
            list.removeAll(list);
            Connection con = Ketnoi.Ketnoisql.conn();
            String sql = "Select * from Student";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Students sv = new Students(rs.getString("Masv"), rs.getString("Hoten"), rs.getString("Email"), rs.getString("Sdt"), rs.getBoolean("Gioitinh"), rs.getString("Diachi"));
                list.add(sv);
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //  showA();
    }

    void abtnleft() {
        current = 0;
        Display(current);
    }

    void abtnleft2() {
        current--;
        if (current == -1) {
            JOptionPane.showMessageDialog(null, "Dang o dau sach");
            current = 0;
            return;
        }
        Display(current);
    }

    void abtnright() {
        current++;
        if (current >= list.size()) {
            JOptionPane.showMessageDialog(null, "Dang o cuoi");
            current = list.size() - 1;
            return;
        }
        Display(current);
    }

    void abtnright2() {
        current = list.size() - 1;
        Display(current);
    }

    void Sk() {
        btnleft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abtnleft();
            }
        });
        btnleft2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abtnleft2();
            }
        });
        btnright.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abtnright();
            }
        });
        btnright2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abtnright2();
            }
        });

        btnDe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                de();
                showA();
            }
        });
        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add();
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sa();
                showA();
            }
        });
        btnUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                up();
                showA();
            }
        });
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search();

            }
        });
    }

    void search() {
        try {
            Connection con = Ketnoi.Ketnoisql.conn();
            String sql = "Select * from STUDENT where Masv = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            String input = JOptionPane.showInputDialog(null, "Nhap MaSV");
            pstm.setString(1, input);
            ResultSet rs = pstm.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "Khong tim thay");
                return;
            }
            //     System.out.println("haha");
            //  rs.next();
            String masv = rs.getString("Masv");
            String hoten = rs.getString("Hoten");
            String email = rs.getString("Email");
            String sodt = rs.getString("Sdt");
            boolean gt = rs.getBoolean("Gioitinh");
            String diachi = rs.getString("Diachi");

            Students sv = new Students(masv, hoten, email, sodt, gt, diachi);

            txtDiachi.setText(sv.Diachi);
            txtHoten.setText(sv.Hoten);
            txtMasv.setText(sv.Masv);
            txtEmail.setText(sv.Email);
            txtSodt.setText(sv.Sdt);
            boolean gtt = sv.Gioitinh;
            if (gtt == true) {
                rNam.setSelected(true);

            } else {
                rNu.setSelected(true);
            }
            JOptionPane.showMessageDialog(null, "Da tim thay");
//            System.out.println(sv.toString());

            //   System.out.println("hihi");
            pstm.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    void de() {
        if (txtMasv.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nhap ma sv");
            txtMasv.requestFocus();
            return;
        }
       
        //   System.out.println("Delete");
        loadDataToArray();
    }

    void up() {
        int i = 0;
        if (txtMasv.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nhap ma sv");
            txtMasv.requestFocus();
            return;
        }
        loadDataToArray();
        for (Students sv : list) {

            if (sv.getMasv().equalsIgnoreCase(txtMasv.getText().trim())) {
                i = 1;
            }
        }
        if (i == 0) {
            JOptionPane.showMessageDialog(null, "Khong co ma nv: " + txtMasv.getText());
            return;
        }
        try {
            Connection con = Ketnoi.Ketnoisql.conn();
            String sql = "Update Student  set Hoten = ?,Email=?,Sdt=?,Diachi=?,Gioitinh=? where Masv =?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, txtHoten.getText());
            pstm.setString(2, txtEmail.getText());
            pstm.setString(3, txtSodt.getText());
            pstm.setString(4, txtDiachi.getText());
            boolean gt = rNam.isSelected() ? true : false;
            pstm.setBoolean(5, gt);
            pstm.setString(6, txtMasv.getText());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update thanh cong");
            pstm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //   System.out.println("Update");
        loadDataToArray();
    }

    void sa() {
        if (txtMasv.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nhap ma sv");
            txtMasv.requestFocus();
            return;
        }
        loadDataToArray();
        for (Students sv : list) {
            if (sv.Masv.equalsIgnoreCase(txtMasv.getText().trim())) {
                JOptionPane.showMessageDialog(null, "Da co ma sv");
                return;
            }
        }
        try {
            Connection con = Ketnoi.Ketnoisql.conn();
            String sql = "Insert into Student values(?,?,?,?,?,?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, txtMasv.getText());
            pstm.setString(2, txtHoten.getText());
            pstm.setString(3, txtEmail.getText());
            pstm.setString(4, txtSodt.getText());
            boolean gt = rNam.isSelected() ? true : false;
            pstm.setBoolean(5, gt);
            pstm.setString(6, txtDiachi.getText());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Save thanh cong");
            pstm.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        loadDataToArray();
    }

    void add() {

        txtMasv.setText("");
        txtDiachi.setText("");
        txtEmail.setText("");
        txtSodt.setText("");
        txtHoten.setText("");
        rNam.setSelected(true);
        txtMasv.requestFocus();
    }

    void initComponents() {
        setSize(600, 430);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setLayout(null);
        model.setColumnIdentifiers(new Object[]{
            "MaSV", "Ho ten", "Email", "So DT", "Gioi tinh", "Dia chi", "Hinh"
        });
        model.setRowCount(9);

        JLabel lbl = new JLabel("Quản Lí Sinh Viên");
        lbl.setBounds(220, 5, 400, 50);
        lbl.setFont(new Font("Arial", 1, 20));
        lbl.setForeground(Color.blue);
        getContentPane().add(lbl);
        // panel 1
        JPanel pnl1 = new JPanel();
        pnl1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 15));
        pnl1.setBounds(90, 50, 250, 300);
        //     pnl1.setBackground(Color.lightGray);

        lblMasv = new JLabel("MaSVien:");
        txtMasv = new JTextField();
        txtMasv.setPreferredSize(new Dimension(150, 20));

        lblHoten = new JLabel("    Ho ten:");
        txtHoten = new JTextField();
        txtHoten.setPreferredSize(new Dimension(150, 20));

        lblEmail = new JLabel("      Email:");
        txtEmail = new JTextField();
        txtEmail.setPreferredSize(new Dimension(150, 20));

        lblSodt = new JLabel("     So DT:");
        txtSodt = new JTextField();
        txtSodt.setPreferredSize(new Dimension(150, 20));

        lblGioitinh = new JLabel(" Gioi tinh:");
        rNu = new JRadioButton("Nu");
        rNam = new JRadioButton("Nam");
        rNam.setSelected(true);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rNu);
        bg.add(rNam);

        x = new JLabel("         ");
        lblDiachi = new JLabel("    Dia chi:");

        txtDiachi = new JTextArea(5, 15);

        JScrollPane scr = new JScrollPane(txtDiachi);

        pnl1.add(lblMasv);
        pnl1.add(txtMasv);

        pnl1.add(lblHoten);
        pnl1.add(txtHoten);

        pnl1.add(lblEmail);
        pnl1.add(txtEmail);

        pnl1.add(lblSodt);
        pnl1.add(txtSodt);

        pnl1.add(lblGioitinh);
        pnl1.add(rNam);
        pnl1.add(rNu);

        pnl1.add(x);
        pnl1.add(lblDiachi);
        pnl1.add(scr);

        // panel 2
        JPanel pnl2 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        //    pnl2.setBackground(Color.lightGray);
        // panel 3
        JPanel pnl3 = new JPanel();
        pnl3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        //    pnl3.setBackground(Color.red);
        pnl3.setBounds(350, 50, 150, 250);
        //    pnl3.setBackground(Color.lightGray);

        btnDe = new JButton("Delete", new ImageIcon("src\\Icons\\Delete.png"));
        btnDe.setPreferredSize(new Dimension(120, 40));
        btnNew = new JButton("Add", new ImageIcon("src\\Icons\\Add.png"));
        btnNew.setPreferredSize(new Dimension(120, 40));
        btnSave = new JButton("Save", new ImageIcon("src\\Icons\\Save.png"));
        btnSave.setPreferredSize(new Dimension(120, 40));
        btnUp = new JButton("Update", new ImageIcon("src\\Icons\\Edit.png"));
        btnUp.setPreferredSize(new Dimension(120, 40));
        btnSearch = new JButton("Search", new ImageIcon("src\\Icons\\Search.png"));
        btnSearch.setPreferredSize(new Dimension(120, 40));

        pnl3.add(btnNew);
        pnl3.add(btnSave);
        pnl3.add(btnDe);
        pnl3.add(btnUp);
        pnl3.add(btnSearch);

        // panel 3
        JPanel pnl4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnl4.setBounds(40, 350, 500, 50);
        //     pnl4.setBackground(Color.lightGray);
        btnleft = new JButton("|<");
        btnleft2 = new JButton("<<");
        btnright = new JButton(">>");
        btnright2 = new JButton(">|");
        //  btnleft.setPreferredSize(new Dimension(120, 40));

        pnl4.add(btnleft);
        pnl4.add(btnleft2);

        pnl4.add(btnright);
        pnl4.add(btnright2);

        getContentPane().add(pnl1);
        getContentPane().add(pnl2);
        getContentPane().add(pnl3);
        getContentPane().add(pnl4);

    }

    public static void main(String[] args) {
        new Bai2("Bai2");
    }
}
