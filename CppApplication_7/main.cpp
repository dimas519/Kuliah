/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Dimas
 *
 * Created on December 1, 2020, 2:44 PM
 */

#include <iostream>
#include <cstdlib>
#include <stdio.h>
#include <queue>

using namespace std;
void isi(int adj[4][4],int arr[4][2]){
       int i,j;
      for (i=0;i<4;i++){
            int x=arr[i][0];
            int y=arr[i][1];
            
            adj[x][y]=1;
            adj[y][x]=1;
        }  
   }

void kosong(int adj[4][4]){
    int i,j;
    for (i=0;i<4;i++){
        for (j=0;j<4;j++){
            adj[i][j]=0;
        }
    }
    
}

void bfs(int adj[4][4],char hasil[6]){
    queue<int> antri;
    
    int i=0,j=0;
    bool a=true;
    
    
    
    for(i=0;i<4;i++){
        for(j=0;j<4;j++){
    int ang=adj[i][j];
    if(ang==1){
    antri.push(j);  
    adj[i][j]=0;
    adj[j][i]=0;
    }
        }
    }
    
    
    int panjang=antri.size();
    for (i=1;i<panjang;i++){
        hasil[i]=antri.front()+48;
        antri.pop();
    }
}


int main(int argc, char** argv) {

    
int arr[4][2];
    int i,j;
    for (i=0;i<4;i++){
        for (j=0;j<2;j++){
           scanf("%d",&arr[i][j]);
        }
    }
    int adj[4][4];
    char hasil[6];
    kosong(adj);
     isi(adj,arr);
     
  hasil[0]='0'; // untuk akar / level 0
  bfs(adj,hasil);
    for (i=0;i<4;i++){
      printf("%c",hasil[i]);
  }
    
}


