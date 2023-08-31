/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
Nama: Dimas Kurniawan
NPM:    6181901019
Problem: <Tight words>
Status: <AC>
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */

double hasil (int n , int k);




int main(int argc, char** argv) {
    int k,n,i,j;
    
    
    
    
    while (scanf("%d%d",&k,&n)!=EOF){
        
        
        
    k=k+1;
    
    double res=0;;
    res=hasil(n,k);
    

    
    printf("%0.9f\n",res);
    
    
    }
    return 0;
}


double hasil (int n , int k){
    double arr[100][10];
    double hasil=0;
    int i=0;
    int j=0;
    
    
    
    for (i=0;i<n;i++){
            for (j=0;j<k;j++){
              arr[i][j] = 0 ;
            }
        }
   
    
    double stat=100.0/k;
        for (i=0;i<k;i++) {
            arr[0][i] = stat;
        }
    
    
     for (i=1;i<n;i++) {
            for (j=0;j<k;j++) {
                arr[i][j]=arr[i][j]+arr[i-1][j]/k;
            }
            for (j=1;j<k;j++) {
                arr[i][j]=arr[i][j]+arr[i-1][j-1]/k;
            }
            for (j=0;j<k-1;j++) {
                arr[i][j]= arr[i][j]+arr[i-1][j+1]/k;
            }
        }
    
    for(i=0;i<k;i++){
        hasil=hasil+arr[n-1][i];
    }
    
    
    return hasil;
  
}





