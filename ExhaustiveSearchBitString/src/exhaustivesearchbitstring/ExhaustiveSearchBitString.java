/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exhaustivesearchbitstring;

/**
 *
 * @author USER
 */
public class ExhaustiveSearchBitString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       bitString bs=new bitString(4);
       
        
        bs.generateBitString();

        
    }
    
}



class bitString {
    protected int[] result;
    public bitString(int n){
        result=new int[n];
    }
    
    protected void generateBitStringRek(int curIdx){
        if(curIdx==-1){
            int i=1;
            if(i==1){
                
            
        process();
        
        i++;
            }
    }
        else {
        result[curIdx]=0;
        generateBitStringRek(curIdx-1);
        result[curIdx]=1;
        generateBitStringRek(curIdx-1);
    }  
    }
    
    protected void process(){
        for (int i=0;i<result.length;i++){    //keluar 1 dimmensi
            if(result[i]==1)                 
            System.out.print(result[i]);
        }
        System.out.println("");
    }

    
    public void generateBitString()
    {
        generateBitStringRek(result.length-1);
    }    
    

        }