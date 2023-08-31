/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pscproject;

/**
 *
 * @author Kurni
 */
public class FitnessCalculator {
    
    public static void countFitness(Individu x,int maximalFitness){
        char arr[][]=x.getArray();
        int size=x.getSize();
        char tempArr[][]=new char[size][size];
        Tool.clone(arr, tempArr, size);
        
        boolean fail=false;
        double res=0.0;
        for (int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                char karakter=arr[i][j];
                if(karakter=='L'){

                    int temp=i;
                    int skor=checkSekitar(x,temp+1,j);
                    if(skor==-1){
                        fail=true;
                    }else{
                        skor+=nyalainLampu(x,i,j);
                        res+=skor;
                    }
                    
                    temp=i;
                    skor=checkSekitar(x,temp-1,j);
                    if(skor==-1){
                        fail=true;
                    }else{
                        skor+=nyalainLampu(x,i,j);
                        res+=skor;
                    }
                    
                    
                    temp=j;
                    skor=checkSekitar(x,i,temp+1);
                    if(skor==-1){
                        fail=true;
                    }else{
                        skor+=nyalainLampu(x,i,j);
                        res+=skor;
                    }

                    temp=j;
                    skor=checkSekitar(x,i,temp-1);
                    if(skor==-1){
                        fail=true;
                    }else{
                        skor+=nyalainLampu(x,i,j);
                        res+=skor;
                    }   
                }    
            }
        }
        x.setChar(tempArr);
        double hasil=0;
        if(fail){
            hasil=-1.0;
        }else{
            hasil=(res/maximalFitness*1.0)*100;
        }
        
        x.setFitness(hasil);
    }
    
       private static int nyalainLampu(Individu l,int x,int y){
        int hasil=0;
        char arr[][]=l.getArray();
        
        
        int size=l.getSize();
        //kiri dulu
        int i=x-1;
        while (i>0 && !Tool.isWall(arr[i][y])  &&arr[i][y]!='N' ){
            hasil++;
            arr[i][y]='N';
            i--;
        }
        
        //kekanan
        i=x+1;
        while(i<size&&!Tool.isWall(arr[i][y])  &&arr[i][y]!='N'){
        hasil++;
        arr[i][y]='N';
        i++;
    }
        
        //keatas
        
        i=y-1;
        while(i>0 && !Tool.isWall(arr[x][i])  &&arr[x][i]!='N' ){
            hasil++;
            arr[x][i]='N';
            i--;
        }
        
        
        //kebawah
        i=y+1;
        while(i<size && !Tool.isWall(arr[x][i])  &&arr[x][i]!='N' ){
            hasil++;
            arr[x][i]='N';
            i++;
        }
        return hasil;
        
    }
    
    
 private static int checkSekitar(Individu l,int x,int y){ //ngecek disekitar dia apakah kotak dengan angka
     int number=0;
     char arr[][]=l.getArray();
     try{
         number=setScore(arr[x][y]);
     }catch(ArrayIndexOutOfBoundsException   e){
         //karena index out diluar map maka biarkan saja
     }
     return number;
 }
    
    private static int setScore(char x){
        if(x=='0'){
            return -1;
        }else if(Tool.isPoint(x)){
            return 5;
        }
        return 0;
    }    
    
}
