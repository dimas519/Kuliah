/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rpl.pkg9.pkg12.pkg2021;



/**
 *
 * @author Kurni
 */
public class RPL9122021 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
    
    /**
     * 
     * methods ini berguna
     * @param a adalah bilangan pembagi
     * @param b adalah sebuah bilangan penyebut
     * @return hasil bagi antara a dan b
     */
    public double bagi(int a, int b){
        return a/b;
    }
    
    
    /**
     * 
     * methods untuk mencari nilai terbesar dalam sebuah array
     * @param arr masukan array nya
     * @return keluaran berupa satu buah angka bilangan terbesar
     */
    public int FindMaxArray(int arr[]){
        int a=Integer.MIN_VALUE;
        for( int x: arr){
            if(x>a){
                a=x;
            }
        }
        return a;
    }
    
    
    
    
    
}
