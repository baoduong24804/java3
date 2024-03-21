/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slides;

import java.awt.*;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author anhba
 */
public class Demo1AWT extends Frame implements ActionListener {

    Button btnRed, btnYellow, btnD;
    Label lbl;

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if(s.equals("Default")){
            setBackground(Color.WHITE);
            lbl.setText("Default");
            return;
        }
        
        if (s.equals("Red")) {
            setBackground(Color.RED);
            lbl.setText("Ban da chon btnRed");
        } else {
            setBackground(Color.YELLOW);
            lbl.setText("Ban da chon btnYellow");
        }
    }

    public Demo1AWT(String title) throws HeadlessException {
        super(title);
        initComponet();
    }

    private void initComponet() {
        setSize(360, 420);
        this.setLayout(new FlowLayout());
        btnRed = new Button("Red");
        btnYellow = new Button("Yellow");
        btnD = new Button("Default");
        lbl = new Label("Ban chua chon btnRed hoac btnYellow");
        btnRed.addActionListener(this);
        btnYellow.addActionListener(this);
        btnD.addActionListener(this);

        this.add(btnRed);
        this.add(btnYellow);
        this.add(btnD);
        this.add(lbl);

        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        Demo1AWT frame = new Demo1AWT("Demo1 AWT");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

}
