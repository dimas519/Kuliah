/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
Nama:  Dimas Kurniawan
NPM:    6181901019
Problem: <Fountain>
Status: <WA>
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
 * 
 */
int main(int argc, char** argv) {
    int baris,kolom;
    char masuk[3000];
    
    scanf("%d %d%s",&baris,&kolom,&masuk);
    char arr[baris+1][kolom+1];
    
    
 int i=0,y=0;
 int u=0;
 for(i=0;i<baris;i++){
     for(y=0;y<kolom;y++){
         arr[i][y]=masuk[u];
         u++;
     }

 }
 

 for(i=0;i<baris;i++){
     for(y=0;y<kolom;y++){
         
         
         
         
         if(arr[i][y]=='V'){
             
             
             
             
         if (arr[i+1][y]=='#'){
             
             
             if(arr[i][y]!='#'){
             arr[i][y]='V';
             }
             
             
             
             int kiri=y;
             int kanan=y;
             while (arr[i+1][kiri]=='#'){
                 
                 
                 if(arr[i][kiri]=='#'){
                     break;
                 }
                 
                 if (arr[i][kiri-1]!='#'){ 
                 arr[i][kiri-1]='V';
                 }
                 if(arr[i+1][kiri-1]!='#'){
                     arr[i+1][kiri-1]='V';
                 }
                 kiri--;
             }
             while (arr[i+1][kanan]=='#'){
                 
                 if(arr[i][kanan]=='#'){
                     break;
                 }
                 
                 if(arr[i][kanan+1]!='#'){
                 arr[i][kanan+1]='V';
                 }
                 if(arr[i+1][kanan+1]!='#'){
                     arr[i+1][kanan+1]='V';
                 }   
                 
                 kanan++;
             }
             
         } // end if #
         
         else {
             if(arr[i+1][y]!='#'){
             arr[i+1][y]='V';  
             }
         }    
         }
     }
 }
 
 
 

 
 
 
 
 int p,m;
         for(p=0;p<baris;p++){
             
             

     for(m=0;m<kolom;m++){
         printf("%c",arr[p][m]);
     }
     
     
     printf("\n");
     
     
 }
         
   
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
    
    
    
    
    
    
    
    
    
    
    
    
    return 0;
}

