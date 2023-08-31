/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Dimas
 *
 * Created on December 7, 2020, 2:56 PM
 */

#include <cstdlib>
#include <stdio.h>
#include <stdlib.h>
#include <queue>

using namespace std;

/*
 * 
 */


int oil(char arr[101][101],int m,int n){
    queue <int> x;
    queue <int> y;
    int i=0,j=0;
    int count =0;
    
    while (i<m){
        while (j<n){
            if (arr[i][j]=='@'){
                count++;
                x.push(i);
                y.push(j);
                arr[i][j]='*';
                
            }
            j++;
        }
        i++;
    }    

    return count;
    
}


int main(int argc, char** argv) {
    int m,n;
    scanf("%d %d",&m,&n);
    
    char arr[101][101];
    int i=0,j=0;
    while (i<m+1){
        while (j<n+1){
            scanf("%c",&arr[i][j]);
            j++;
        }
        i++;
    }
   
    int banyak=oil(arr,m,n);
    printf("%d",banyak);
    return 0;
}



