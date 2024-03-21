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
import javax.swing.JTextField;


/**
 *
 * @author anhba
 */
public class Calculator_bai2_code extends JFrame implements ActionListener {

    private JLabel jlabel1, jlabel2, jlabel3;
    private JTextField jtextfield1, jtextfield2, jtextfield3;
    private JButton jbutton1, jbutton2, jbutton3, jbutton4;
    // private JPanel jpanel;

    public Calculator_bai2_code(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponets();
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (jtextfield1.getText().trim().isEmpty() || jtextfield2.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Empty");
            return;
        }
        double s1 = 0, s2 = 0;
        try {
            s1 = Double.parseDouble(jtextfield1.getText().trim());
            s2 = Double.parseDouble(jtextfield2.getText().trim());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error");
        }

        if (s.equals("+")) {
            jtextfield3.setText((s1 + s2) + "");
        }

        if (s.equals("-")) {
            jtextfield3.setText((s1 - s2) + "");
        }

        if (s.equals("*")) {
            jtextfield3.setText((s1 * s2) + "");
        }

        if (s.equals("/")) {
            if(s2 == 0){
                jtextfield3.setText("Phép chia cho 0");
            return;
            }
            jtextfield3.setText((s1 / s2) + "");
        }

    }

    public void initComponets() {
        setLayout(null);
        setSize(400, 250);

        jlabel1 = new JLabel("First number");
        jlabel1.setBounds(5, 10, 100, 20);

        jlabel2 = new JLabel("Second number");
        jlabel2.setBounds(5, 60, 100, 20);

        jlabel3 = new JLabel("Result");
        jlabel3.setBounds(5, 110, 100, 20);

        jtextfield1 = new JTextField();
        jtextfield1.setBounds(120, 5, 200, 30);

        jtextfield2 = new JTextField();
        jtextfield2.setBounds(120, 55, 200, 30);

        jtextfield3 = new JTextField();
        jtextfield3.setBounds(120, 105, 200, 30);
        //   jtextfield3.setEnabled(false);

        jbutton1 = new JButton();
        jbutton1.setText("+");
        //jbutton1.setFont(new Font("Arial", Font.PLAIN, 6));
        jbutton1.setBounds(120, 150, 50, 20);
        jbutton1.addActionListener(this);

        jbutton2 = new JButton();
        jbutton2.setText("-");
        jbutton2.setBounds(180, 150, 50, 20);
        jbutton2.addActionListener(this);

        jbutton3 = new JButton();
        jbutton3.setText("*");
        jbutton3.setBounds(240, 150, 50, 20);
        jbutton3.addActionListener(this);

        jbutton4 = new JButton();
        jbutton4.setText("/");
        jbutton4.setBounds(300, 150, 50, 20);
        jbutton4.addActionListener(this);

        //  jpanel = new JPanel();
        //  jpanel.setBorder(BorderFactory.createTitledBorder("ha"));
        //  jpanel.setPreferredSize(new Dimension(100, 100));
        //  jpanel.setLayout(new GridLayout(3,2));
        jtextfield3.setEditable(false);
        
        getContentPane().add(jlabel1);
        getContentPane().add(jtextfield1);
        getContentPane().add(jlabel2);
        getContentPane().add(jtextfield2);
        getContentPane().add(jlabel3);
        getContentPane().add(jtextfield3);
        getContentPane().add(jbutton1);
        getContentPane().add(jbutton2);
        getContentPane().add(jbutton3);
        getContentPane().add(jbutton4);

        // getContentPane().add(jpanel);
        //  pack();
    }

    public static void main(String[] args) {
        Calculator_bai2_code c = new Calculator_bai2_code("Bai2");
        c.setVisible(true);
    }
}
