/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Dimas
 *
 * Created on December 19, 2020, 12:14 AM
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
void kosong(int banyak,int arr[100]){
    int i=0;
    for (i=0;i<banyak;i++){
        arr[i]=0;
    }
}

void insertion (string nama[100],int nilai[100],int panjang){
    int i=0;
    int temp;
    string strTemp;
    while (i<panjang){
    
    int u=i;

    while((u>0)&&(nilai [u-1] <nilai[u])){
        temp=nilai[u-1];
         nilai[u-1]=nilai[u];
          nilai[u]=temp;
        
          strTemp=nama[u-1];
          nama[u-1]=nama[u];
          nama[u]=strTemp;
          u--;
    }
    i++;
}
}


int main(int argc, char** argv) {
    int i=0;
    int kasus=0;
    
    scanf("%d",&kasus);

    
    for (i=0;i<kasus;i++){
        int data=0;
        scanf("%d",&data);
        int x=0;
        
        string nama[data];
        int  nilai[data];
        
        kosong(data,nilai);

        for (x=0;x<data;x++){
            char a[51];
            scanf("%[^:]",&a);
            nama[x]=a;

            scanf("%c",&a);
            scanf("%c",&a);
            char tanda='p';
            char kelas[999];
            while (scanf("%[^-' ']",&kelas) ){

                
                if(kelas[0]=='u'){
                    nilai[x]+=3;
                } else if(kelas[0]=='m'){
                    nilai[x]+=2;
                } else if(kelas[0]=='l'){
                    nilai[x]+=1;
                }
            
               
                scanf("%c",&tanda); // untuk membuang tanda - atau spasi
                if(tanda==' '){
                    break;
                }
                }
            scanf("%s",&kelas); // untuk membuang "class"
            }
        
          int p=0;
        for (p=0;p<data;p++){
        cout<<nama[p];
        }
          
          
        insertion(nama,nilai,data);
            
           
            
          
            
            
            
            for (p=0;p<data;p++){
                cout<<nama[p];
                cout<<endl;
            }
        }
    
    return 0;
}

