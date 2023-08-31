/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Dimas
 *
 * Created on December 14, 2020, 3:35 PM
 */

#include <cstdlib>
#include <stdio.h>
#include <stdlib.h>
#include <map>

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) { 
    int step,mod;
    
    scanf("%d %d",&step,&mod);
    map <int,int> map1;
    map <int,int>check;
    map1[0]=0;
    int logic =0;
    int idx=0;
    while (logic==0 && idx<mod){
        int hitungan=((map1[idx]+step)%mod);
        if (check[hitungan]==1){
            logic=1;
            break;
        }
        check[hitungan]=1;
        map1[idx+1]=hitungan;
        idx++;
    }
        printf("%10d",step);
        printf("%10d",mod);
    if(logic==0){
        printf("    Good Choice\n");
    } else if(logic==1){
        printf("    Bad Choice\n");
    }
    return 0;
}

