/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: USER
 *
 * Created on January 11, 2021, 9:48 AM
 */

#include <cstdlib>
#include <stdio.h>

using namespace std;

/*
 * 
 */


int pakai (int biaya){
    int pemakaian=0;
    
    if (biaya<=200){
        pemakaian=biaya/2;
        biaya=0;
        return pemakaian;
    } else {
        pemakaian+=100;
       biaya=biaya-200;
    }
    
    if( biaya<=29700){
        pemakaian+=biaya/3;
        biaya=0;
        return pemakaian; 
    } else {
        pemakaian+=9900;
        biaya-=29700;
    }
    
    if (biaya<=4950500){
        pemakaian+=biaya/5;
        biaya=0;
        return pemakaian;
    } else {
        pemakaian+=990100;
        biaya-=4950500;
    }
    
    if (biaya>0){
        pemakaian+=biaya/7;
        biaya=0;
        return pemakaian;
    } 
    
    
    
    
    
    return 0;
    
    
    
    
    
    
}

int harga(int pakai) {
    int biaya=0;
    
    
    if (pakai<=100){
        biaya=pakai*2;
        pakai=0;
        return biaya;
    } else {
        biaya=200;
        pakai-=100;
    }
    
    if (pakai<=9900){
        biaya+=pakai*3;
        pakai=0;
        return biaya;
    } else {
        biaya+=29700;
        pakai-=9900;
    }
    
    if (pakai<=990100){
        biaya+=pakai*5;
        pakai=0;
        return biaya;
    } else {
        biaya+=4950500;
        pakai-=990100
;
    }
    
    if (pakai>0){
        biaya+=pakai*7;
        pakai=0;
        return biaya;
    }
    
    
    
    
    
    
    
    
    
    
}


int main(int argc, char** argv) {
    int a=1,b=1;
    
     scanf("%d %d", &a, &b);
    while ( a!=0 && b!=0){
    

    int terpakai=0;
   terpakai =pakai(a);
  


   printf("%d\n",terpakai);
   

   int i,j, dapat=0;
   
   for (i=terpakai;i>terpakai/2 && dapat==0;i--){
       j=terpakai-i;
           int satu=harga(i);
           int dua=harga(j);
           
           if (satu-dua == b || dua-satu== b)  {
               if (satu>dua){
                   printf("%d\n",dua);
                   
               } else {
                   printf("%d\n",satu);
               }
               
               
               dapat=1;
           }
           
       
   }
    
    
    scanf("%d %d", &a, &b);
    }
    
    return 0;
}