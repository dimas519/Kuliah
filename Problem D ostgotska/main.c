/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Dimas
 *
 * Created on November 3, 2020, 1:58 PM
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
 * 
 */
int main(int argc, char** argv) {
    
    char kata[16];
    int banyak=0;
    double minimal=0;
    int i=0;
    int panjang=0;
    
    while (scanf("%s",&kata)!=EOF){
        minimal=minimal+1.0;
        i=0;
        panjang=strlen(kata);

        while(i+1<panjang){
            if (kata[i]=='a'  &&  kata[i+1]=='e'){
                banyak++;
                break;
            }
            i++;
        
        
    }
    }
    minimal=minimal*0.4;
    //printf("%d %d",minimal,banyak);
    
    
        if(minimal<=banyak){
            printf("dae ae ju traeligt va\n");
        } else {
            printf("haer talar vi rikssvenska\n");
        }
        
        
        
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    return 0;
    
    
}

