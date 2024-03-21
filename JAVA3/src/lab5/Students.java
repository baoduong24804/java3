/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5;

/**
 *
 * @author anhba
 */
public class Students {

    String Masv;
    String Hoten;
    String Email;
    String Sdt;
    boolean Gioitinh;
    String Diachi;

    public Students(String Masv, String Hoten, String Email, String Sdt, boolean Gioitinh, String Diachi) {
        this.Masv = Masv;
        this.Hoten = Hoten;
        this.Email = Email;
        this.Sdt = Sdt;
        this.Diachi = Diachi;
        this.Gioitinh = Gioitinh;
    }

    @Override
    public String toString() {
        String gt = Gioitinh ? "Nam" : "Nu";
        return "Student:" + "\nMasv=" + Masv + "\nHoten=" + Hoten + "\nEmail=" + Email + "\nSdt=" + Sdt + "\nDiachi=" + Diachi + "\nGioitinh=" + gt;
    }

    public String getMasv() {
        return Masv;
    }

    public void setMasv(String Masv) {
        this.Masv = Masv;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public boolean isGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(boolean Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

}
