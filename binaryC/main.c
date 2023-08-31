/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Dimas
 *
 * Created on October 18, 2020, 10:59 PM
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
void main(int argc, char** argv) {
    int input,i=0;
    scanf("%d",&input);
    char hasil[100];
    int banyak=0;
    bin(&input,&hasil,&banyak);
    char putar;
    int temp=banyak;
    while (i<banyak){
        putar=hasil[temp-1];
        printf("%c",putar);
        i++;
        temp--;
    }
    printf("\n");
}

void bin(int *input, char *hasil,int *banyak){
    int i=0;
    char hasil1[100];
    while (*input>0){
        if((*input%2)==0){
            (hasil[i])=48;
        } else {
            (hasil[i])=49;
        }
        i++;
        *input=(int)(*input/2);
    }   
    *banyak=i;
}

