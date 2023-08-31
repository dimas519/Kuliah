/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberholderdisplay;

/**
 *
 * @author Dimas
 */
public class Utama {
    public static void main(String[] args) {
	NumberHolder aNumberHolder = new NumberHolder();
	aNumberHolder.anInt = 503;
	aNumberHolder.aFloat = 9.43f;
	System.out.println(aNumberHolder.anInt);
	System.out.println(aNumberHolder.aFloat);
    }
}
    
class NumberHolder {
    public int anInt;
    public float aFloat;
}
