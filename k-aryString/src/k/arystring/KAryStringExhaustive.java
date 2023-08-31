/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k.arystring;

/**
 *
 * @author USER
 */
public class KAryStringExhaustive {

    /**
     * @param args the command lin arguments
     */
    public static void main(String[] args) {
       kAryString kas=new kAryString(3);
       
       kas.generatekAryString();
    }
    
}


class kAryString{
    protected int[] result;
    protected int k;

    
    
    public kAryString(int k){
        result=new int[k];
        this.k=k;

    }
    
    protected void generatekAryStringrek(int curIdx){
        if(curIdx==-1){
            for(int i=0;i<k;i++){
                System.out.print(result[i]);  //ganti ininya
            }
            System.out.println("");
        }
        else {
            for(int i=0;i<k;i++){
                result[curIdx]=i;
                generatekAryStringrek(curIdx-1);
            }
        }
    }
    
    public void generatekAryString(){
        generatekAryStringrek(k-1);
    }    
}