/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.a21;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Dimas Kurniawan
 */
public class DAAA21 {

    /**
     * @param args the command line arguments
     * 
     * 
     * gunakan algoritma flood fill untuk mencari ada berapa banyak sumber minyak
     * flood fill yang digunakan adalah floodfill yang mengkalkulasi ke 8 arah bukan yang 4 arah
     * 
     * cara melakukan flood fillnya pertama dengan looping jika menemukan sebuah 1 titik saja minyak
     * maka lakukan flood fill untuk menandakan minyak(ditandai dengan mengganti yg array menjadi 0).
     * kemudian loop lagi ke atas(mencari 1 titik minyak) jika sudah sepenuhnya terflood fill maka
     * output jumlah loop yang tadi dilakukan
     * 
     * 
     * 
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int baris=sc.nextInt();
        int kolom=sc.nextInt();
        
        while (baris!=0 || kolom!=0){
        int adj[][]=new int[baris][kolom];
        
        for(int i=0;i<baris;i++){
                String in=sc.next();
                for(int j=0;j<kolom;j++){
                    char input=in.charAt(j);
                
                if(input=='@'){
                    adj[i][j]=1;
                }else {
                    adj[i][j]=0;
                }
            }
        }
        
        FloodFill ff=new FloodFill(adj,baris,kolom);
        ff.loop();
        
        System.out.println(ff.jumlah);
        baris=sc.nextInt();
        kolom=sc.nextInt();
        }
        
    }
    
}




class FloodFill{
    LinkedList <Integer> x=new LinkedList();
    LinkedList <Integer> y=new LinkedList();
    int arr[][];
    int baris;
    int kolom;
    int jumlah=0;
    int kotak=0;
    
    public FloodFill(int [][] arr,int baris, int kolom){
        this.arr=arr;
        this.baris=baris;
        this.kolom=kolom;
    }
    
    public void loop(){
        for(int i=0;i<baris;i++){
            for(int j=0;j<kolom;j++){
                if(arr[i][j]!=0){
                    x.push(i);
                    y.push(j);
                    ffProcess();
                    jumlah++;
//                    System.out.println("kotak"+kotak);
                    kotak=0;
                }
            }
        }
        
        
    }
    
    private void ffProcess(){
        while (!x.isEmpty()){
            int i=x.pop();
            int j=y.pop();
            if(check(i+1,j)){
                x.push(i+1);
                y.push(j);
            }
            if(check(i-1,j)){
                x.push(i-1);
                y.push(j);
            }
            if(check(i,j+1)){
                x.push(i);
                y.push(j+1);
            }
            if(check(i,j-1)){
                x.push(i);
                y.push(j-1);
            }
            
            if(check(i+1,j+1)){
                x.push(i+1);
                y.push(j+1);
            }
             if(check(i+1,j-1)){
                x.push(i+1);
                y.push(j-1);
            }
              if(check(i-1,j+1)){
                x.push(i-1);
                y.push(j+1);
            }
               if(check(i-1,j+-1)){
                x.push(i-1);
                y.push(j-1);
            }  
        }  
    }
    private boolean check(int x,int y){
        if(x<0||x>=baris || y<0 || y>=kolom){
            return false;
        } else if(arr[x][y]==1){
            arr[x][y]=0;
            kotak++;
            return true;
        }else {
            return false;
        }
    } 
    }