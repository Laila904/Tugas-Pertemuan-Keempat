/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan04;

/**
 *
 * @author ASUS
 */
public class LaaException extends Exception {

    public LaaException(String s) {
        super(s);
    }

    public static void main(String[] args) {
        try {
            throw new LaaException("Hallo");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.err.println("Apa kabar semua");
        }
    }
}
