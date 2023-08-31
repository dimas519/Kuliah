/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Dimas Kurniawan
 *
 * Created on January 26, 2021, 8:04 AM
 */

#include <cstdlib>
#include <stdio.h>

using namespace std;

/*
 * 
 */
int loo(int l,int n){
    int temp=l;
    int i=0;
    int kurang=0;
    
    while (temp!=0){
        temp=l;
        temp-=kurang;
        
        
        int bagi=(int)temp/n; // selalu floor
        int kali=(bagi*n);
        
        temp-=kali;
        
        kurang=n-temp;
        
        
        
        
        
        i++;
    }

    
    return i;
}



int main(int argc, char** argv) {

    
    int hasil=loo(31,6);
    
    printf("%d",hasil);
    
    return 0;
}




