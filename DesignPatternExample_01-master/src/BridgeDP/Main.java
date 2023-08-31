/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BridgeDP;

/**
 *
 * @author Erwin
 */
public class Main {
	public static void main(String[]args){
		Vehicle vehicle1 = new Car(new Produce(), new Assemble2()); 
        vehicle1.manufacture(); 
        Vehicle vehicle2 = new Bike(new Produce(), new Assemble()); 
        vehicle2.manufacture(); 
	}
}
