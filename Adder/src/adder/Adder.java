/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adder;

/**
 *
 * @author Dimas
 */
public class Adder {
    public static void main(String[] args) {
	int panjang = args.length;

        if (panjang < 2) {
            System.out.println("User enter only one argument.");
        } else {
	    int jumlah = 0;

	    for (int i = 0; i < panjang; i++) {
                jumlah += Integer.valueOf(args[i]).intValue();
	    }
            System.out.println(jumlah);
        }
    }
}