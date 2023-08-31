/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.a10;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
public class DAAA10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int size=sc.nextInt();
        while (size!=0){
             cost c=new cost();
            int arr[]=new int[size];
            for(int i=0;i<size;i++){
                arr[i]=sc.nextInt();
            }
            int prize=c.setUp(arr, size);
            System.out.println(prize);
            size=sc.nextInt();
        }
    }
    
}
class cost{
    PriorityQueue<Integer> pq = new PriorityQueue<>(100);
    public int setUp(int arr[] ,int size){
        for(int i=0;i<size;i++){
            pq.add(arr[i]);
        }
        return countCost();
    }
    
    private int countCost(){
        int cost=0;
        while(pq.size()>1){
           int a=pq.poll();
           int b=pq.poll();
           int skrg=a+b;
           pq.add(skrg);
           cost+=skrg;
        }
        return cost;
    }
}
