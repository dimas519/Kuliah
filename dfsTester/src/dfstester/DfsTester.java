/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfstester;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Stack;
public class DfsTester {
    public static void main(String[] args) {
       
        dfs dfs =new dfs(12);
        
        dfs.setArr(0,1);
        dfs.setArr(1,2);
        dfs.setArr(1,4);
        
        dfs.setArr(2,3);
        dfs.setArr(2,5);
        dfs.setArr(2,7);
        dfs.setArr(2,8);
        
        
        dfs.setArr(3,4);
        dfs.setArr(3,9);
        dfs.setArr(3,10);
        
        dfs.setArr(5,6);
        dfs.setArr(5,7);
        dfs.setArr(5,8);
        
        dfs.setArr(7,8);
        
        System.out.println(0);
        dfs.telusuri(0);
        
    }
    
}



class dfs{
    Stack<Integer> stack =new Stack<Integer>();
    int arr[][];
    int vertex;
    boolean kunjungan[];
    
    public dfs(int vertex){
        this.vertex=vertex;
        arr=new int[vertex][vertex];
        kunjungan =new boolean [vertex];
    }
    
    public void setArr (int a,int b){
        arr[a][b]=1;
        arr[b][a]=1;
    }
    
    
    public int telusuri (int start){
        
        kunjungan[start]=true;
        for (int i=0;i<vertex;i++){
            
            if(arr[start][i]==1 && kunjungan[i]==false ){
                System.out.println(i);
                kunjungan[i]=true;

                
                arr[start][i]=0;
                arr[i][start]=0;
                stack.push(start);
                stack.push(i);
                return telusuri (i);
            }
            
        }
        
        
        if(stack.empty()){
            return 0;
        }else {
            int temp=stack.peek();
            
            
        
           
           
            
            
            
       return telusuri (stack.pop());
        }
        
        
        
    
        
    }
        
        
        
        
        
        
        
   
    
    
    
    
    
    
    
    
}