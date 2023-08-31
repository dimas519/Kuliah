/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Dimas
 *
 * Created on November 3, 2020, 1:13 PM
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    int kasus,angka;
    scanf("%d",&kasus);
    int i=0;
    while (i<kasus){
        scanf("%d",&angka);

        
      if (angka%10!=0){
            angka--;
        } else if (angka%100!=0){
            angka-=10;
        } else if (angka%1000!=0){
            angka-=100;
        } else if (angka%10000!=0){
            angka-=1000;
        } else if (angka%100000!=0){
            angka-=10000;
        } else if (angka%100000==0){
            angka=0;
        }
    
    
    
        printf("%d\n",angka);
        
        
        
    
        i++;
    }
    return 0;
}


