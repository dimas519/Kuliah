/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so2;

/**
 *
 * @author Kurni
 */
public class split {
    
    public static int numOfThreads(int n){
       if(n<=50000){
           return 1;
       }else if(n<100000){
           return 2;
       }else if(n<500000){
           return 3;
       }else if(n<1000000){
           return 4;
       }else {
           return 5;
       }
    }
    
}
