package pscproject;


import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kurni
 */
public class Individu  {
    private int size;
    private double fitness;
    private char [][] arr;
    private boolean isMariage;


    public Individu(Puzzle puzzle){
        this.size = puzzle.getSize();
        this.arr = new char[size][size];
        Tool.clone(puzzle.getPuzzle(), arr, size);
        this.fitness = 0;
        this.isMariage=false;
    }
    
    public Individu(char[][] arr){
        this.size=arr[0].length;
        this.arr=arr;
        this.fitness=0;
        this.isMariage=false;
    }
    
    public boolean getIsMariage(){
        return isMariage;
    }
    
    public void setIsMariage(){
        this.isMariage=true;
    }
    
    
    public void setFitness(double fitness){
        this.fitness=fitness;
    }
 
    public char[][] getArray(){
        return this.arr;
    }
    
    public void setChar(char x[][]){
        this.arr = x;
    }
    
    public double getFitness(){
        return this.fitness;
    }
    
    
    public int getSize(){
        return this.size;
    }


    
    


    
    
    
    
}
