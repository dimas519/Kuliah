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
public interface Iterator 
{ 
    // indicates whether there are more elements to 
    // iterate over 
    boolean hasNext(); 
  
    // returns the next element 
    Object next(); 
} 
  
