/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Dimas Kurniawan
 *
 * Created on January 26, 2021, 8:50 PM
 */

#include <cstdlib>
#include <stdio.h>
#include <string>
#include <iostream>

using namespace std;

/*
 * 
 */
int kelipatan(int bil){
    int i=0;
    
    while (bil%4!=0){
        i++;
        bil++;
    }
    return i;
    
    
}


int main(int argc, char** argv) {
   

    int nop=0;
    string arr;
    cin >> arr;
    int panjang=arr.length();
 
    int i=1;
    int idx=1;
    while(i<panjang){
        if(arr[i]>=65 && arr[i]<=90){
//            printf("idx :%d\n",idx);
//            printf("nop: %d\n",kelipatan(idx));
            nop+=kelipatan(idx);
            idx=1;
        }else{
            idx++;
        }
        
        
        i++;
        
    }
    
    
    

    printf("%d\n",nop);
    
    return 0;
}

