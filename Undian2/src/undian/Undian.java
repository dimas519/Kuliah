/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//package undian;

/**
 *
 * @author USER
 */
import java.util.Scanner;
public class Undian {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int kasus=sc.nextInt();
        int[] arr=new int[2500001];
        int i=0;
        int input;
        for (i=0;i<kasus;i++){
            input=sc.nextInt();
            arr[input]++;
        }

        kasus=sc.nextInt();
        for (i=0;i<kasus;i++){
            input=sc.nextInt();
            
            if (arr[input]!=0){
            System.out.println(arr[input]);
        } else {
                System.out.println("Tidak ditemukan");
                }
        }

    }
    
}
  
