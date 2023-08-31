/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Dimas
 *
 * Created on October 18, 2020, 10:24 PM
 */

#include <stdio.h>
#include <string.h>

void kasur(char *input,int *panjang,int *logic){
    
    int batas;
    if((*panjang)%2==0){
        batas=(*panjang/2)-1;
    } else {
        batas=(int)(*panjang/2);
    }
    int atas=*panjang-1;
    int bawah=0;
    
    while ((*logic==1)&&(bawah<batas)&&(atas>batas)){
        if((input[bawah])!=(input[atas])){
            *logic=0;
        }
        bawah++;
        atas--;
    }
}

void main (){
	char input[1000];
	scanf("%s",&input);
	int panjang=strlen(input);
	int logic=1;
	kasur(&input,&panjang,&logic);
	
	if(logic==1){
		printf("YA\n");
	} else {
		printf("BUKAN\n");
                
	}
	
}
     

