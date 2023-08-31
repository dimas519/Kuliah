/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Dimas
 *
 * Created on December 21, 2020, 1:07 PM
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
int insertion (int nilai[100],int panjang){
    int i=0;
    int temp;
    int counter=0;
    while (i<panjang){  
    int u=i;
    while((u>0)&&(nilai [u-1]  > nilai[u])){
        temp=nilai[u-1];
         nilai[u-1]=nilai[u];
          nilai[u]=temp;
		  u--;
          counter=counter+1;
        
    }
    i++;
}

    return counter;
}

int main(int argc, char** argv) {

    int banyak;

    scanf("%d",&banyak);
    int j=1;
    int arrH[banyak];
	int kelas;
    for (j=0;j<banyak;j++){
   scanf("%d",&kelas);
    int arr[20];
    int i=0;
        for (i=0;i<20;i++){
	scanf("%d",&arr[i]);
	}
	int hasil=insertion (arr,20);
    
    arrH[kelas-1]=hasil;  
    }
    for (j=0;j<banyak;j++){
		printf("%d ",j+1);
        printf("%d\n",arrH[j]);
    } 
    return 0;
}

