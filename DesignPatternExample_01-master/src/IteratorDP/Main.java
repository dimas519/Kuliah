/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IteratorDP;

/**
 *
 * @author Erwin
 */
public class Main {
	public static void main(String[]args){
		NotificationCollection nc = new NotificationCollection(); 
		NotificationBar nb = new NotificationBar(nc); 
		nb.printNotifications(); 
	}
}
