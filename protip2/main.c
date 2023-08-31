/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Dimas
 *
 * Created on October 27, 2020, 2:38 PM
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




int main() {
    int n,t;
    scanf("%d %d",&n,&t);
     int arr[n];
    int i=0;
    for (i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
    
    
    
    if(t==1){
        int logic=0;
        int angka=7777;
        int j=0;
        for (i=0;i<n    &&logic ==0;i++){
            angka=arr[i];
            for (j=i+1;j<n  &&logic ==0;j++){
                if (angka+arr[j]==7777){
                    printf("Yes\n");
                    logic=1;
                    break;
                }
            }
        }
        if(logic==0){
            printf("No\n");
        }   
        
        
        
        
        
        
        
        
        
    } else if (t==2){
       int logic=0;
        qsort(arr, n, sizeof(int),compare);   
        i=0;     
        while (i<n-1 && logic==0){
            if(arr[i]==arr[i+1]){
                logic=1;
                break;
            }
            i++;
        }
        if(logic==0){
            printf("Unique\n");
        } else if (logic==1){
            printf("Contains duplicate\n");
        }  
        
         
    } else if(t==3){
        int bagi=n/2;

        
        int print=-1;
        int count =1;
        int logic=0;
         qsort(arr, n, sizeof(int),compare);
         
         i=0;
         
         while (i+1<n  &&logic ==0){
             if (arr[i]==arr[i+1]){
                 count++;
             } else if (count>n/2){
                 print=arr[i];
                 i=n;
                 logic=1;
                 break;
             } else {
                 count=1;
                 
             }
             i++;
             }
         
         
         printf("%d\n",print);
         
   
             
             
    }  else if (t==4){
         qsort(arr, n, sizeof(int),compare);
         if(n%2==1){
             printf("%d\n",arr[n/2]);
         } else if (n%2==0){
             printf("%d %d\n",arr[(n/2)-1],arr[n/2]);
         } 
         
    }
         else if (t==5){
         qsort(arr, n, sizeof(int),compare);
         int print=0;
         int logic=0;
         for (i=0;i<n  &&logic==0;i++){
             int angka=arr[i];

            if(angka>=100 && angka<=999){
                 if (print!=0){
                 printf(" ");
                 }
                 printf("%d",angka);
                 print=1;
             }  else if (angka>999){
                 logic=1;
                 i=n;
                 break;
             }
             
         }
         printf("\n");
    }
         
         
    
        
        
       
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    return 0;
    
    
}

