
/* 
 * File:   main.c
 * Author: Dimas
 *
 * DFS
 * 
 * Created on November 24, 2020, 2:11 PM
 */






#include <stdio.h>
#include <stdlib.h>



int main(int argc, char** argv) { //dfs

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
  hasil[0]=48;
          
   int posisi=0;//posisi start;

  i=1;
dfs(adj,i,hasil,posisi); 

for (i=0;i<6;i++){
    printf("%c",hasil[i]);
}
    return 0;
   
}


int dfs(int adj[4][4],int i,char hasil[5],int posisi){
    
   if(i==5){
       return 0;
   } else {
       int k;
       for (k=0;k<4;k++){
           if(adj[posisi][k]==1){
               hasil[i]=k+48;
               adj[posisi][k]=-1;  // 0 untuk tidak ada jalur    1 untuk belum dilalui  -1 untuk sudah dilalui
               adj [k][posisi]=-1;
               posisi=k;
               break;    
           }
       }
       i++;
       return dfs(adj,i,hasil,posisi);

   }

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

void kosong(int adj[4][4]){
    int i,j;
    for (i=0;i<4;i++){
        for (j=0;j<4;j++){
            adj[i][j]=0;
        }
    }
    
}
