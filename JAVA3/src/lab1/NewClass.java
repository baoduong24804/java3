/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author anhba
 */
public class NewClass extends JFrame implements ActionListener{
    
    JTextField jtxt, jtxt2, jtxt3;
    
    public static void main(String[] args) {
        NewClass n = new NewClass("Bai2");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   String s = e.getActionCommand();
   if(jtxt.getText().trim().isEmpty() || jtxt2.getText().trim().isEmpty()){
       JOptionPane.showMessageDialog(this, "Empty");
       return;
   }
               double s1 = 0, s2 = 0;
        try {
            s1 = Double.parseDouble(jtxt.getText().trim());
            s2 = Double.parseDouble(jtxt2.getText().trim());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error");
        }

        if (s.equals("+")) {
            jtxt3.setText((s1 + s2) + "");
        }

        if (s.equals("-")) {
            jtxt3.setText((s1 - s2) + "");
        }

        if (s.equals("*")) {
            jtxt3.setText((s1 * s2) + "");
        }

        if (s.equals("/")) {
            if(s2 == 0){
                jtxt3.setText("Phép chia cho 0");
            return;
            }
            jtxt3.setText((s1 / s2) + "");
        }
       
    }
    
    public void initComponets(){
        setSize(400,300);
        setLayout(new GridLayout(4,2,5,5));
        JLabel lbl = new  JLabel("First number");
        JLabel lbl2 = new  JLabel("Second number");
        JLabel lbl3 = new  JLabel("Result");
        
         jtxt = new JTextField();
         jtxt2 = new JTextField();
         jtxt3 = new JTextField();
        
         JButton jbtn = new JButton("+");
         JButton jbtn2 = new JButton("-");
         JButton jbtn3 = new JButton("*");
         JButton jbtn4 = new JButton("/");
         
         jbtn.addActionListener(this);
         jbtn2.addActionListener(this);
         jbtn3.addActionListener(this);
         jbtn4.addActionListener(this);
        
        
       // setLayout(new FlowLayout());
        JPanel j = new JPanel();
        JPanel jj = new JPanel();
        
        jj.add(jbtn);
        jj.add(jbtn2);
        jj.add(jbtn3);
        jj.add(jbtn4);
      //  j.setLayout(new FlowLayout());
      
       
        
        
        
        getContentPane().add(lbl);
        getContentPane().add(jtxt);
        
        getContentPane().add(lbl2);
        getContentPane().add(jtxt2);
        
        getContentPane().add(lbl3);
        getContentPane().add(jtxt3);
        
        getContentPane().add(j);
        getContentPane().add(jj);
        
    }

    public NewClass(String title) throws HeadlessException {
        super(title);
        initComponets();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
}
