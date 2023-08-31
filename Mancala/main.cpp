/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Dimas Kurniawan
 *
 * Created on January 28, 2021, 2:44 PM
 */

#include <cstdlib>
#include <stdio.h>

using namespace std;

/*
 * 
 */
void setArr(int arr[1000],int a){
  
    for(int i=0;i<a;i++){
        arr[i]=0;
    }
    
    
}


int main(int argc, char** argv) {
    int i=0;
    int set;
    
    

    scanf("%d", &set);
    
    int data;
    int total;
    
    
    for(i=0;i<set;i++){
        
        
        scanf("%d %d", &data,&total);
        
        int arr[total*2];
        
        setArr(arr,total*2);
        
        
        int temp=total;
        while (total >0){
            
            for(int s=1;s<=temp;s++){
            if(arr[s]==0){
                arr[s]=s;
                break;
            }else{
                arr[s]-=1;
            }
            }
            total--;
        }
        

        
        
        int maxPosisi=temp;
        while (arr[maxPosisi]==0){
            maxPosisi--;
        }
        

        
        printf("%d ",data);
        printf("%d\n",maxPosisi);
        
        
        
        for(int h=1;h<=maxPosisi;h++){
            printf("%d ",arr[h]);
            
            if(h%10==0){
                printf("\n");
            }
        }
        
    
        printf("\n");
        
        
        
        
    }
    
    

    return 0;
}

