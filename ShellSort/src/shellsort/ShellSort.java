/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shellsort;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
public class ShellSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        SortShell1 sort =new SortShell1();
        int ukuran=sc.nextInt();
        int [] array=new int[ukuran];
        int i=0,index,u;
        while ((i<ukuran)&& (ukuran>=0) &&(ukuran<=1000)){
            array[i]=sc.nextInt();
            i++;
        }
        int jumlah=sc.nextInt();
        i=0;
        
        
        
        while ( (i<jumlah)&& (jumlah>=0) && (jumlah <=10)) {
            index=sc.nextInt();
            sort.urut(array,ukuran,index);
            u=0;
            while (u<ukuran) {
            System.out.print(array[u]+" ");
            u++;
            }
            System.out.println("");
            i++;
        }
    }
    
}

class SortShell1{
    public  int[] urut(int[] arr,int ukuran,int index){
        int i=0,temp;
        while (index<ukuran){
            if(arr[index]<arr[i]){
                temp=arr[index];
                arr[index]=arr[i];
                arr[i]=temp;
            }
            index++;
            i++;
        }
        return arr;
    }
}