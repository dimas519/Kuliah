/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: USER
 *
 * Created on January 19, 2021, 1:34 PM
 */

#include <cstdlib>
#include <stdio.h>
using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    int loop;
    scanf("%d", &loop);
    for (int p=0;p<loop;p++){
        int arr[1001];
        int t;
        int banyak;
        scanf("%d %d", &t,&banyak);
        int harga=0;
        for(int j=0;j<t;j++){
            int isi;
            scanf("%d", &isi);
            int temp[isi];
            for(int l=0;l<isi;l++){
                scanf("%d", &temp[l]);
            }
            int harga;
            scanf("%d", &harga);
            for (int l=0;l<isi;l++){
                arr[temp[l]]=harga;
            }
        }
    

        
        for(int s=0;s<banyak;s++){
            int idx;
            scanf("%d\n", &idx);
            harga+=arr[idx];
            arr[idx]=0;
            
            
            for (int m=1;m<=7;m++){
            printf("%d ",arr[m]);
            
        }
            printf("\n");
        }
    
    
        printf("%d",harga);
    
    }
    return 0;
}

