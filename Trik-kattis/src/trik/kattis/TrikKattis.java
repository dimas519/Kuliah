/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trik.kattis;
import java.util.Scanner;
/**
 *
 * @author Dimas Kurniawan
 */
public class TrikKattis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cups[]={1,0,0};
        String perintah=sc.next();
        int panjang=perintah.length();
        
        tukar t=new tukar();
        
        for(int i=0;i<panjang;i++){
            char pos=perintah.charAt(i);
            
            if(pos=='A'){
                t.swap(cups, 0, 1);
            }else if(pos=='B'){
                t.swap(cups,1,2);
            }else if(pos=='C'){
                t.swap(cups,0,2);
            }
            
        }
        
        
        
        for(int i=0;i<3;i++){
            if(cups[i]==1){
                System.out.println(i+1);
                break;
            }
        }
        
        
    }
    
}


class tukar<Integer>{

    public void swap(int[] arr,int satu,int dua){
        int temp=arr[satu];
        arr[satu]=arr[dua];
        arr[dua]=temp;

    }




}