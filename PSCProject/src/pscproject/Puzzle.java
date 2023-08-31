/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pscproject;

/**
 *
 * @author Kurni
 */
public class Puzzle {
    private char [][]puzzle;
    private int maximalFitness=0;
    private int size=0;

    
    public Puzzle(char [][]arr){
        this.puzzle=arr;
        this.size=arr[0].length;
        this.setMaximalFitness();    
    }
    
    public char[][] getPuzzle() {
        return puzzle;
    }

    public int getMaximalFitnes() {
        return maximalFitness;
    }


    private void setMaximalFitness() {
        for(int i=0;i<size;i++){
            for(int p=0;p<size;p++){
                this.maximalFitness+=Tool.countMaximal(puzzle[i][p]);
            }
        }
    }
    
    public int getSize(){
        return this.size;
    }
    
    
    
}
