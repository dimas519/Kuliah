/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutasiexhaustive;

/**
 *
 * @author USER
 */
public class PermutasiExhaustive {

    public static void main(String[] args) {

        Permutasi p = new Permutasi(4);

        p.generatekAryString();

    }

}

class Permutasi {

    protected int[] result;
    protected boolean[] mark;

    public Permutasi(int n) {
        this.result = new int[n];
        this.mark = new boolean[n];
    }

    protected void generatePermutasiRek(int curIdx) {
        if (curIdx == -1) {
            process();
        } else {
            for (int i = 0; i < result.length; i++) {
                if (this.mark[i] == true) {
                    this.mark[i] = false;
                    result[curIdx] = i+1;
                    generatePermutasiRek(curIdx - 1);
                    this.mark[i] = true;
                }
            }
        }
    }

    public void process() {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
        System.out.println("");
    }

    public void generatekAryString() {
        for (int i = 0; i < this.mark.length; i++) {
            this.mark[i] = true;
        }
        generatePermutasiRek(result.length-1);
    }

}
