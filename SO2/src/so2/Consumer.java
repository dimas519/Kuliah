/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so2;

/**
 *
 * @author Kurni
 */
public class Consumer extends Thread {
    private int start;
    private int end;
    private long processLength;
    private int hasil;
    private indexing idx;
    
    public Consumer(indexing idx,int start,int end){

        this.start=start;
        this.end=end;
        this.idx=idx;
    }
    
    
    
    @Override
    public void run(){
        countingCounter();
    }
    
    
    public void countingCounter(){
        
        long mulai=System.nanoTime();
        int res=0;
        for(this.start=this.start;this.start<this.end;this.start++){
            try{
                Thread.sleep((int)Math.random());
                res+=idx.out();
            }catch(Exception e){
                
            }
            
            
            
        }
        long end=System.nanoTime();
        
        this.processLength=end-start;
        this.hasil=res;
    }
    
    public int getHasil(){
        return this.hasil;
    }
    
    public long getLength(){
        return this.processLength;
    }
    
    
    
    
    
}
