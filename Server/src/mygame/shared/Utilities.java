/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.shared;

public class Utilities {
    // set DEBUG = false and compile to stop debug messages
    final static boolean DEBUG = true;

    public static void printMsg(String msg) {
	if (DEBUG) {
	    System.out.println(msg);
	}
    }
}
