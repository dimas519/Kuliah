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
public class NotificationBar {
	NotificationCollection notifications; 

	public NotificationBar(NotificationCollection notifications) 
	{ 
		this.notifications = notifications; 
	} 

	public void printNotifications() 
	{ 
		Iterator iterator = notifications.createIterator(); 
		System.out.println("-------NOTIFICATION BAR------------"); 
		while (iterator.hasNext()) 
		{ 
			Notification n = (Notification)iterator.next(); 
			System.out.println(n.getNotification()); 
		} 
	} 
}
