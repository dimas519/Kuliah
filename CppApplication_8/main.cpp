/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: USER
 *
 * Created on January 19, 2021, 2:42 PM
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

    char a='-';

    printf("%d",a);
    return 0;
}

