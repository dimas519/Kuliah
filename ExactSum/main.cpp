/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: USER
 *
 * Created on January 10, 2021, 3:59 PM
 */

#include <cstdlib>
#include <stdio.h>
#include <stdlib.h>


using namespace std;

/*
 * 
 */
int compare (const void * a, const void * b)
{

    int arg1 = *(int*)a;
    int arg2 = *(int*)b;
    
    
 
    if (arg1 < arg2) {
        return -1;
    } else if (arg1 > arg2){
        return 1;
    } else {
    return 0;
    }
}


int main(int argc, char** argv) {
    int size=0;
    
    
   
    int arr[10000];
    
    

    while (scanf("%d", &size) != EOF){
    
    int i=0;
    for(i=0;i<size;i++){
        scanf("%d",&arr[i]);
    }
    int cari;
     scanf("%d", &cari);
     int j=0;
     int kiri=0,kanan=0;
     
qsort (arr, size, sizeof(int), compare);


     for (i=0;i<size ;i++){
         for (j=i+1; j<size ;j++){
             if(arr[i]+arr[j]==cari){
                 kiri=(int)i;
                 kanan=(int)j;
                     
                }
             }
         }
     
     printf("Peter should buy books whose prices are %d and %d.\n\n",arr[kiri],arr[kanan]);
     
     
    }
    
    
    return 0;
}



    
    
    
    

