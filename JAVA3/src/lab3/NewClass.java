/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author anhba
 */
public class NewClass {
public static void main(String[] args) {
        JPanel panel = new JPanel();

        // Create a JTextArea.
        JTextArea textArea = new JTextArea(5, 20);
        textArea.setText("This is a text area.");

        // Create a JScrollPane.
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Add the JScrollPane to the JPanel.
        panel.add(scrollPane);

        // Display the panel.
        JFrame frame = new JFrame("ScrollPane Example");
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
