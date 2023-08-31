/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concurency;



public class Semaphore {
	private int value;
	
	public Semaphore (int value) 
	{
		this.value = value;
	}
	
	// down()
	public synchronized void down() 
	{
		while (value == 0) {
			try{
				wait();
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		value--;
	}
	
	// up()
	public synchronized void up() 
	{
		value++;
		notifyAll();
	}
}
