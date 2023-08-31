package pscproject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Kurni
 */

public class Population implements FitnessFunctionCalculate{
    private int ukuranPopulasi;
    private Individu[] pop;
    private int lebar;
    private Random rand;
    private Puzzle puzzle;
    private double mutationRate;
    private double tertinggi=0;

    public Population (int ukuranPopulasi,Random rand,Puzzle puzzle,double mutationRate){
        this.ukuranPopulasi=ukuranPopulasi;
        this.pop=new Individu[ukuranPopulasi];
        this.lebar=puzzle.getSize();
        this.rand=rand;
        this.puzzle=puzzle;
        this.mutationRate=mutationRate;
    }
    
    
    
    //bagian generate awal  (1)
    private Individu getIndividuAwal(){
        Individu baru= new Individu(puzzle);
        char [][]x=baru.getArray();
        for(int i=0;i<lebar;i++){
            int rentang = rand.nextInt(lebar);
            if(Tool.isWall(x[i][rentang])){
                i--;
            }else{
                x[i][rentang] = 'L';
            }
        }
        return baru;
    }
    
    public void generatePopulation(){
        for(int i=0;i<ukuranPopulasi;i++){
            pop[i]=getIndividuAwal();
        }
    }
    
    public Individu[] getPopulasi(){
        return pop;
    }
    
    
    
    
    
   
    
    
    private Individu[] crossOver(Individu a,Individu b){
        char arrA[][] = a.getArray();
        char arrB[][] = b.getArray();
        
        int potong = rand.nextInt(7);
        
        Individu[] childs = new Individu[2];
        
        char child[][] = new char[lebar][lebar];
        char child2[][] = new char[lebar][lebar];
        
        for(int i=0;i<lebar;i++){
            int temp=potong;
            for(int o=0;o<potong;o++){
                child[i][o]=arrA[i][o];
                child2[i][o]=arrB[i][o];
            }
            for(temp=temp;temp<lebar;temp++){
                child[i][temp]=arrB[i][temp];
                child2[i][temp]=arrA[i][temp];
            }   
        }
        
        
        //masukin ke tipeddata
        childs[0] = new Individu(child);
        childs[1] = new Individu(child2);
        
        
        
        
        //debugging
//        for(int v=0;v<lebar;v++){
//            for(int y=0;y<lebar;y++){
//                System.out.print(child[v][y]);
//            }
//            System.out.println();
//        }
//        System.out.println();
//        
//        
//        
//        for(int v=0;v<lebar;v++){
//            for(int y=0;y<lebar;y++){
//                System.out.print(child2[v][y]);
//            }
//            System.out.println();
//        }
//        System.out.println();
        return childs;
    }
    
    
    public Individu[] doCross(){
//        System.out.println("selection");
        Individu[] parent = this.selectionParent();
//        System.out.println("cross");
        return crossOver(parent[0],parent[1]);
        
    }
    
    public Individu[] selectionParent(){
        Individu[] parent =new Individu[2];
        int sementara = 0;
        for(int i=0; i<2; i++){
           int acak=this.rand.nextInt(this.ukuranPopulasi);
           
           if(pop[acak].getIsMariage()){
               i--;
           }else{
               parent[i]=pop[acak];
               pop[acak].setIsMariage();
           }
           
           
           
           
           
           
           
                      
           
           
           
           
           
            
//            for(int v=0;v<lebar;v++){
//                for(int y=0;y<lebar;y++){
//                    System.out.print(parent[i].getArray()[v][y]+"");
//                }
//                System.out.println();
//            }
//            System.out.println(parent[i].getFitness());
//            System.out.println();
        }
        return parent;
    }
    
    public double newEra(Individu newPop[]){
               this.pop=newPop;
               double temp=tertinggi;
               this.tertinggi=0;
               return temp;
           }
    
    
    public Individu mutation(Individu x) {
        char arr[][]=x.getArray();
        
        int banyak=rand.nextInt(lebar);
        
        for (int i = 0; i < lebar; i++) {
            double flot = rand.nextDouble();
//            int baris=rand.nextInt(lebar);
            int mutant = rand.nextInt(lebar);
            
            
            if (!Tool.isWall(arr[i][mutant])  && flot <= this.mutationRate) {
                if (arr[i][mutant] == 'X') {
                    arr[i][mutant] = 'L';
                } else if (arr[i][mutant] == 'L') {
                    arr[i][mutant] = 'X';
                }
            }
        }
        x.setChar(arr);
        return x;
    }
    
    
    public void setRandom(Random ran){
        this.rand=ran;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void debug(){
        for(int i=0;i<ukuranPopulasi;i++){
            Individu x=pop[i];
            char ind[][]=x.getArray();
                for(int v=0;v<lebar;v++){
                    for(int y=0;y<lebar;y++){
                        System.out.print(ind[v][y]+"");
                    }
                    System.out.println();
                }
            System.out.println(x.getFitness());    
            System.out.println();
        }
    }
    
    
    
 
        

    @Override
    public void calculateFitness() {
        for(Individu x:pop){
          FitnessCalculator.countFitness(x, puzzle.getMaximalFitnes());
          
          //hapus
            double nilai=x.getFitness();
            if(tertinggi<nilai){
                tertinggi=nilai;
            }
          
          
        }
    }
    
}
    
