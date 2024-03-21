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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author anhba
 */
public class Bai2 extends JFrame {

    String head[] = {"Name", "Standard"};
    DefaultTableModel model = new DefaultTableModel(head, 4);
    JTable tbl;
    JScrollPane scr, scr2;
    JLabel lblname, lbladdress, lblparentname, lblcontactno, lblstandard, lblfees;
    JTextField txtname, txtparentname, txtcontactno;
    JTextArea txtaddress;
    JComboBox<Object> cbostandard, cbofees;
    JButton btnnew, btninsert, btnedit, btnupdate, btnnext, btnpre, btndelete, btnexit;
    boolean addNew = false;
    boolean fill = false;
    Vector data = new Vector();
    Vector header = new Vector();
    Vector col = new Vector();
    Connection con = null;
    PreparedStatement pstDetails = null;
    PreparedStatement pstInsert = null;
    PreparedStatement pstDelete = null;
    PreparedStatement pstUpdate = null;
    String sqlInsert = "Insert into Students ([Name],Address,ParentName,Phone,standard) values(?,?,?,?,?)";
    String sqlDelete = "Delete from Students where Name=?";
    String sqlUpdate = "Update Students set Address=?, ParentName=?,Phone=? ,Standard=? where Name=?";
    ResultSet rts;

    public Bai2(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(3);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        try {
            con = Ketnoi.Ketnoisql.conn();
            pstInsert = con.prepareStatement(sqlInsert);
            pstUpdate = con.prepareStatement(sqlUpdate);
            pstDelete = con.prepareStatement(sqlDelete);
            pstDetails = con.prepareStatement("select * from Students", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rts = pstDetails.executeQuery();
            // JOptionPane.showMessageDialog(null, "Connection Database Successful!");
        } catch (Exception e) {
        }

        JPanel pnl1 = new JPanel();
        pnl1.setBounds(20, 20, 250, 420);
        pnl1.setBorder(BorderFactory.createLineBorder(Color.black));
        pnl1.setLayout(null);
        //   pnl1.setBackground(Color.red);
        tbl = new JTable(model);
        scr = new JScrollPane(tbl);
        scr.setBounds(0, 0, 251, 200);
        pnl1.add(scr);

        JPanel pnl2 = new JPanel();
        pnl2.setBounds(300, 20, 260, 140);
        //    pnl2.setBorder(BorderFactory.createLineBorder(Color.black));
        pnl2.setLayout(null);
        lblname = new JLabel("Name:");
        lblname.setBounds(50, 10, 100, 20);
        txtname = new JTextField();
        txtname.setBounds(94, 10, 150, 20);
        pnl2.add(lblname);
        pnl2.add(txtname);
        lbladdress = new JLabel("Address:");
        lbladdress.setBounds(35, 50, 100, 20);
        txtaddress = new JTextArea();
        scr2 = new JScrollPane(txtaddress);
        scr2.setBounds(94, 50, 150, 80);

        pnl2.add(lbladdress);
        pnl2.add(scr2);

        JPanel pnl3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        pnl3.setBounds(300, 160, 260, 140);
        //   pnl3.setBorder(BorderFactory.createLineBorder(Color.black));
        lblparentname = new JLabel("ParentName:");
        txtparentname = new JTextField();
        txtparentname.setPreferredSize(new Dimension(150, 20));

        lblcontactno = new JLabel("   ContactNo:");
        txtcontactno = new JTextField();
        txtcontactno.setPreferredSize(new Dimension(150, 20));

        lblstandard = new JLabel("      Standard:");
        cbostandard = new JComboBox<>();
        cbostandard.setPreferredSize(new Dimension(150, 20));

        lblfees = new JLabel("             Fees:");
        cbofees = new JComboBox<>();
        cbofees.setPreferredSize(new Dimension(150, 20));

        JPanel pnl4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        pnl4.setBounds(280, 300, 400, 140);
        //  pnl4.setBorder(BorderFactory.createLineBorder(Color.black));

        btnnew = new JButton("New");
        btnnew.setPreferredSize(new Dimension(80, 20));

        btninsert = new JButton("Insert");
        btninsert.setPreferredSize(new Dimension(80, 20));

        btnedit = new JButton("Edit");
        btnedit.setPreferredSize(new Dimension(80, 20));

        btnupdate = new JButton("Update");
        btnupdate.setPreferredSize(new Dimension(80, 20));

        btnnext = new JButton("Next");
        btnnext.setPreferredSize(new Dimension(80, 20));

        btnpre = new JButton("Pre");
        btnpre.setPreferredSize(new Dimension(80, 20));

        btndelete = new JButton("Delete");
        btndelete.setPreferredSize(new Dimension(80, 20));

        btnexit = new JButton("Exit");
        btnexit.setPreferredSize(new Dimension(80, 20));

        pnl4.add(btnnew);
        pnl4.add(btninsert);
        pnl4.add(btnedit);
        pnl4.add(btnupdate);

        pnl4.add(btnnext);
        pnl4.add(btnpre);
        pnl4.add(btndelete);
        pnl4.add(btnexit);

        pnl3.add(lblparentname);
        pnl3.add(txtparentname);
        pnl3.add(lblcontactno);
        pnl3.add(txtcontactno);
        pnl3.add(lblstandard);
        pnl3.add(cbostandard);
        pnl3.add(lblfees);
        pnl3.add(cbofees);

        add(pnl1);
        add(pnl2);
        add(pnl3);
        add(pnl4);
        btnupdate.setEnabled(false);
        loadCombobox();
        loadData();
        sk();

    }

    private void loadCombobox() {
        String sql1 = "select * from Standards";
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql1);
            Vector<String> standards = new Vector<String>();
            Vector<Integer> fees = new Vector<Integer>();
            while (rs.next()) {
                cbostandard.addItem(rs.getString(1));
                cbofees.addItem(rs.getInt(2));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            System.exit(0);
        }
    }

    private void loadData() {
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        String sql = "Select [Name], Standard from Students";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            data.removeAllElements();
            col.removeAllElements();
            if (!fill) {
                //get header
                ResultSetMetaData rsmd = rs.getMetaData();
                int n = rsmd.getColumnCount();

                col.add(rsmd.getColumnName(1));
                col.add(rsmd.getColumnName(2));
            }

            //get data
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                data.add(v);
            }
            model = new DefaultTableModel(data, col);
            this.tbl.setModel(model);
            rs.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    boolean validates() {
        if (txtname.getText().matches("^\\w+$") == false) {
            JOptionPane.showMessageDialog(this, "Name ko dc trong ", "Chu y", 1);
            txtname.requestFocus();
            return false;
        }
        String pName = this.txtname.getText().trim();
        Iterator it = data.iterator();
        while (it.hasNext()) {
            Vector v = (Vector) it.next();
            String name = ((String) v.get(0)).trim();
            if (pName.equalsIgnoreCase(name)) {
                JOptionPane.showMessageDialog(this, "Ten Sinh Vien nay da ton tai!");
                this.txtname.grabFocus();
                return false;
            }
        }
        if (txtaddress.getText().matches("^\\w+$") == false) {
            JOptionPane.showMessageDialog(this, "Address khong duoc de trong ", "Chu y", 1);
            txtaddress.requestFocus();
            return false;
        }
        if (txtparentname.getText().matches("^\\w+$") == false) {
            JOptionPane.showMessageDialog(this, "ParentsName khong duoc de trong ", "Chu y", 1);
            txtparentname.requestFocus();
            return false;
        }

        if (txtcontactno.getText().matches("^\\d{7,11}$") == false) {
            JOptionPane.showMessageDialog(this, "Contact(Phone) khong duoc de trong va phai la 7-12 so ", "Chu y", 1);
            txtcontactno.requestFocus();
            return false;
        }
        if ((cbostandard.getSelectedIndex() == 0)) {
            JOptionPane.showMessageDialog(this, cbostandard.getSelectedItem());
        }
        return true;
    }

    boolean duplicate(String s) {
        if (addNew == false) {
            return false;
        }
        for (int i = 0; i < data.size(); i++) {
            Vector v = (Vector) data.get(i);
            if (s.equalsIgnoreCase((String) v.get(0))) {
                return true;
            }
        }
        return false;
    }

    private void clearForm() {
        txtname.setText("");
        txtaddress.setText("");
        txtparentname.setText("");
        txtcontactno.setText("");
        cbostandard.setSelectedIndex(0);
        cbofees.setSelectedIndex(0);
        txtname.requestFocus();
    }

    private void cbb_StanActionPerformed() {
        cbofees.setSelectedIndex(cbostandard.getSelectedIndex());
    }

    private void cbb_FeesActionPerformed() {
        cbostandard.setSelectedIndex(cbofees.getSelectedIndex());
    }

    private void tblStudentMouseReleased() {
        if (this.tbl.getCellEditor() != null) {
            this.tbl.getCellEditor().cancelCellEditing();
        }
    }

    private void tblStudentMouseClicked() {
        // TODO add your handling code here:
        try {
            rts.beforeFirst();
            this.clearForm();
            int row = tbl.getSelectedRow();
            String name = (String) tbl.getValueAt(row, 0);
            while (rts.next()) {
                String str = rts.getString(2); //JOptionPane.showMessageDialog(null,""+jrs.getString(2)+" "+name);
                if (str.equalsIgnoreCase(name)) {
                    txtname.setText(rts.getString(2));
                    txtaddress.setText(rts.getString(3));
                    txtcontactno.setText(rts.getInt(5) + "");
                    //String parent=dencry(rts.getString(5));
                    txtparentname.setText(rts.getString(4));
                    cbostandard.setSelectedItem(rts.getString(6));
                    //com_fees.setSelectedItem(rts.getInt(7));
                    break;
                }
            }
        } catch (Exception e) {
        }
        txtname.setEnabled(false);
        txtaddress.setEnabled(false);
        txtparentname.setEnabled(false);
        txtcontactno.setEnabled(false);
        cbostandard.setEnabled(false);
        cbofees.setEnabled(false);
    }

    private void btnUpdateActionPerformed() {
        try {
            int n;
            if (addNew) {
                //them moi
                //set cac tham so
                pstInsert.setString(1, this.txtname.getText().trim());
                pstInsert.setString(2, txtaddress.getText().trim());
                pstInsert.setString(3, txtparentname.getText().trim());
                pstInsert.setString(4, txtcontactno.getText().trim());
                pstInsert.setString(5, (String) cbostandard.getSelectedItem());
                n = pstInsert.executeUpdate();//thuc thi
                this.loadData();
            } else {
                //update
                //set cac tham so
                pstUpdate.setString(5, this.txtname.getText().trim());
                pstUpdate.setString(2, this.txtaddress.getText().trim());
                pstUpdate.setString(1, this.txtparentname.getText().trim());
                pstUpdate.setString(3, this.txtcontactno.getText().trim());
                pstUpdate.setString(4, (String) cbostandard.getSelectedItem());
                n = pstUpdate.executeUpdate();//thuc thi
                this.loadData();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    private void btnCancelActionPerformed() {
        clearForm();
        txtname.setEnabled(true);
        txtaddress.setEnabled(true);
        txtparentname.setEnabled(true);
        txtcontactno.setEnabled(true);
        cbofees.setEnabled(true);
        cbostandard.setEnabled(true);
        txtname.requestFocus();
    }

    private void btnEditActionPerformed() {
        btnupdate.setEnabled(true);
// btnCancel.setEnabled(true);
        btnedit.setEnabled(true);
        txtname.setEnabled(true);
        txtaddress.setEnabled(true);
        txtparentname.setEnabled(true);
        txtcontactno.setEnabled(true);
        cbostandard.setEnabled(true);
    }

    private void btnPreActionPerformed() {
        try {
            //JOptionPane.showMessageDialog(this, "Co loi xay ra");
            rts.previous();
            // JOptionPane.showMessageDialog(this, "Co loi xay ra");
            btnnext.setEnabled(true);
            if (rts.isBeforeFirst()) {
                // System.out.println("co loi xay ra");
                btnpre.setEnabled(false);
                btnnext.setEnabled(true);
                JOptionPane.showMessageDialog(null, "You have reached the first record "
                        + "of the ResultSet!!!!");
            } else {
                txtname.setText(rts.getString(2));
                txtaddress.setText(rts.getString(3));
                txtparentname.setText(rts.getString(4));
                txtcontactno.setText(rts.getString(5));
                cbostandard.setSelectedItem(rts.getString(6));
            }
        } catch (Exception e) {
            //JOptionPane.showConfirmDialog(this,"co loi xay ra");
        }
    }

    private void btnNextActionPerformed() {
        //loadCombobox();
        try {
            rts.next();
            btnpre.setEnabled(true);
            if (rts.isAfterLast() || rts.isBeforeFirst()) {
                btnnext.setEnabled(false);
                btnpre.setEnabled(true);
                JOptionPane.showMessageDialog(null, "You have reached the last record"
                        + " of the ResultSet!!!!");
            } else {
                txtname.setText(rts.getString(2));
                txtaddress.setText(rts.getString(3));
                txtparentname.setText(rts.getString(4));
                txtcontactno.setText(rts.getString(5));
                cbostandard.setSelectedItem(rts.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void btnExitActionPerformed() {
        fill = false;
        System.exit(0);
    }

    private void btnDeleteActionPerformed() {
        try {
            int n = this.tbl.getSelectedRow();
            if (n >= 0)//nguoi dung co chon
            {
                //this.pnlDetails.setVisible(false);
                Vector v = (Vector) data.get(n);
                int ans = JOptionPane.showConfirmDialog(this, "Ban co thuc su muon xoa Sinh Vien "
                        + ((String) v.get(0)).trim() + " khong?");
                if (ans == JOptionPane.YES_OPTION) {
                    pstDelete.setString(1, (String) v.get(0));
                    pstDelete.executeUpdate();
                    this.loadData();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    private void btnInsertActionPerformed() {
        if (!validates()) {
            return;
        }
        String name = txtname.getText();
        String addr = txtaddress.getText();
        String parentName = txtparentname.getText();
        String phone = txtcontactno.getText();
        String standard = (String) cbostandard.getSelectedItem();
        try {
            pstInsert.setString(1, name);
            pstInsert.setString(2, addr);
            pstInsert.setString(3, parentName);
            pstInsert.setString(4, phone);
            pstInsert.setString(5, standard);
            int addRows = pstInsert.executeUpdate();
            this.loadData();
            clearForm();
            if (addRows > 0) {
                JOptionPane.showMessageDialog(this, "Students Details Have BeenSave", "Successfull", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Failed to save data in database", "Error",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    void sk() {
        tbl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tblStudentMouseClicked();
            }

            public void mouseReleased(MouseEvent evt) {
                tblStudentMouseReleased();
            }
        });

        cbostandard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbb_StanActionPerformed();
            }
        });

        cbofees.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbb_FeesActionPerformed();
            }
        });

        btndelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnDeleteActionPerformed();
            }
        });
        btnedit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEditActionPerformed();
            }
        });
        btnexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnExitActionPerformed();
            }
        });
        btninsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnInsertActionPerformed();
            }
        });
        btnnew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
//                if (duplicate(txtname.getText().trim())) {
//                    return;
//                }
            }
        });
        btnnext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnNextActionPerformed();
            }
        });
        btnpre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPreActionPerformed();
            }
        });
        btnupdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnUpdateActionPerformed();
            }
        });

    }

    public static void main(String[] args) {
        new Bai2("").setVisible(true);
    }
}
