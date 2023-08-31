/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Dimas
 *
 * Created on November 26 , 2020, 1:22 PM
 */

#include <stdio.h>
#include <stdlib.h>


#include "newfile.h";
/*
 * 
 */
int main(int argc, char** argv) {
/*
    int arr[4][2];
    int i,j;
    for (i=0;i<4;i++){
        for (j=0;j<2;j++){
           scanf("%d",&arr[i][j]);
        }
    }
    int adj[4][4];
    int kunjungan[4];
        kosong(adj,kunjungan);
        isi(adj,arr);
    
*/
    
    
/*
        int posisi=0;//posisi awal
        int pos=0;//untuk masuk while
*/
       int size=4;
        int head=0,tail=0;
        int queue[size];
        init(&head,&tail);
        
        int y=6;
        int x=9;
        int z=10;
        
        
        push(queue,&tail,y);
        push(queue,&tail,x);
        push(queue,&tail,z);
        
        int a=pop(queue,&head);
        int b=pop(queue,&head);
        int c=pop(queue,&head);
        
        printf("%d\n",a);
        printf("%d\n",b);
        printf("%d\n",c);
/*
        for (i=0;i<4;i++){
            if(adj[posisi][i]==1){
                push(queue,&tail,i);  // untuk menyimpan 0 bisa sambung dengan mana saja, seharusnya tidak 0 saja tapi bisa mengecek titik-titik berikutnya
                adj[posisi][i]=-1;
                adj[i][posisi]=-1; //-1 menandakan sudah;
                pos++;
            }
   
        }
        while (pos>0){
           int titik=pop(queue,&head);
            printf("%d",titik);
            pos--;
        }
*/
   
    return (EXIT_SUCCESS);
}




void isi(int adj[4][4],int arr[4][2]){
       int i,j;
      for (i=0;i<4;i++){
            int x=arr[i][0];
            int y=arr[i][1];
            
            adj[x][y]=1;
            adj[y][x]=1;
        }  
   }

void kosong(int adj[4][4],int kunjungan [4]){
    int i,j;
    for (i=0;i<4;i++){
        for (j=0;j<4;j++){
            adj[i][j]=0;
        }
    }
    
    
    for (i=0;i<4;i++){
        kunjungan[i]=0;
    }
    

}

