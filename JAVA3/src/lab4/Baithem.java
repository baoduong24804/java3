package lab4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.StringTokenizer;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.tree.*;

public class Baithem extends JFrame {

    JButton btnSaveFile, btnNewD, btnNewE, btnRemoveD, btnSaveD, btnRemoveE, btnSaveE;
    JTextField txtDepCode, txtDepName, txtEmpCode, txtEmpName, txtsalary;
    JLabel lbDCode, lbDName, lbEcode, lbEname, lbELuong;
    JPanel pn1, pn2, pn3;
    String fileName = "D:\\JAVA3\\hi.txt";
    DefaultMutableTreeNode root, curDepNode, curEmpNode;

    boolean addNewDep = false;
    boolean addNewEmp = false;
    JTree tree = new JTree();

    ;

    public Baithem(String title) throws HeadlessException {
        super(title);
        initComponents();
        tree.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                treeclicked();
            }
        });

        btnSaveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToFile();
            }
        });

        btnNewD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewDep = true;
                txtDepCode.setText("");
                txtDepName.setText("");
                txtEmpCode.setText("");
                txtEmpName.setText("");
                txtsalary.setText("");
                txtDepCode.setEditable(true);
                txtDepCode.requestFocus();
            }
        });

        btnRemoveD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (curDepNode.getChildCount() > 0) {
                    JOptionPane.showMessageDialog(null, "Ban phai xoa tat ca nhan vien cua phong ban nay truoc");
                } else {
                    int choose = JOptionPane.showConfirmDialog(null, "Ban co chac muon xoa phong ban nay?", "Xac nhan", JOptionPane.YES_NO_OPTION);
                    if (choose == JOptionPane.YES_OPTION) {
                        root.remove(curDepNode);
                        tree.updateUI();
                    }
                }
            }
        });

        btnSaveD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!checknull()) {
                    return;
                }
                String code = txtDepCode.getText().trim().toUpperCase();
                txtDepCode.setText(code);
                String name = txtDepName.getText().trim();
                txtDepName.setText(name);
                if (addNewDep == true) {
                    Department newDep = new Department(code, name);
                    root.add(new DefaultMutableTreeNode(newDep));
                } else {
                    ((Department) curDepNode.getUserObject()).setDepName(name);
                }
                tree.updateUI();
                addNewDep = false;
            }
        });

        btnNewE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnNewE();
            }
        });

        btnRemoveE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnRemoveE();
            }
        });

        btnSaveE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnSaveE();
            }
        });

    }

    void saveToFile() {
        if (root.getChildCount() == 0) {
            return;
        }
        String s = "";
        try {
            FileWriter f = new FileWriter(fileName);
            PrintWriter pw = new PrintWriter(f);
            Enumeration depts = root.children();
            while (depts.hasMoreElements()) {
                DefaultMutableTreeNode depNode = (DefaultMutableTreeNode) depts.nextElement();
                Department dept = (Department) (depNode.getUserObject());
                s = dept.getDepCode() + "-" + dept.getDepName() + ":";
                pw.println(s);
                Enumeration emps = depNode.children();
                while (emps.hasMoreElements()) {
                    DefaultMutableTreeNode empNode = (DefaultMutableTreeNode) emps.nextElement();
                    Employee emp = (Employee) (empNode.getUserObject());
                    s = emp.getEmpCode() + "," + emp.getEmpName() + "," + emp.getSalary();
                    pw.println(s);
                }
            }
            pw.close();
            f.close();
            JOptionPane.showMessageDialog(this, "Luu thanh cong: " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    boolean checknull() {
        if (txtDepCode.getText().trim().isEmpty() || txtDepName.getText().trim().isEmpty()) {
            return false;
        }
        return true;
    }

    void btnNewE() {
        addNewEmp = true;
        txtEmpCode.setText("");
        txtEmpName.setText("");
        txtsalary.setText("");
        txtEmpCode.setEditable(true);
        txtEmpCode.requestFocus();
    }

    void btnRemoveE() {
        if (curEmpNode != null) {
            int response = JOptionPane.showConfirmDialog(this, "Delete this employee - OK?", "Remove", JOptionPane.YES_NO_OPTION);
            if (response == 0) {
                curDepNode.remove(curEmpNode);
                tree.updateUI();
            }
        }

    }

    void btnSaveE() {
        if (!vilidEmDetail()) {
            return;
        }
        String code = txtEmpCode.getText().trim().toUpperCase();
        txtEmpCode.setText(code);
        String name = txtEmpName.getText().trim();
        txtEmpName.setText(name);
        String salaryStr = txtsalary.getText().trim();
        txtsalary.setText(salaryStr);
        int sal = Integer.parseInt(salaryStr);

        if (addNewEmp == true) {
            Employee newEmp = new Employee(code, name, sal);
            curDepNode.add(new DefaultMutableTreeNode(newEmp));
        } else {
            Employee emp = (Employee) (curEmpNode.getUserObject());
            emp.setEmpName(name);
            emp.setSalary(sal);
        }

    }

    boolean vilidEmDetail() {
        if (txtEmpCode.getText().trim().isEmpty() || txtEmpName.getText().trim().isEmpty() || txtsalary.getText().trim().isEmpty()) {
            return false;
        }
        return true;
    }

    void treeclicked() {
        tree.cancelEditing();
        TreePath path = tree.getSelectionPath();
        if (path == null) {
            return;
        }
        DefaultMutableTreeNode selectedNode = null;
        selectedNode = (DefaultMutableTreeNode) (path.getLastPathComponent());
        Object selectedObj = selectedNode.getUserObject();
        if (selectedNode == root) {
            this.curDepNode = this.curEmpNode = null;

        } else {
            if (selectedObj instanceof Department) {
                this.curDepNode = selectedNode;
                this.curEmpNode = null;
            } else if (selectedObj instanceof Employee) {
                curEmpNode = selectedNode;
                curDepNode = (DefaultMutableTreeNode) (selectedNode.getParent());
            }

        }
        viewDeptAndEmp();
    }

    void viewDeptAndEmp() {
        Department curDep = null;
        Employee curEmp = null;
        if (curDepNode != null) {
            curDep = (Department) (curDepNode.getUserObject());
        }

        if (curEmpNode != null) {
            curEmp = (Employee) (curEmpNode.getUserObject());
        }
        this.txtDepCode.setText(curDep != null ? curDep.getDepCode() : "");
        this.txtDepName.setText(curDep != null ? curDep.getDepName() : "");
        this.txtEmpCode.setText(curEmp != null ? curEmp.getEmpCode() : "");
        this.txtEmpName.setText(curEmp != null ? curEmp.getEmpName() : "");
        this.txtsalary.setText("" + (curEmp != null ? curEmp.getSalary() : ""));
        this.txtDepCode.setEditable(false);
        this.txtEmpCode.setEditable(false);

    }

    void loadData() {
        String s = "";
        StringTokenizer stk;
        try {
            FileReader f = new FileReader(fileName);
            BufferedReader bf = new BufferedReader(f);
            while ((s = bf.readLine()) != null) {
                s = s.trim();
                boolean isDept = (s.charAt(s.length() - 1) == ':');
                stk = new StringTokenizer(s, "-:,");
                String code = stk.nextToken();
                String name = stk.nextToken();
                if (isDept) {
                    curDepNode = new DefaultMutableTreeNode(new Department(code, name));
                    root.add(curDepNode);
                } else {
                    int salary = Integer.parseInt(stk.nextToken().trim());
                    curEmpNode = new DefaultMutableTreeNode(new Employee(code, name, salary));
                    curDepNode.add(curEmpNode);
                }
            }
            bf.close();
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void initComponents() {
        setSize(650, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        pn1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
     //   pn1.setBorder(BorderFactory.createLineBorder(Color.black));
        pn1.setBounds(5, 20, 200, 370);
        root = new DefaultMutableTreeNode("Departments");
        tree.setModel(new DefaultTreeModel(root));
        JScrollPane jscr = new JScrollPane(tree);
        jscr.setPreferredSize(new Dimension(200, 370));
        pn1.add(jscr);

        pn2 = new JPanel();
        pn2.setLayout(null);
        pn2.setBounds(220, 20, 400, 200);

        pn2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.green), "Department Details", TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", 1, 18), new Color(255, 0, 0)));
        btnNewD = new JButton("New");
        btnNewD.setBounds(50, 160, 100, 30);
        btnRemoveD = new JButton("Remove");
        btnRemoveD.setBounds(155, 160, 100, 30);
        btnSaveD = new JButton("Save");
        btnSaveD.setBounds(260, 160, 100, 30);
        lbDCode = new JLabel("Dept. code:");
        lbDCode.setBounds(50, 40, 100, 30);
        lbDName = new JLabel("Dept. name:");
        lbDName.setBounds(50, 80, 100, 30);
        txtDepCode = new JTextField();
        txtDepCode.setBounds(150, 40, 200, 30);
        txtDepName = new JTextField();
        txtDepName.setBounds(150, 80, 200, 30);
        pn2.add(txtDepCode);
        pn2.add(txtDepName);
        pn2.add(lbDName);
        pn2.add(lbDCode);
        pn2.add(btnNewD);
        pn2.add(btnRemoveD);
        pn2.add(btnSaveD);
        add(pn2);

        pn3 = new JPanel();
        pn3.setBounds(220, 230, 400, 200);

        pn3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.green), "Employee Details", TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", 1, 18), new Color(255, 0, 0)));
        pn3.setLayout(null);
        btnNewE = new JButton("New");
        btnNewE.setBounds(50, 160, 100, 30);
        btnRemoveE = new JButton("Remove");
        btnRemoveE.setBounds(155, 160, 100, 30);
        btnSaveE = new JButton("Save");
        btnSaveE.setBounds(260, 160, 100, 30);
        lbEcode = new JLabel("Emp. code:");
        lbEcode.setBounds(50, 30, 100, 30);
        lbEname = new JLabel("Emp. name:");
        lbEname.setBounds(50, 70, 100, 30);
        lbELuong = new JLabel("Salary:");
        lbELuong.setBounds(50, 110, 100, 30);
        txtEmpCode = new JTextField();
        txtEmpCode.setBounds(150, 30, 200, 30);
        txtEmpName = new JTextField();
        txtEmpName.setBounds(150, 70, 200, 30);
        txtsalary = new JTextField();
        txtsalary.setBounds(150, 110, 200, 30);
        pn3.add(txtEmpCode);
        pn3.add(txtEmpName);
        pn3.add(txtsalary);
        pn3.add(lbEname);
        pn3.add(lbEcode);
        pn3.add(lbELuong);
        pn3.add(btnNewE);
        pn3.add(btnRemoveE);
        pn3.add(btnSaveE);
        add(pn3);

        btnSaveFile = new JButton("Save to file");
        btnSaveFile.setBounds(5, 390, 200, 40);
        add(pn1);
        add(pn2);
        add(pn3);
        add(btnSaveFile);
        loadData();
        setVisible(true);
    }

    public static void main(String[] args) {

        new Baithem("Bai them");
    }
}
