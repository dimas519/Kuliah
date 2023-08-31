/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package uas3;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

public class Uas3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int kasus=sc.nextInt();
        
        for(int i=0;i<kasus;i++){
            int hasil =0 ; 
            PriorityQueue<Integer> pq = new PriorityQueue<>(100, Collections.reverseOrder());
            Stack <Integer> s=new Stack<>();
            Queue<Integer> q= new LinkedList<>(); 
            
            int banyak=sc.nextInt();
            
   
            boolean sta=true;
            boolean que=true;
            boolean prq=true;
            
            
            for (int j=0;j<banyak;j++){
                int perintah=sc.nextInt();
                int kode=sc.nextInt();
                
                
                if(perintah==1){
                    pq.add(kode);
                    s.add(kode);
                    q.add(kode);
                } else {
                    int outpq=-1;
                    int outs=-1;
                    int outq=-1;
                    if(pq.size()!=0){
                    outpq=pq.poll();
                    } 
                    
                    if(s.size()!=0){
                    outs=s.pop();
                    } 
                    
                    if(q.size()!=0){
                    outq=q.poll();
                    }
                    
//                    System.out.println(outpq);
                    if(outpq!=kode){
                        prq=false;
                    } 
                    if(outs!=kode){
                        sta=false;
                    }
                    if(outq!=kode){
                        que=false;
                    }
    
                }
                
            }
            

            if( (que &&prq) || (que&&sta) || (sta&&prq) ){
                System.out.println("not sure");
            }else if(prq){
                System.out.println("priority queue");
            }else if(que){
                System.out.println("queue");
            }else if(sta){
                System.out.println("stack");
            }else {
                System.out.println("impossible");
            }
            
            
            
            
            
            
            
            
            

        }
        
        
    }
    
}
