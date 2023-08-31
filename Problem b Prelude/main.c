/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Dimas
 *
 * Created on November 3, 2020, 2:54 PM
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    int i=1;
    char nada[50];
    char mm[50];
    int logic=0;
    while (scanf("%s %s",&nada,&mm)!=EOF){
        logic=0;
        
        
        if (nada[0]=='A') {
            if(nada[1]=='#'){
                printf("Case %d:",i);
                printf(" Bb ");
                printf("%s\n",mm);
                logic=1;
            } else if(nada[1]=='b'){
                printf("Case %d:",i);
                printf(" G# ");
                printf("%s\n",mm);
                logic=1;
            } 
        }else if (nada[0]=='B'  && nada[1]=='b'){
                printf("Case %d:",i);
                printf(" A# ");
                printf("%s\n",mm);
                logic=1;
        } else if (nada[0]=='C' && nada[1]=='#'){
                printf("Case %d:",i);
                printf(" Db ");
                printf("%s\n",mm);  
                logic=1;
        } else if (nada[0]=='D'){
            if(nada[1]=='b'){
                printf("Case %d:",i);
                printf(" C# ");
                printf("%s\n",mm);
                logic=1;
            } else if(nada[1]=='#'){
                printf("Case %d:",i);
                printf(" Eb ");
                printf("%s\n",mm);
                logic=1;
            }
        } else if (nada[0]=='E' && nada[1]=='b'){
            printf("Case %d:",i);
                printf(" D# ");
                printf("%s\n",mm);
                logic=1;
        } else if(nada[0]=='F' && nada[1]=='#'){
            printf("Case %d:",i);
                printf(" Gb ");
                printf("%s\n",mm);
                logic=1;
        } else if (nada[0]=='G'){
            if(nada[1]=='#'){
                printf("Case %d:",i);
                printf(" Ab ");
                printf("%s\n",mm);
                 logic=1;
            } else if(nada[1]=='b'){
                printf("Case %d:",i);
                printf(" F# ");
                printf("%s\n",mm);
                logic=1;
            }
        } if(logic==0) {
            printf("Case %d: ",i);
            printf("UNIQUE\n");
        }

        i++; 
    }
    return 0;
}

