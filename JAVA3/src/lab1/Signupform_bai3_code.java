/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1;


import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 *
 * @author anhba
 */
public class Signupform_bai3_code extends JFrame implements ActionListener {

    private JLabel jlabel1, jlabel2, jlabel3;
    private JTextField jtextfield1;
    private JPasswordField jPasswordField1, jPasswordField2;
    private JButton jbutton1, jbutton2;
    // private JPanel jpanel;

    public Signupform_bai3_code(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponets();
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        
        if(s.equals("Cancel")){
        System.exit(0);
        }
        
        if (jtextfield1.getText().trim().isEmpty() || (new String (jPasswordField1.getPassword())).trim().isEmpty() || (new String (jPasswordField2.getPassword()).trim().isEmpty())) {
            JOptionPane.showMessageDialog(this, "Empty");
            return;
        }
        
    
        
        
        if(!((new String (jPasswordField1.getPassword())).trim().equals((new String (jPasswordField2.getPassword())).trim()))){
            JOptionPane.showMessageDialog(this, "MK và xác nhận MK không trùng");
            return;
        }
        
        JOptionPane.showMessageDialog(this, "Đăng kí thành công");
        jtextfield1.setText("");
        jPasswordField1.setText("");
        jPasswordField2.setText("");
        
        
        

    }

    public void initComponets() {
        setLayout(null);
        setSize(400, 250);

        jlabel1 = new JLabel("Username");
        jlabel1.setBounds(5, 10, 100, 20);

        jlabel2 = new JLabel("Password");
        jlabel2.setBounds(5, 60, 100, 20);

        jlabel3 = new JLabel("Comfirm");
        jlabel3.setBounds(5, 110, 100, 20);

        jtextfield1 = new JTextField();
        jtextfield1.setBounds(120, 5, 200, 30);

        jPasswordField1 = new JPasswordField();
        jPasswordField1.setBounds(120, 55, 200, 30);

        jPasswordField2 = new JPasswordField();
        jPasswordField2.setBounds(120, 105, 200, 30);
        //   jtextfield3.setEnabled(false);

        jbutton1 = new JButton();
        jbutton1.setText("Sign up");
        //jbutton1.setFont(new Font("Arial", Font.PLAIN, 6));
        jbutton1.setBounds(120, 150, 100, 50);
        jbutton1.addActionListener(this);

        jbutton2 = new JButton();
        jbutton2.setText("Cancel");
        jbutton2.setBounds(230, 150, 100, 50);
        jbutton2.addActionListener(this);

//        jbutton3 = new JButton();
//        jbutton3.setText("*");
//        jbutton3.setBounds(240, 150, 50, 50);
//        jbutton3.addActionListener(this);
//
//        jbutton4 = new JButton();
//        jbutton4.setText("/");
//        jbutton4.setBounds(300, 150, 50, 50);
//        jbutton4.addActionListener(this);

        //  jpanel = new JPanel();
        //  jpanel.setBorder(BorderFactory.createTitledBorder("ha"));
        //  jpanel.setPreferredSize(new Dimension(100, 100));
        //  jpanel.setLayout(new GridLayout(3,2));
        getContentPane().add(jlabel1);
        getContentPane().add(jtextfield1);
        getContentPane().add(jlabel2);
        getContentPane().add(jPasswordField1);
        getContentPane().add(jlabel3);
        getContentPane().add(jPasswordField2);
        getContentPane().add(jbutton1);
        getContentPane().add(jbutton2);
       // getContentPane().add(jbutton3);
       // getContentPane().add(jbutton4);

        // getContentPane().add(jpanel);
        //  pack();
    }

    public static void main(String[] args) {
        Signupform_bai3_code c = new Signupform_bai3_code("Bai3");
        c.setVisible(true);
    }
}
