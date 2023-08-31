/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: USER
 *
 * Created on January 19, 2021, 1:57 PM
 */

#include <cstdlib>
#include <stdio.h>



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
    int kasus;
    scanf("%d", &kasus);
    
    for (int i=1;i<=kasus;i++){
        int banyak;
       scanf("%d", &banyak);
       int arr[banyak];
       for (int j=0;j<banyak;j++){
           scanf("%d", &arr[j]);
       }
       
       
       qsort (arr, banyak, sizeof(int), compare);
       int l=0;
       int r=1;
       
       while (r<banyak){
           if(arr[l]==arr[r]){
               l+=2;
               r+=2;
           } else {
               break;
           }
       }
        
       printf("Case #%d: %d\n",i,arr[l]);
        
        
        
        
        
        
    }
    return 0;
}

