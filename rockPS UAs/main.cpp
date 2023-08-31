/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Dimas Kurniawan
 *
 * Created on January 26, 2021, 8:40 AM
 */

#include <cstdlib>
#include <stdio.h>

using namespace std;

/*
 * 
 */
int scoring (char a,char b){
    if(a==b){
        return 1;
    } else {
        if(a=='S'){
            if(b=='P'){
                return 2;
            }
        } else if (a=='P'){
            if(b=='R'){
                return 2;
            }
        }else if(a=='R'){
            if(b=='S'){
                return 2;
            }
        }
        return 0;
    }
}        

int Lurus(char utama[100],char pemain[50],int jumlah){
int score=0;
    for (int i=0;i<jumlah;i++){
        score+=scoring(utama[i],pemain[i]);
    }

return score;
}



void arrR(char a[100],int jumlah){
    for(int i=0;i<jumlah;i++){
        a[i]='R';
    }
}
void arrP(char a[100],int jumlah){
    for(int i=0;i<jumlah;i++){
        a[i]='P';
    }
}
void arrS(char a[100],int jumlah){
    for(int i=0;i<jumlah;i++){
        a[i]='S';
    }
}

int main(int argc, char** argv) {
    int main;
    scanf("%d", &main);   
    char arrUtama[main];
    scanf("%s", &arrUtama);
        
        
    int pemain;
    scanf("%d ", &pemain);
    char space;
     int i=0;
     char next[pemain][main];
     for(i=0;i<pemain;i++){
         for(int j=0;j<main;j++){
         scanf("%c", &next[i][j]);
         }
         scanf("%c",&space);
     }
     
     
     i=0;
     int atas=0;
     char temp[main];
     while (i<pemain){
         
         
         for (int j=0;j<main;j++){
             temp[j]=next[i][j];
             
         }
        
         atas+=Lurus(arrUtama,temp,main);
         
         
         
         i++;
     }
     

     i=0;
     int bawah=0;    
     char r[pemain];
     char p[pemain];
     char s[pemain];
     
     arrR(r,pemain);
     arrP(p,pemain);
     arrS(s,pemain);
     
     char temp2[pemain];
     
     
     for (i=0;i<main;i++){
         
         for (int j=0;j<pemain;j++){
             temp2[j]=next[j][i];
          
         }
         int max=Lurus(r,temp2,pemain);
         int p2=Lurus(p,temp2,pemain);
         
         if(p2>max){
             max=p2;
         }
         int s2=Lurus(s,temp2,pemain);
         if(s2>max){
             max=s2;
         }
         
         
         bawah+=max;
         
     }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     printf("%d\n",atas);
     printf("%d\n",bawah);
     
     
    
    return 0;
}

