/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Dimas
 *
 * Created on October 16, 2020, 2:18 PM
 */

#include <stdio.h>

/*
 * 
 */
void pangkat(int *a,int *b)
{
    int i=0;
    int pengali=*a;
    while (i<*b-1){
      (*a)=(*a)*pengali;
        i++;
    }  
}
void main(){
    int a=2;
    int b=5;
    pangkat(&a,&b);
    
    printf("%d\n",a);
    
    system("pause");
}



