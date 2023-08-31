#include <stdio.h>
#include <string.h>

void main(){
	char kata[1010],hilang[1010],hasil[1010];
	scanf("%s\n",&kata);
	scanf("%s\n",&hilang);

int i=0,u=0,s=0,tb=0,ulang=1,p=0;
	int counter=0;
	
	char abjad,lang;
	

		while (ulang==1){
			p=0;
		ulang=0;
		i=0;
	int input=strlen(kata);
	int ilang=strlen(hilang);
	tb=0;
		while (i<input){
				u=0;
				s=i;
				abjad=kata[s];
				lang=hilang[u];
				counter=0;
			while((abjad==lang) && (u<ilang)&&(p==0)){
			counter++;
			u++;
			s++;
			abjad=kata[s];
			lang=hilang[u];
			}
			if(counter==ilang){
				i+=ilang;
				ulang=1;
				p=1;
			}
			hasil[tb]=kata[i];
			i++;
			tb++;
		}
		
		int l=0;
		while (l<1010){
			kata[l]=hasil[l];
			l++;
			
		}
	}
		
		
		
		
		
		i=0;
		while( (1010) && 
		((( hasil[i]>='a' )&&( hasil[i] <='z' ))
		||(( hasil[i]>='A')&&( hasil[i] <='Z')))){
		
	printf("%c",hasil[i]);
	i++;
		}
	printf("\n");

}





	