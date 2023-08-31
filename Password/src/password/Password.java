/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package password;

/**
 *
 * @author USER
 */
import java.util.Arrays;
import java.util.Scanner;
public class Password {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner sc=new Scanner (System.in);
       mat math =new mat ();
       String input=sc.next();
       int panjang =input.length();
       int ukuran = math.factorial(panjang);
       Permutasi p=new Permutasi(panjang,ukuran,input );
       
       

       String arr[] =new String[ukuran];
       p.generatePermutasi();
       arr=p.getHasil();
       Arrays.sort(arr);
       
for (int i=0;i<ukuran;i++){
System.out.println(arr[i]);

}








    }

}

class mat{
    private int res=1;
    public int factorial (int n){
        if(n==1){
                return res;
        } else {
            res=res*n;
            return factorial(n-1)
            }
        }
}



class Permutasi{
    protected int[] result;
    protected boolean[] mark;
    public String[] gabungan;
    protected int size;
    protected String input;
    
    public Permutasi(int n,int ukuran,String input){
        this.result=new int [n];
        this.mark=new boolean[n];
        this.gabungan=new String[ukuran];
        this.size=ukuran;
        this.input=input;
    }
    
    protected void generatePermutasiRek(int curIdx){
       if(curIdx==-1){
           int i=1;
           if(i==1){
           process();
           i+=1;
           }
       } else {
           for (int i=0;i<result.length;i++){
               if(this.mark[i]==true){
                   this.mark[i]=false;
                   result[curIdx]=i;
                   generatePermutasiRek(curIdx-1);
                   this.mark[i]=true;
               }
           }
       }
    }
        
       public void process(){
       String a="";

        for (int i=0;i<result.length;i++){
        a=a+input.charAt(result[i]);
        }
        
        for (int i=0;i<size;i++){
            if (gabungan[i]==null){
            gabungan[i]=a;
            break;
            }
        }

}

    public String[] getHasil(){
    return gabungan;
}





        
        public void generatePermutasi(){
        for(int i=0;i<this.mark.length;i++){
            this.mark[i]=true;
        }
        generatePermutasiRek(this.result.length-1);
        }
 
    }
