/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: USER
 *
 * Created on January 19, 2021, 2:31 PM
 */
#include <cstdlib>
#include <stdio.h>
using namespace std;

/*
 * 
 */

int hitung (int a,int b){
    int i=0;
    
    while (a<=b){
        i++;
        a++;
    }
    return i;
}
int main(int argc, char** argv) {
    int kiri;
    int hasil=0;
    while (scanf("%d", &kiri)!=EOF){
        char tengah;
        scanf("%c", &tengah);
    if (tengah=='-' ){
        int kanan;
        scanf("%d", &kanan);
//        printf("%d %d\n",kiri,kanan);
        int tambah=hitung(kiri,kanan);
        hasil+=tambah;
        scanf("%c", &tengah);
    } else {
        hasil+=1;
//        printf("%d\n",kiri);
    }
    }
    printf("%d\n",hasil);
    return 0;
}

