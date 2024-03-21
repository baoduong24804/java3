    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author anhba
 */
public class BT_themlab1 extends JFrame implements ActionListener {

    private JLabel jlabel1, jlabel2, jlabel3, jlabel4;
    private JTextField jtextfield1, jtextfield2, jtextfield3;
    private JButton jbutton1, jbutton2, jbutton3;

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        double a = 0, b = 0;
        if (s.equals("Thoát")) {
            System.exit(0);
            return;
        }

        if (jtextfield1.getText().trim().isEmpty() || jtextfield2.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Empty");
            return;
        }

        if (s.equals("Xóa")) {
            jtextfield1.setText("");
            jtextfield2.setText("");
            jtextfield3.setText("");
            return;
        }

        if (s.equals("Giải")) {

            try {
                a = Double.parseDouble(jtextfield1.getText().trim());
                b = Double.parseDouble(jtextfield2.getText().trim());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error");
            }
            
            if(a == 0){
            jtextfield3.setText("PT vô nghiệm");
            return;
            }
            
            if((-b/a)==0){
            jtextfield3.setText("0");
            return;
            }
            
            jtextfield3.setText((-b/a)+"");
            
        }
        
        

    }

    public BT_themlab1(String title) throws HeadlessException {
        super(title);
        initComponets();
        setLocationRelativeTo(null);
    }

    public void initComponets() {
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        jlabel1 = new JLabel("Giải PT bậc 1");
        jlabel1.setBounds(125, 5, 150, 30);
        jlabel1.setFont(new Font("Segoe UI", Font.BOLD, 20));
        jlabel1.setForeground(Color.BLUE);

        jlabel2 = new JLabel("Hệ số a");
        jlabel2.setBounds(80, 50, 100, 20);
        jlabel2.setFont(new Font("Arial", Font.PLAIN, 16));

        jlabel3 = new JLabel("Hệ số b");
        jlabel3.setBounds(80, 90, 100, 20);
        jlabel3.setFont(new Font("Arial", Font.PLAIN, 16));

        jlabel4 = new JLabel("Kết quả");
        jlabel4.setBounds(80, 170, 100, 20);
        jlabel4.setFont(new Font("Arial", Font.PLAIN, 16));

        jtextfield1 = new JTextField();
        jtextfield1.setBounds(150, 45, 120, 30);

        jtextfield2 = new JTextField();
        jtextfield2.setBounds(150, 85, 120, 30);

        jtextfield3 = new JTextField();
        jtextfield3.setBounds(150, 165, 120, 30);

        jbutton1 = new JButton();
        jbutton1.setText("Xóa");
        jbutton1.setBounds(60, 130, 80, 20);
        jbutton1.addActionListener(this);

        jbutton2 = new JButton();
        jbutton2.setText("Giải");
        jbutton2.setBounds(150, 130, 80, 20);
        jbutton2.addActionListener(this);

        jbutton3 = new JButton();
        jbutton3.setText("Thoát");
        jbutton3.setBounds(240, 130, 80, 20);
        jbutton3.addActionListener(this);

        jtextfield3.setEditable(false);
        
        getContentPane().add(jlabel1);
        getContentPane().add(jlabel2);
        getContentPane().add(jlabel3);
        getContentPane().add(jlabel4);
        getContentPane().add(jtextfield1);
        getContentPane().add(jtextfield2);
        getContentPane().add(jtextfield3);
        getContentPane().add(jbutton1);
        getContentPane().add(jbutton2);
        getContentPane().add(jbutton3);

    }

    public static void main(String[] args) {
        BT_themlab1 b = new BT_themlab1("Chương trình giải PT bậc 1");
        b.setVisible(true);
    }
}
