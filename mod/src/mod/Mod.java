/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
public class Mod {

    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
      int m,n;
              
              n=sc.nextInt();
              m=sc.nextInt();
              
              while (m!=0 && n!=0){
                  System.out.println(n+" "+m);
                  
                  int arr[]=new int[n];
                  int mod[]=new int[n];
                  int i=0;
                  for (i=0;i<n;i++){
                      int angka=sc.nextInt();
                  
                      arr[i]=angka;
                      
                      mod[i]=angka%m;
                      
                      
                  }
                  
                  
                  
                  insertion(mod,n,arr);
                  
                  
                  
                  
                  
                  
                  
                  
                  for(i=0;i<n;i++){
                      System.out.println(arr[i]);
                  }
                  
                  
                  
                  
                  
              n=sc.nextInt();
              m=sc.nextInt();
              }
              
              
    }
    




static void insertion (int[] array,int panjang,int[] awal){
        int i=0;

        int temp;
        while (i<panjang){
            int u=i;
            while((u>0)&&(array [u-1] >= array[u])){
                
                if(array[u-1]==array[u]){
                    
                    
                    
                    
                    
                    
                    
                    if (array[u-1]%2==1 &&array[u]%2==1 ){
                        if(awal[u-1]> awal[u]){
                            temp=array[u-1];
                            array[u-1]=array[u];
                            array[u]=temp;
                            
                            temp=awal[u-1];
                            awal [u-1]=awal[u];
                            awal[u]=temp;
                        }
                        
                    
                    
                    
                    
                    
                    
                } else  if (array[u-1]%2==0 && array[u]%2==1 ){
                            temp=array[u-1];
                            array[u-1]=array[u];
                            array[u]=temp;
                            
                            temp=awal[u-1];
                            awal [u-1]=awal[u];
                            awal[u]=temp;

                            
                        }
                            
                        }
                
                else {
                           temp=array[u-1];
                            array[u-1]=array[u];
                            array[u]=temp;
                            
                            temp=awal[u-1];
                            awal [u-1]=awal[u];
                            awal[u]=temp;

                          
                        
                        
                    }
                u--;
                
                
  
        }
            i++;
        }
    //return array;
    }

}