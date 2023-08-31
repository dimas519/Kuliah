/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 

Nama: Dimas Kurniawan
NPM: 6181901019
Problem: <Tower Construction>
Status: <AC>

 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    
    
    int banyak,i;
    scanf("%d",&banyak);
    int arr[banyak];
    
    for(i=0;i<banyak;i++){
        scanf("%d",&arr[i]);      
    }
    
    int hasil=1;
    
    
    
    for(i=0;i+1<banyak;i++){
        if (arr[i]<arr[i+1]){
            hasil++;
        }
    }

    
    printf("%d",hasil);
    
    
    
    
    
    
    

    return 0;
}

