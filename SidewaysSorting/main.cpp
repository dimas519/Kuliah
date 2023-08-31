/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Dimas
 *
 * Created on December 15, 2020, 1:42 PM
 */

#include <cstdlib>
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
using namespace std;

/*
 * 
 */


void insertion (char arr[][1000],int baris,int panjang){
    int i=0;
    char temp;
    
    while (i<panjang){    
    int u=i;
    char cur=arr[0][u];
    char bef=arr[0][u-1];
 
    if (cur>=97 && cur <=122){
        cur=cur-32;
    }
    if (bef>=97 && bef <=122){
        bef=bef-32;
    }    
    while((u>0)&&(bef > cur)){
        
        int o=0;

        while (o<baris){
            temp=arr[o][u-1];
            arr[o][u-1]=arr[o][u];
            arr[o][u]=temp;
            o++;
            temp='a';
        }   
          u--;
         cur=arr[0][u];
        bef=arr[0][u-1];
    
         if (cur>=97 && cur <=122){
            cur=cur-32;
        }
            if (bef>=97 && bef <=122){
            bef=bef-32;
        }
    }
    i++;
}
}







int main(int argc, char** argv) {
    int banyak,ukuran;
    scanf("%d ",&banyak);
    scanf("%d ",&ukuran);
    char arr[1000][1000];
    int i,j;   
    while (banyak!=0 && ukuran !=0){
    
        i=0;
        while (i<banyak){
            j=0;
            scanf("\n");
            while (j<ukuran){
                scanf("%c",&arr[i][j]);
                j++;
            } 
            
            i++;
        }               
        insertion(arr,banyak,ukuran);
        i=0;
        while (i<banyak){
            j=0;
            while (j<ukuran){
                printf("%c",arr[i][j]);
                j++;
            } 
            printf("\n");
            i++;
        }        
        
        scanf("%d",&banyak);
        scanf("%d",&ukuran);
    }
    return 1;
}

