/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Dimas
 *
 * Created on October 22, 2020, 10:24 PM
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    int banyak;
    scanf("%d",&banyak);
    if(banyak==1){
        printf("*\n");
    } else {
    int i=2;
    while (i<=banyak){
        printf("*\n");
        int j=i;
        while(j>0){
            printf("*");
            j=j-1;
        }
        printf("\n");
        
        i++;
    }
    printf("*\n");
    i=i-2;
    while (i>1){
        int j=i;
        while(j>0){
            printf("*");
            j--;
        }
        printf("\n");
        printf("*\n");
        
        i--;
    }
    
    }
    
    
    return 0;
    
}

