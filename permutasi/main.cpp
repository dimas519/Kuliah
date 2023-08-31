/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Dimas Kurniawan
 *
 * Created on January 26, 2021, 5:12 PM
 */

#include <cstdlib>
#include <stdio.h>

using namespace std;

/*
 * 
 */



int karry(int idx,int panjang,int arr[100]){
    
    
    if(idx==-1){
            for(int i=0;i<panjang;i++){
                printf("%d",arr[i]);
            }
            idx=2;
            printf("\n");
    
    
    } else {
        for(int i=0;i<panjang;i++){
                arr[idx]=i;
                idx=idx-1;
                karry(idx,panjang,arr);
         }
    }
    
    
    
}





int main(int argc, char** argv) {

    int arr[3];
    karry(2,3,arr);
    return 0;
}

