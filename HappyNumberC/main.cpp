/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Dimas
 *
 * Created on December 14, 2020, 2:21 PM
 */

#include <cstdlib>
#include <stdio.h>
#include <stdlib.h>
#include <string>
#include <map>
#include <iostream>

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    int jumlah,i=1;;
    scanf("%d",&jumlah);   
    while (i<=jumlah){
    map <int,int> arr;
    int number ;
    scanf("%d",&number);
    int temp=number;
    int logic=0;  // 0 untuk looping 1 untuk jika kembali ke angka semula 2 untuk ==1 (happy)
    while (logic==0) {
        int mod =1,bagi=1, l=0;
        
        while (mod!=0 || number!=0){
            mod=number%10;
            number=(int)number/10;
            
            l+=mod*mod;
        }        
        if(arr[l]==1){
            logic=1;
            break;
        }
        else if (l==1){
            logic=2;
            break;
        }       
         number=l;
        arr[number]=1;

    } 
    if(logic==1){
        printf("Case #%d: %d is an Unhappy number.\n",i,temp);
    } else if (logic==2) {
       printf("Case #%d: %d is a Happy number.\n",i,temp);
    }
    i++;
    }  
    return 0;
}


