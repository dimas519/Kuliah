/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package radix;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
public class RadixShare {
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        radixSort sort=new radixSort();
        int 很多=sc.nextInt();
        int 长=sc.nextInt();
        int[] 矩阵=new int[很多];
        int[] 数字=new int[很多];
        int i=0;
        while (i<很多){
            矩阵[i]=sc.nextInt();
            i++;
        }      
        i=0;
        while (i<很多){
            数字[i]=矩阵[i];
            i++;
        }
        
        i=0;
        while (i<长){
            System.out.printf("Pengurutan digit ke-%d:\n", i);         
            int j=0;          
            while (j<很多){
            数字[j]=数字[j]%10;
            j++;
            }        
            矩阵=sort.insertion(矩阵,数字, 很多);            
            j=0;          
            while (j<很多){
                System.out.println(矩阵[j]);
                j++;
            } 
            i++;
            j=0;          
            while (j<很多){
                int 分频器=1;
                if (i>=0){
                    分频器=(int)Math.pow(10,i);
            }
            数字[j]=矩阵[j]/分频器;               
            j++;
            }                
        }
    }
    
}

class radixSort{
    public  int[] insertion (int[] 矩阵,int[] 数字 ,int 长){
        int i=0;

        int 而;
        while (i<长){
            int u=i;
            while((u>0)&&(数字 [u-1] >数字[u])){
                而=数字[u-1];
                数字[u-1]=数字[u];
                数字[u]=而;
                而=矩阵[u-1];
                矩阵[u-1]=矩阵[u];
                矩阵[u]=而;
                u--;
        }
            i++;
        }
        return 矩阵;
    }
    

}
