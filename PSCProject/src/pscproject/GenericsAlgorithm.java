/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pscproject;

/**
 *
 * @author Kurni
 */
public interface GenericsAlgorithm {
    public  Population GASearch(int ukuranPopulasi,long seed,Puzzle lightUp, double mutationRate);
    public void CountFitnessGA(Population populasi);
}
