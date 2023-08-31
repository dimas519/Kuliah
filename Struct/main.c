/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Dimas
 *
 * Created on October 22, 2020, 7:00 AM
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
struct Animal{
 char nama[100];
 int berat;
 int tinggi;
};  // untuk insisali struct
struct Animal arr[7]={
 {"wombat", 45, 21},
{"kapibara", 45, 33},
{"kambing", 76, 45},
{"anjing",55, 12},
{"kucing", 55, 11},
{"zaza",76, 45},
{"dodo",76, 45}
}; //untuk memasukan data distruct
int compare (const void *a,const void *b){
   const struct Animal *arg1 = (const struct Animal*)a;
   const struct Animal *arg2 = (const struct Animal*)b;
     if (arg1->berat < arg2->berat) {
        return -1;
    } else if (arg1->berat > arg2->berat){
        return 1;
    } else if (arg1->berat==arg2->berat){
        if (arg1->tinggi < arg2->tinggi) {
        return -1;
        }else if (arg1->tinggi > arg2->tinggi){
        return 1;
        } else if (arg1->tinggi==arg2->tinggi){
            int a=strcmp(arg1->nama,arg2->nama);
            if (a>0){
                return 1;
            } else if (a<0){
                return -1;
            } else {
                return 0;
            }

        }}}
int main(){
    char _nama[100];
   int n;
   printf("Before sorting the list is: \n");
   for( n = 0 ; n < 7; n++ ) {
       strcpy(_nama, arr[n].nama);
       printf("%s ",_nama);
       printf("%d ",arr[n].berat);
       printf("%d",arr[n].tinggi);
       printf("\n");
       
   }  //untuk print struct sebelum disort
   qsort(arr, 7, sizeof(struct Animal),compare);
   char _nama1[100];
       
     printf("After sorting the list is: \n");
        for( n = 0 ; n < 7; n++ ) {
       strcpy(_nama1, arr[n].nama);
       printf("%s ",_nama1);
       printf("%d ",arr[n].berat);
       printf("%d",arr[n].tinggi);
       printf("\n");
       
   }  // untuk print struct setelah disor
     return 0;
};