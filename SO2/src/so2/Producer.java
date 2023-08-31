/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so2;

/**
 *
 * @author Kurni
 */
public class Producer extends Thread  {
   
    private int arr[];
    private int start;
    private int end;
    private long processLength;
    private indexing idx;
    
    public Producer(indexing idx,int arr[],int start,int end){
        this.arr=arr;
        this.start=start;
        this.end=end;
        this.idx=idx;
    }
    
    
    
    @Override
    public void run(){
        countingCounter();
    }
    
    
    public void countingCounter(){
        
      
        for(this.start=this.start;this.start<this.end;this.start++){
            
            try{
                Thread.sleep((int)Math.random());
                idx.in(arr[this.start]);
                
            }catch(Exception e){
                
            } 
        }
        
        System.out.println("Producer selesai");
        
    }
    
 
    
    public long getLength(){
        return this.processLength;
    }
    
    
    
}
