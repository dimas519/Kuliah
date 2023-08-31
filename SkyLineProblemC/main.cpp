/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Dimas
 *
 * Created on December 21, 2020, 11:13 AM
 */





#include <cstdlib>
#include <stdio.h>
#include <stdlib.h>
#include <string>
#include <iostream>
using namespace std;

/*
 * 
 */
void kosong (int arr[20001],int banyak){
    int i=0;
    for (i=0;i<banyak;i++){
        arr[i]=0;
    }
    
    
}



int main(int argc, char** argv) {

    int kiri=0;
    int tinggi=0;
    int kanan=0;
    
    int arr[20001];
    
    kosong(arr,20001);
    int max=0;
    
     scanf("%d %d %d",&kiri,&tinggi,&kanan)  ;
     int min=kiri;
    
     do{
    for (kiri=kiri;kiri<kanan;kiri++){
        if(arr[kiri] <tinggi){
            arr[kiri]=tinggi;
        }
    }
    
    
    
    if (max<kanan){
    max=kanan;
    }
   }  while ( scanf("%d %d %d",&kiri,&tinggi,&kanan)  !=EOF) ;

   int temp =arr[min];
   
   printf("%d ",min);
   printf("%d",temp);
   min++;
    for (min=min;min<=max;min++){
        
        if(arr[min]!= temp){
               printf(" %d",min);
               printf(" %d",arr[min]);
               temp=arr[min];
        }
    
    }
   printf("\n");
    return 0;
}

