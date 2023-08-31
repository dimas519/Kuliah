/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpadder;

/**
 *
 * @author Dimas
 */
import java.text.DecimalFormat;

public class FPAdder {
    public static void main(String[] args) {

	int panjang = args.length;


        if (panjang < 2) {
           System.out.println("User enter only one argument..");
        } else {
	    double total = 0.0;

	    for (int i = 0; i < panjang; i++) {
                total += Double.valueOf(args[i]).doubleValue();
	    }


	    DecimalFormat myFormatter = new DecimalFormat("###,###.##");
	    String output = myFormatter.format(total);

            System.out.println(output);
        }
    }
}
