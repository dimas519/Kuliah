#include <stdio.h>
#include <math.h>

int main(){
   
    
    int a=0;  // misalkan kiri 
    
    
    int *alamatA=&a;  // alamat si
    
    *alamatA=5;  //mengubah nilai a dengan alamatnya
    
    printf("%d\n",a);
    
    

    return 0;
    
}