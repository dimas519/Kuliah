/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pscproject;

import java.util.Random;

/**
 *
 * @author Kurni
 */
public class HeuristikSearch implements GenericsAlgorithm {

    @Override
    public  Population GASearch(int ukuranPopulasi,long seed,Puzzle lightUp,double mutationRate) {
        Random rand=new Random (seed);
        Population world=new Population(ukuranPopulasi,rand, lightUp,mutationRate);
        world.generatePopulation(); //point 1 generate pop awal
        world.calculateFitness(); // 2 hitung hitnessnya
        
        int iterasi=1000;
        Individu anak[]=new Individu[ukuranPopulasi];
        
        double maks=0;
        
        for(int i=0;i<iterasi;i++){
            for(int y=0;y<ukuranPopulasi;y++){
                Individu child[]=world.doCross();
                anak[y]=world.mutation(child[0]);
                y++;
                anak[y]=world.mutation(child[1]);
            }
            double hasil=world.newEra(anak);
            world.calculateFitness();
            world.setRandom(new Random(rand.nextLong()));
            if(hasil>maks){
                maks=hasil;
            }
            System.out.println("Iterasi  "+i+" Nilai maks"+hasil);
        
        }
        
        System.out.println(maks);
        
      return null;
    }

    @Override
    public void CountFitnessGA(Population Populasi) {
//        Individu orang[]=Populasi.getPopulasi();
//        for(Individu satu:orang){
//            satu.calculateFitness();
//        }
//        Populasi.doCross();
    }
    
}
