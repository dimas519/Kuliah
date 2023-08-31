/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Dimas
 *
 * Created on October 27, 2020, 1:16 PM
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */



int compare (const void * a, const void * b)
{

    int arg1 = *( int*)a;
    int arg2 = *(int*)b;
    
    
 
    if (arg1 < arg2) {
        return -1;
    } else if (arg1 > arg2){
        return 1;
    } else {
    return 0;
    }
}


int main(int argc, char** argv){
    long int n;
    int t;
    scanf("%li %d\n",&n,&t);
    int array[n];
    
    
    int i=0;
    for(i=0;i<n;i++){
        scanf("%d",&array[i]);
    }
    if(t==1){
        printf("%d\n",7);
    } else if (t==2){
        if(array[0]>array[1]){
            printf("Bigger\n");
        } else if (array[0]==array[1]){
            printf("Equal\n");
        }   else if(array[0]<array[1]){
            printf("Smaller\n");
        }
    } else if(t==3){
       qsort(array, 3, sizeof(int),compare);
        printf("%d\n",array[1]);
         
    } else if(t==4){
         long int total=0;
        for(i=0;i<n;i++){
        total+=array[i];
        }
        printf("%ld\n",total);
    } else if(t==5){
       long int total=0;
        for(i=0;i<n;i++){
            int angka=array[i];
            if(angka%2==0){
            total+=angka;
            }
        }
        printf("%ld\n",total);
               
    } else if (t==6){
        for(i=0;i<n;i++){
            int angka=array[i];
            angka=angka%26;
            angka=angka+97;
            printf("%c",angka);
        }
        printf("\n");
    } else if (t==7){
            int idx=0;
                int logic=0;    
        while ((logic==0)){

         if (idx==n-1){
             printf("Done\n");
             logic=1;
             break;
        } else if (idx>n-1){
            printf("Out\n");
            logic=1;
            break;
        }
         int temp=array[idx];
         array[idx]=-1000;
         idx=temp;

        if(array[idx]==-1000){
              printf("Cyclic\n");
              break;
              logic=1;
          }

        
         
        
            }
  
    }
            
            
            
            
            
            
            
        
    
    
    return 0;
    
}
            
    
    
    
    
    
    
    


