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
public class NotificationCollection implements Collection 
{ 
    static final int MAX_ITEMS = 6; 
    int numberOfItems = 0; 
    Notification[] notificationList; 
  
    public NotificationCollection() 
    { 
        notificationList = new Notification[MAX_ITEMS]; 
  
        // Let us add some dummy notifications 
        addItem("Notification 1"); 
        addItem("Notification 2"); 
        addItem("Notification 3"); 
    } 
  
    public void addItem(String str) 
    { 
        Notification notification = new Notification(str); 
        if (numberOfItems >= MAX_ITEMS) 
            System.err.println("Full"); 
        else
        { 
            notificationList[numberOfItems] = notification; 
            numberOfItems = numberOfItems + 1; 
        } 
    } 
  
	@Override
    public Iterator createIterator() 
    { 
        return new NotificationIterator(notificationList); 
    } 
} 
