/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Dimas
 *
 * Created on October 18, 2020, 11:46 PM
 */

#include <stdio.h>
#include <stdlib.h>
void perkalian(int array1[1000][1000],int array2[1000][1000],int hasil[1000][1000],int *n,int *m,int *p){
    printf("memory func :%d\n",&hasil[0][0]);
int i=0,j=0,u=0;
while (i<*n){
	j=0;
	while (j<*p){
		int u=0;
		while (u<*m){
                   hasil[i][j]=hasil[i][j]+((array1[i][u])*(array2[u][j]));
			u++;
		}
	j++;
	}
i++;
}


}

void main(){
	
	int n=0, m=0 ,p=0;

scanf("%d %d %d",&n,&m,&p);
int array1[n][1000],array2[m][1000],hasil[n][1000];
	 printf("memory main :%d\n",&hasil[0][0]);
int i=0;
int j=0;
while (i<n){
	j=0;
	while(j<m){
		scanf("%d",&array1[i][j]);
		j++;
	}
	i++;
} //scan array 1
i=0;
while (i<m){
	j=0;
	while(j<p){
		scanf("%d",&array2[i][j]);
		j++;
	}
	i++;
}  // scan array2

i=0;
     while(i<n){
	j=0;
	while(j<p){
	hasil[i][j]=0;
	j++;
	}
i++;
}  //pembuat 0 array hasil


perkalian(&array1,&array2,&hasil,&n,&m,&p);


i=0;
while(i<n){
	j=0;
	while(j<p){
            int output=hasil[i][j];
            printf("%d ",output);
	j++;
	}
        printf("\n");
i++;
 }
system("pause");
}
