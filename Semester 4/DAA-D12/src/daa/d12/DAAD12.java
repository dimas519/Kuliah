/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.d12;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
public class DAAD12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int input=sc.nextInt();
        int mod=sc.nextInt();
        for(int i=0;i<input;i++){
            String plat=sc.next();
            plat=plat.toLowerCase();
            int panjang=plat.length();
            int hash=0;
            int temp=panjang;
            for(int j=0;j<panjang;j++){
                char pot=plat.charAt(j);
                long kode=0;
                if(Character.isDigit(pot)){
                    kode=pot-'0';
                }else {
                    kode=pot-'a'+10;
                }
                hash+=Math.pow(kode,temp );
                temp--;
            }
            System.out.println(hash%mod);

        }
    }
}
