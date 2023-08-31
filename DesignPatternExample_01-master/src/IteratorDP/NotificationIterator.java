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
public class NotificationIterator implements IteratorDP.Iterator{
	Notification[] notificationList; 

	// maintains curr pos of iterator over the array 
	int pos = 0; 

	// Constructor takes the array of notifiactionList are 
	// going to iterate over. 
	public NotificationIterator (Notification[] notificationList) 
	{ 
		this.notificationList = notificationList; 
	} 

	public Object next() 
	{ 
		// return next element in the array and increment pos 
		Notification notification = notificationList[pos]; 
		pos += 1; 
		return notification; 
	} 

	public boolean hasNext() 
	{ 
		if (pos >= notificationList.length || 
			notificationList[pos] == null) 
			return false; 
		else
			return true; 
	}
}
