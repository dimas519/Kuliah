/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Dimas Kurniawan
 *
 * Created on January 28, 2021, 9:24 PM
 */

#include <cstdlib>
#include <stdio.h>
#include <iostream>
#include <string>

using namespace std;

/*
 * 
 */

int nomor(char Abjad){
    int angka=Abjad;
    return angka;
}

void kosong(int arr[1000]){
    for (int i=0;i<1000;i++){
        arr[i]=0;
    }
}

void isiArr(int arr[1000]){
    string inis;
    cin >> inis;
    
    int angka=nomor(inis[0]);
    arr[angka]=1;
}


bool check(string masuk,int inis[1000]){
    bool hasil=true;
    
    int angka=nomor(masuk[0]);
    if(inis[angka]==0){
        hasil=false;
    }
    
    string berikutnya ="sementara";
    cin >> berikutnya ;
    while (berikutnya[0]!='-'){
        
        int angka=nomor(berikutnya[0]);
        if(inis[angka]==0){
            inis[angka]=1;
        hasil=false;
        }
        
        cin >> berikutnya ;
    }
    
    cin >> berikutnya ;//buang
    
    if(hasil){
    angka=nomor(berikutnya[0]);
    
    inis[angka]=1;
    }

    return hasil;
}



int main(int argc, char** argv) {
    
    int kasus;
    scanf("%d", &kasus);
    
    
    int arr[1000];// inisialisasi
    kosong(arr);
    
    string input;
    bool hasil=true;
    
    
    int idxSalah=0;
    for (int i=1;i<=kasus;i++){
        cin>> input;
        
        
        if(input[0]=='-'){
            isiArr(arr);
        }else {
            bool test=check(input,arr);
                    
              if(test==false){
                  hasil=false;
                  
                  if (idxSalah==0){
                    idxSalah=i;
                 }
                  
              } 
            
            
            
            
            
        }
            
        }
        
    
    
    
      if(hasil){
        printf("correct\n"); 
      } else{
       printf("%d\n",idxSalah);
     }
    
    
    
    return 0;
}

