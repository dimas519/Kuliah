/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Dimas
 *
 * Created on December 18, 2020, 1:08 PM
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
void kosong(int arr[1000],int banyak){
    int i=0;
    for(i=0;i<banyak;i++){
        arr[i]=0;    
    }
    
}

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
    int kas=0;
    int kasus=0;
    scanf("%d",&kasus);
    
    while (kas<kasus){
        int hasil=0;
        int banyak=0;
       scanf("%d",&banyak);
       int j=0;
       
       int blue[banyak];
       int red[banyak];
       
       kosong(blue,banyak);
       kosong(red,banyak);
       
       int jblue=0;
       int jred=0;
       
       while (j<banyak){ 
           int angka;
           char warna;         
           scanf("%d %c",&angka,&warna);

           if(warna=='B'){
               blue[jblue]=angka;
               jblue++;
           } else if (warna=='R'){
               red[jred]=angka;
               jred++;
           }           
           j++;
       } // mengatur input
       
       qsort(blue,banyak, sizeof(int),compare);
       qsort(red,banyak, sizeof(int),compare);
        
       
 
       
       j=banyak-1;
       int sambung=1;
       
       if(jred==0 || jblue==0){
                hasil=0;
        } else if(jred>jblue){
                
                while (jblue>0){
                    hasil+=blue[j]+red[j]-sambung;
                    sambung=2;
                    jblue--;
                    j--;
                } 
            }else  {
                while (jred>0){
                    hasil+=blue[j]+red[j]-sambung;
                    sambung=2;
                    jred--;
                    j--;
                }
                
            } 
       
       
       
       
       
        kas++;
        if (hasil>0){
            hasil--;
        }
        
        printf("Case #%d: ",kas);
        printf("%d\n",hasil);
       
    }
    return 0;
}

