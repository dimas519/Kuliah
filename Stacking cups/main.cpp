/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Dimas
 *
 * Created on December 20, 2020, 11:00 AM
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
bool isNumber(char arr[100]){
    if (arr[0] >=48 && arr[0] <=67 ){
        return true;
    } else {
        return false ;
    }
}
void insertion (string nama[100],int nilai[100],int panjang){
    int i=0;
    int temp;
    string strTemp;
    while (i<panjang){
    
    int u=i;

    while((u>0)&&(nilai [u-1]  > nilai[u])){
        temp=nilai[u-1];
         nilai[u-1]=nilai[u];
          nilai[u]=temp;
        
          temp=nama[u-1];
          nama[u-1]=nama[u];
          nama[u]=temp;
          u--;
    }
    i++;
}
}



int main(int argc, char** argv) {
    
    int banyak;
    int i=0;
    scanf("%d",&banyak);
    
    string warna[banyak];
    int jari[banyak];
    
    
    
    for (i=0;i<banyak;i++){
    char depan[21];
    char belakang[21];
    scanf("%s %s",&depan,&belakang);
    
  
    if (isNumber(depan)){
        int temp=atoi(depan);
        temp=temp/2;
        jari[i]=temp;
        warna[i]=belakang;
        
    } else {
        jari[i]=atoi(belakang);
        warna[i]=depan;
    }

    }
    
    
   insertion (warna,jari,banyak);
   
   
    
   for (i=0;i<banyak;i++){
       cout<<warna[i];
       cout<<endl;
   }
    
    
    
    

    
    return 0;
}

