/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Kurni
 *
 * Created on January 18, 2021, 8:11 PM
 */

#include <cstdlib>
#include <iostream>
#include <stdio.h>
#include <math.h>
using namespace std;

/*
 * 
 */

double euler=2.71828;
double function (int p,int q,int r,int s,int t,int u, double left){
    double hasil= (p* pow(euler,left*-1.0) + (q * sin(left)) + (r*cos(left))+(s*tan(left)) + (t*pow(left,2) )+u);
    return hasil;
}
double bisection (int p,int q,int r,int s,int t,int u, double left,double right){
	if( left > 1  ){
		return -1;
	}else {
        double mid=(right+left)/2.0;
	double kiri= function(p,q,r,s,t,u,left);
	double tengah=(p,q,r,s,t,u,mid);
	double kanan=(p,q,r,s,t,u,right);
        

        
	if( kiri < 0.0001  && kiri > -0.0001){
            return left;
	} else if(tengah <0.0001){
		return mid;
	} else if(  kanan <0.0001 ){
		return 4;
	} else {
		if(kiri * tengah <0 ){
			return bisection(p,q,r,s,t,u,left,mid);
		} else {
			return bisection(p,q,r,s,t,u,mid,right);
		}
	
	}
}
}

int main(){
	double p,q,r,s,t,u;
	scanf("%lf %lf %lf %lf %lf %lf",&p,&q,&r,&s,&t,&u);

	double hasil=bisection(p,q,r,s,t,u,0,1);
	if(hasil==-1.0){
            printf("No solution\n");
        } else {
	printf("%.4lf\n",hasil);
	}
	return 0;
}
