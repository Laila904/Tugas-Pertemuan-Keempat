/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan04;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Try {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("masukan nomor anda");
            int contoh = sc.nextInt();
            System.out.println(contoh);
        } catch (Exception e) {
            System.err.println("Silahkan masukkan angka bukan huruf");
        }
    }
}
