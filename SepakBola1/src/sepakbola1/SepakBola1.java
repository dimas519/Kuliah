/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package sepakbola1;
 
/**
 *
 * @author Dimas
 */
import java.util.Scanner;
public class SepakBola1 {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        sort sort=new sort();
        int jumlah=sc.nextInt();
 
        
        int [] perolehan=new int[jumlah];
        String [] tim=new String[jumlah];
        int [] temp=new int[jumlah];
        int i=0;
        
        while ( (i<jumlah) &&(jumlah >=3) &&  (jumlah<=100) && (perolehan[i]<=100)) {

            perolehan[i]=sc.nextInt();
            tim[i]=sc.next();
            i++;
        }
   sort.selection(perolehan,tim,jumlah);       
       
     i=0;
   while (i<3){
       if(i!=0){
           System.out.print(" ");
       }
           System.out.print(tim[i]);
           
           i++;
       }
       System.out.println("");
        
     
     
     
     
     
    }
}
class sort {
    
     
    public String[] selection (int[] array,String[] tim,int panjang){
        int i=0,j,min,temp;
        String tempTeam="";
        while (i<panjang-1){
            min=i;
            j=i+1;
            while(j<panjang){
                if(array[j]>array[min]){
                    min=j;
            } 
            j++;
        }
            temp=array[min];
            array[min]=array[i];
            array[i]=temp;
            
            
            tempTeam=tim[min];
            tim[min]=tim[i];
            tim[i]=tempTeam;
            
    
            i++;
        }
    }
    
}