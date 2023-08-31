/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onechicken;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
public class OneChicken {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int minta=sc.nextInt();
        int punya=sc.nextInt();
        int sisa=punya-minta;
        
        if(sisa>0){
            if(sisa>1){
            System.out.printf("Dr. Chaz will have %d pieces of chicken left over!\n",sisa);
            }else {
               System.out.printf("Dr. Chaz will have %d piece of chicken left over!\n",sisa);
            }
        }else {
            if(sisa==-1){
                System.out.printf("Dr. Chaz needs 1 more piece of chicken!\n");
            }else {
                System.out.printf("Dr. Chaz needs %d more pieces of chicken!\n",Math.abs(sisa));
            }
        }
        
        
    }
    
}
