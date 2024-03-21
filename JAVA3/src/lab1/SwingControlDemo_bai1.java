/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author anhba
 */
public class SwingControlDemo_bai1 {

   

        private JFrame mainFrame;
        private JLabel headerLabel;
        private JLabel statusLabel;
        private JPanel controlPanel;

        public SwingControlDemo_bai1() {
            prepareGUI();
            
        }

        public static void main(String[] args) {
            SwingControlDemo_bai1 swingControlDemo = new SwingControlDemo_bai1();
            swingControlDemo.showCheckBoxDemo();
        }

        private void prepareGUI() {
            mainFrame = new JFrame("Vi du Java Swing");
            mainFrame.setSize(300, 300);
            mainFrame.setLayout(new GridLayout(3, 1));
//            mainFrame.addWindowListener(new WindowAdapter() {
//                public void windowClosing(WindowEvent windowEvent) {
//                    System.exit(0);
//                }
//            });
            headerLabel = new JLabel("", JLabel.CENTER);
            statusLabel = new JLabel("", JLabel.CENTER);
            statusLabel.setSize(350, 100);
            controlPanel = new JPanel();
            controlPanel.setLayout(new FlowLayout());

            mainFrame.add(headerLabel);
            mainFrame.add(controlPanel);
            mainFrame.add(statusLabel);
            mainFrame.setVisible(true);
        }

        private void showCheckBoxDemo() {
            
            headerLabel.setText("Control in action: CheckBox");
            final JCheckBox chkApple = new JCheckBox("Apple");
            final JCheckBox chkMango = new JCheckBox("Mango");
            final JCheckBox chkPeer = new JCheckBox("Peer");
            chkApple.setMnemonic(KeyEvent.VK_A);
            chkMango.setMnemonic(KeyEvent.VK_M);
            chkPeer.setMnemonic(KeyEvent.VK_P);
            chkApple.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    statusLabel.setText("Apple Checkbox: "
                            + (e.getStateChange() == 1 ? "checked" : "unchecked"));
                }
            });
            chkMango.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    statusLabel.setText("Mango Checkbox: "
                            + (e.getStateChange() == 1 ? "checked" : "unchecked"));
                }
            });
            chkPeer.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    statusLabel.setText("Peer Checkbox: "
                            + (e.getStateChange() == 1 ? "checked" : "unchecked"));
                }
            });
            controlPanel.add(chkApple);
            controlPanel.add(chkMango);
            controlPanel.add(chkPeer);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setVisible(true);
            mainFrame.setLocationRelativeTo(null);
        }
    }

