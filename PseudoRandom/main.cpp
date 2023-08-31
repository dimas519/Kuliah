/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Dimas
 *
 * Created on December 8, 2020, 3:07 PM
 */

#include <cstdlib>
#include <stdio.h>
#include <stdlib.h>
#include <iostream>

using namespace std;
int main(int argc, char** argv) {   // menggunakan brute force
    int z=1,i=1,l=1,m=1,last=0; // semua di set 1 agar masuk ke while yg syarat tidak boleh 1
    int o=1;
  scanf("%d %d %d %d",&z,&i,&m,&l);
    while (z!=0 || i!=0 || m!=0 || l!=0){
        map< int,int > key; // dimasukan agar map baru terus( kosong )
        map< int,int > value;
        int sama=0;
        int res=0;
        int idx=0;
        while (sama==0){  // stop jika sudah ada yg sama ( sama =1)
            int hit=(((z*l)+i)%m);
            l=hit;


            if (key[hit]==1){
                sama=1;
                res=idx-value[hit];
            }
            value[hit]=idx;
            key[hit]=1;
             idx++;
            }
        printf("Case %d: ",o);
        printf("%d\n",res);
        scanf("%d %d %d %d",&z,&i,&m,&l);
         o++;
         
    }
        
        
    return 0;
}

