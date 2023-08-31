/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.d06;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
import java.util.Stack;
public class DAAD06 {

    /**
     * 
     * logikanya gunakan matriks kunjungan dfs jika default nya(false) maka lakukan dfs untuk menandakan ada
     * setiap menemukan false (belum terkoneksi) maka tambahkan 1 karena dia belum terkoneksi kemana pun.
     * terakhir print counter nya
     * 
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int vertex=sc.nextInt();

        int adjMatriks[][]=new int[vertex][vertex];
        
        for(int i=0;i<vertex;i++){
            for(int j=0;j<vertex;j++){
                adjMatriks[i][j]=sc.nextInt();
            }
        }
        
        boolean check[]=new boolean[vertex];
        int banyak=0;
        
        for(int i=0;i<vertex;i++){
            boolean test=check[i];
            if(!test){
                DFS d=new DFS(vertex,adjMatriks,check);
                d.telusuriDFS(i);
                banyak++;
                
            }
            
            
        }
        
        System.out.println(banyak);
        
        
    }
    
}

class DFS{
    Stack<Integer> stack =new Stack<Integer>();
    boolean[] kunjunganDFS;
    int adjMatriks[][];
    int vertex;
    
    public  DFS(int N ,int[][] adjMatriks, boolean [] check) {
        this.vertex=N;
        this.adjMatriks=adjMatriks;
        this.kunjunganDFS=check;
 
    }
    
    public int telusuriDFS (int start){
        
  
        
        kunjunganDFS[start]=true;
        
        for (int i=0;i<vertex;i++){
            
            if(adjMatriks[start][i]==1 && kunjunganDFS[i]==false ){
     
                kunjunganDFS[i]=true;
                
                stack.push(start);
                stack.push(i);
                return telusuriDFS (i);
                
            }           
        }  
        
        
        if(stack.empty()){
            return -1;
        }else {
           int temp=stack.pop();                  
       return telusuriDFS (temp);
        } 
    }
    
    
    
    
    
    
}