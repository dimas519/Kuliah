/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package floodfilltester;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.LinkedList;
public class FloodFillTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            int screen[][] = {
                    {0, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 1, 1, 1, 0, 0, 1, 0},
                    {1, 1, 1, 1, 0, 1, 1, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 1, 1, 1, 1, 1, 1, 1},
                    };
            FloodFill ff=new FloodFill(screen,8);
                ff.loop();
                System.out.println(ff.jumlah);

            
    }
    
}



class FloodFill{
    LinkedList <Integer> x=new LinkedList();
    LinkedList <Integer> y=new LinkedList();
    int arr[][];
    int ukuran;
    int jumlah=0;
    int kotak=0;
    
    public FloodFill(int [][] arr,int size){
        this.arr=arr;
        this.ukuran=size;
    }
    
    public void loop(){
        for(int i=0;i<ukuran;i++){
            for(int j=0;j<ukuran;j++){
                if(arr[i][j]!=0){
                    x.push(i);
                    y.push(j);
                    ffProcess();
                    jumlah++;
                    System.out.println("kotak"+kotak);
                    kotak=0;
                }
            }
        }
        
        
    }
    
    
    public void ffProcess(){
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
            
            if(check(i,j-1)){
                x.push(i);
                y.push(j-1);
            }    
        }  
    }
    public boolean check(int x,int y){
        if(x<0||x>=ukuran || y<0 || y>=ukuran){
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
