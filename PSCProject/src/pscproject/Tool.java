package pscproject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kurni
 */
public class Tool { //membantu mengecek encoding
    static char arr[]={'0','1','2','3','4','O'};
    public static boolean isWall(char x){
        for(char y:arr){
            if(y==x){
                return true;
            }
        }
        return false;
    }
    
    public static int countMaximal(char x){
        for(int i=1;i<arr.length-1;i++){
            if(x==arr[i]){
                return (Integer.valueOf(x+"")*5); //kembalikan 5 point kalau dia angka
            }
        }
        if(x=='X'){
            return 1;
        }else{
            return 0;
        }
    }
    
    
    
    
    
    public static void clone(char[][]input,char[][]hasil,int size){
        for(int i=0;i<size;i++){
            for (int o=0;o<size;o++){
                hasil[i][o]=input[i][o];
            }
        }
    }
    
    public static boolean isPoint(char x){
        for (int i=4;i>0;i--){
            if(x==arr[i]){
                arr[i]=arr[i-1];
                return true;
            }
        }
        return false;
    }
    
    
    
    
    
    
}
