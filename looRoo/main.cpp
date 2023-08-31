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
#include <map>
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

/*
 * 
 */
long long int loo(long long int l,long long int n){

    long long int terpakai=n;
    long long int i=0;
    
    long long int modulo=2;
    
    while (modulo!=0 ){
        
        modulo=l%terpakai;
        terpakai=terpakai-modulo;
        
        
    
        
    
        i++;
    }
    
    return i;
}



int main(int argc, char** argv) {

    
    long long int l,n;
    scanf("%lld %lld",&l,&n);
    
    
    
    long long int hasil=loo(l,n);
    
    
    if(hasil==0){
        hasil=1;
    }
    
    printf("%lld\n",hasil);
    
    return 0;
}


