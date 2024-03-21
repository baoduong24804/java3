/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author anhba
 */
public class luu_doc {

    public static void main(String[] args) {
        try {

            // ghi file
            FileOutputStream o = new FileOutputStream("D:\\JAVA3\\t.txt");
            byte by[] = "xin chao".getBytes();
            o.write(by);
            o.close();
            
            // doc file
            FileInputStream f = new FileInputStream("D:\\JAVA3\\t.txt");
            int i = 123456789;
            while ((i = f.read()) != -1) {
                System.out.print((char) i);
            }
            f.close();

            System.out.println("");

        } catch (Exception e) {
        }

    }
}
