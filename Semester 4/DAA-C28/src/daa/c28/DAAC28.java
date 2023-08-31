/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.c28;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
public class DAAC28 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int kasus=sc.nextInt();
        for (int i = 0; i < kasus; i++) {
            int panjang=sc.nextInt();
            int num=0;
            int arr[]=new int[panjang];
            String sawah=sc.next();
            for(int u=0;u<panjang;u++){
                char x=sawah.charAt(u);
//                System.out.println(x);
                if(arr[u]==0){
                    if(x=='.'){
                        arr[u]=1;
                        num++;
                        if(u+1<panjang){
                            arr[u+1]=1;
                        }

                        if(u+2 < panjang){
                            arr[u+2]=1;
                        }
                    }
                }
            }
            

            System.out.printf("Case %d: %d\n",i+1,num);
            
            
            
        }
    }
    
}
