/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: USER
 *
 * Created on January 19, 2021, 3:41 PM
 */

#include <cstdlib>
#include <stdio.h>
#include <string>
using namespace std;

/*
 * 
 */

void back(char arr[10000],int panjang){
    arr[panjang]='0';
}
void right(char arr[10000],int panjang,char masuk){
    arr[panjang+1]=masuk;
}
void left(char arr[100000],int panjang,char masuk){
    
    while (panjang>0){
        arr[panjang+1]=arr[panjang];
        panjang--;
    }
    
    arr[0]=masuk;
    
    
}

int main(int argc, char** argv) {
    char input[10000];
    
    int panjang=0;
    while (scanf("%c", &input[panjang])!= EOF ){
        panjang++;
    }
  
    for (int i=0;i<panjang;i++){
        if(input[i]=='B'){
            back(input,panjang);
        }else  if(input[i]=='R'){
            
        }else if (input[i]=='L'){
            i++;
            char masuk=input[i];
            printf("%c\n",masuk);
            left(input,panjang,masuk);
        } 
        
        
    }
    
    
    for (int i=0;i<panjang;i++){
        printf("%c",input[i]);
    }
    
    return 0;
}

