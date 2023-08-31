	/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdapterDP;

/**
 *
 * @author Erwin
 */
public class BirdAdapter implements ToyDuck 
{ 
	// You need to implement the interface your 
	// client expects to use. 
	Bird bird; 
	public BirdAdapter(Bird bird) 
	{ 
		// we need reference to the object we 
		// are adapting 
		this.bird = bird; 
	} 

	public void squeak() 
	{ 
		// translate the methods appropriately 
		bird.makeSound(); 
	} 
} 
