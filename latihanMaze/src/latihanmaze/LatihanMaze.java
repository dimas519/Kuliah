/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanmaze;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.LinkedList;

public class LatihanMaze {
    public static void main(String[] args) {
        int labirin[][]={
    {2,1,1,1,1},
    {1,0,0,0,1},
    {1,0,0,0,1},
    {1,0,0,0,1},
    {0,0,0,0,0}
      
        };
        
        
        Maze maze=new Maze(5,5,labirin,4,4);
        maze.cariStartFinish();
        System.out.println(maze.path());
        
        
    }
    
}

class Maze {
    
    LinkedList <Integer> x =new LinkedList<>();
    LinkedList <Integer> y =new LinkedList<>();
    
    int arr[][];
    boolean mark[][];
    int baris;
    int kolom;
    
    
    int endX;
    int endY;
    
    
    public Maze(int baris,int kolom,int arr[][],int endX,int endY){
        this.baris=baris;
        this.kolom=kolom;
        this.arr=arr;
        mark=new boolean[baris][kolom];
        this.endX=endX;
        this.endY=endY;
    }
    
   
    
    
    public void cariStartFinish(){
        int i=0;
        int j=0;
        
        for(i=0;i<baris;i++){
            for(j=0;j<kolom;j++){
                if(arr[i][j]==2){
                    x.addFirst(i);
                    y.addFirst(j);
                    mark[i][j]=true;
                    
                }

            }
        }       
    }
    
    public void keKiri(int i,int j){
        
        while (j>0){
            if(j>0 &&arr[i][j]==1 && mark[i][j]==false){
                x.addLast(i);
                y.addLast(j);
                mark[i][j]=true;
            }
       j--;
        }
    }
    
    public void keKanan(int i,int j){
        while (j<kolom){
            if(j<kolom && arr[i][j]==1 && mark[i][j]==false ){
                x.addLast(i);
                y.addLast(j);
                mark[i][j]=true;
            }
       j++;
        }
    }
    
    public void keAtas(int i,int j){
        while (i>0){
            if(i> 0 && arr[i][j]==1 && mark[i][j]==false){
                x.addLast(i);
                y.addLast(j);
                mark[i][j]=true;
            }
       i--;
        }
    }
    
    public void keBawah(int i,int j){
        while (i<baris){
            if(i<baris && arr[i][j]==1 && mark[i][j]==false){
                x.addLast(i);
                y.addLast(j);
                mark[i][j]=true;
            }
       i++;
        }
    }

    
    
        int idx=0;
        
        
    public boolean path(){
       
       
       int horizontal=0;
       int vertikal=0;
       
       
       if(!x.isEmpty()){ 
        horizontal=(x.removeFirst());
        vertikal =(y.removeFirst());
       } else {
           return false;
       }
        
     if(horizontal==endY && vertikal==endX){
        System.out.println(vertikal+" "+horizontal);
        return true;
      } else {
        
        
        System.out.println(vertikal+" "+horizontal);
        
        keKanan(vertikal,horizontal);
        keBawah(x.peekLast(),y.peekLast());
        keKiri(x.peekLast(),y.peekLast());
        keAtas(x.peekLast(),y.peekLast());
        
     

        
        idx++;
        return path();
        }
        
        
        
    }


}
