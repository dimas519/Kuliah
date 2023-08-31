package pscproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Kurni
 */
public class InputOutput {
    private char[][] puzzle;
    private Long seed;
    private int size;
    
    public char[][] getArray(){
        return this.puzzle;
    }
    
    public Long seed(){
        return this.seed;
    }
    
    public int size(){
        return this.size;
    }

    public char[][] reader(String path){
            try {
                FileReader file=new FileReader(path);
                BufferedReader document=new BufferedReader (file);
                String kata="";
                int i=0;
                while ((kata=document.readLine())!= null){         
                    if(i == 0){
                        this.seed = Long.parseLong(kata);
                    }else if(i == 1){
                        size = Integer.parseInt(kata);
                        this.puzzle = new char[size][size];
                    }else{
                        for(int x=0;x<size;x++){
                            puzzle[i-2][x]=kata.charAt(x);
                        }
                    }
                    i++;
                } 
            } catch (Exception e) {
                System.out.println("File: "+ path+" tidak ditemukan");
            }
        return this.puzzle;
    }
    
    
    
    
    
    
    
    
    
    
}

    
    
    
   

