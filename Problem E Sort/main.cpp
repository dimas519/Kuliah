/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Dimas
 *
 * Created on December 19, 2020, 1:01 PM
 */

#include <cstdlib>

#include <stdio.h>
#include <stdlib.h>
#include <string>
#include <iostream>

using namespace std;

void settingArr(int arr[1001],int idx[1001],int max){
    int i=0;
    for (i=0;i<max;i++){
        idx[i]=0;
        arr[i]=0;
        
    }
}

void insertion (int idx[100],int arr[100],int panjang){
    int i=0;
    int temp;
    while (i<panjang){
    
    int u=i;

    while((u>0)&&(idx [u-1]  < idx[u])){
        temp=arr[u-1];
         arr[u-1]=arr[u];
          arr[u]=temp;
        
          temp=idx[u-1];
          idx[u-1]=idx[u];
          idx[u]=temp;
          u--;
    }
    i++;
}
}


int main(int argc, char** argv) {
    int banyak,max;
    scanf("%d",&banyak);
    scanf("%d",&max);
      
    int i=0;
    int arr[banyak];
    int biji[banyak];
    
    settingArr(arr,biji,banyak);
    
    int l=0; // menentukan berapa buah yg unik
    
    
    for (i=0;i<banyak;i++){
         int input;
        scanf("%d",&input);
        int ada=0;
        int u=0;
        
        
        for (u=0;u<l;u++){
        
            if(input==arr[u]){
                biji[u]=biji[u]+1;
                ada =1;
                break;
            }   
        }
        
        
        if (ada==0){
            
            arr[l]=input;
            biji[l]=1;
            l++;
        }
        
        
        
        
    }
    
    

    
    
    
    insertion(biji,arr,banyak);
    
    
    for (i=0;i<l;i++){
        int jum=biji[i];
        int j=0;
        for (j=0;j<jum;j++){
            if (j!=0||i!=0){
                printf(" ");
            }
        printf("%d",arr[i]);
        }
    }
    printf("\n");
    return 0;
}

