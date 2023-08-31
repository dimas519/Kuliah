/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.a18;


import java.util.Scanner;
/**
 *
 * @author Dimas Kurniawan
 */
public class DAAA18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Permutasi k = new Permutasi(sc.nextInt(), sc.nextInt());
        k.generatekAryString();


    }

}

class Permutasi {

    protected int[] result;
    protected boolean[] mark;
    protected int n;
    protected int length;
    public Permutasi(int n,int length) {
        this.result = new int[n];
        this.mark = new boolean[n];
        this.n=n;
        this.length=length;
    }

    protected void generatePermutasiRek(int curIdx) {
        if (curIdx == length) {
            process();
        } else {
            for (int i = 0; i < n; i++) {
                if (this.mark[i] == true) {
                    this.mark[i] = false;
                    result[curIdx] = i+1;
                    generatePermutasiRek(curIdx + 1);
                    this.mark[i] = true;
                }
            }
        }
    }

    public void process() {
        for (int i = 0; i < length; i++) {
            System.out.print(result[i]+" ");
        }
        System.out.println("");
    }

    public void generatekAryString() {
        for (int i = 0; i < this.mark.length; i++) {
            this.mark[i] = true;
        }
        generatePermutasiRek(0);
    }

}