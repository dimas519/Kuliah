/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.womboking;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
public class DAAWOMBOKING {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (1==1){
        
        int baris=sc.nextInt();
        int kolom=sc.nextInt();
        int arr[][]=new int[baris][kolom];
        
        if(baris==0 && kolom ==0){
            break;
        }
            
        
        
        for (int i=0;i<baris;i++){
            for(int j=0;j<kolom;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        
        dp d= new dp(arr,baris,kolom);
        d.count();
        
        System.out.println(d.terbesar);
        }
    }
}

class dp{
    int terbesar=0;
    int arr[][];
    int baris;
    int kolom;

    
    public dp(int graph[][],int baris,int kolom){
        this.arr=graph;
        this.baris=baris;
        this.kolom=kolom;
    }
    
    public void count(){
        
        for(int i=0;i<baris;i++){
            for (int j = 0; j < kolom; j++) {
                if(arr[i][j]==0){
                int counter=0;
                int x=baris;
                int y=kolom;
                
                
                for(int p=i; p<x;p++){
                    for(int l=j;l<y;l++){
                        if(arr[p][l]==1){
                            if(counter==0){
                                y=l;
                                counter=1;
                                break;
                            }else{
                                x=p;
                                break;
                            }
                        }
                    }
                }
                    x=(x==0) ? 1:x;
                    y=(y==0) ? 1:y;
                    int count= (y-j) *(x-i);
                    if (count >terbesar){
                        terbesar=count;
                    }
                }
            }
        }
    }
}

