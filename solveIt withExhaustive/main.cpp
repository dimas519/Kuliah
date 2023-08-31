/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Kurni
 *
 * Created on January 18, 2021, 8:53 PM
 */

#include <cstdlib>
#include <iostream>
#include <stdio.h>
#include <math.h>
double euler=2.71828;
using namespace std;

/*
 * 
 */
bool Rumus (int p,int q,int r,int s,int t,int u , double left ){
    
    double hasil= (p* pow(euler,left*-1.0) + (q * sin(left)) + (r*cos(left))+(s*tan(left)) + (t*pow(left,2) ) +u);

    cout << hasil;
    cout << endl;
    if (hasil<0.0001){
        return true;
    } else {
        return false;
    }
}



int main(int argc, char** argv) {

    double idx=0.0000;
    double p,q,r,s,t,u;
	scanf("%lf %lf %lf %lf %lf %lf",&p,&q,&r,&s,&t,&u);
    
        while (idx < 1.0000){
            idx+=0.0001;
            if(Rumus(p,q,r,s,t,u,idx)){
                break;
            }
            
            
            
        }
 
    
        printf("%lf",idx);
    
    return 0;
}

