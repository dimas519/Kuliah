/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: USER
 *
 * Created on January 11, 2021, 8:37 PM
 */

#include <cstdlib>
#include <stdio.h>
using namespace std;

/*
 * 
 */
int hitungan (int untung,int biaya,int harapan){
    int n=0;
    int curr=0;
    int expected=biaya;
    printf("%d\n",expected);
    while  (curr <  expected){
       n++;
        curr=curr+untung;
        
        
        printf("%d %d\n",n,curr);
        
    }
    printf("\n");
    return n;
}

int main(int argc, char** argv) {

    int banyak;
    int harapan;
    
    scanf("%d %d",&banyak, &harapan);
    
    
    int i=0;
    int min=2147483647;  // dua milyar (maximal integer)
    int hari;
    int untung,biaya;
    
    
    for (i=0;i<banyak;i++){
        scanf("%d %d",&untung,&biaya);
        hari=hitungan(untung,biaya,harapan);
        if(hari<min){
            min=hari;
        }
        
    }
    
    
    printf("%d\n",min);
    return 0;
}

