/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concurency;

import java.util.ArrayList;

/**
 *
 * @author Kurni
 */


public class afterUTS {
 	public static int sum=0;
        private static Counter counter=new Counter(1);
	public static void threadSum(int n, String name) throws Exception
	{
		Thread tSum = new Thread() {
			public void run() {
				if (n>0) {
		 			for (int i=1;i<=n;i++){ sum+=i;}
		 		}
                                counter.Write(sum);
				System.out.println("Thread name "+ this.getName() + " with id: "+this.getId());
			}
		};
		tSum.setName(name);
		tSum.start();
	}

	public static void threadPrint(String name) throws Exception
	{
		Thread tPrint = new Thread() {
			public void run()
			{
		 		System.out.println("Thread name "+ this.getName() + " with id: "+this.getId());
                                sum=counter.read();
		 		System.out.println("Jumlah bilangan : "+sum);
			}
		};
		tPrint.setName(name);
		tPrint.start();
	}
	public static void main(String [] args ) throws Exception
	{
		int n;
		n = 750000;
		threadSum(n,"sum");
 		threadPrint("print");
 	}
 }


class Counter{
    private Semaphore semaphore;
    private int buffer[];
    private int start;
    private int end;
    private int size;
    
    
    public Counter(int bufferSize){
    this.buffer=new int[bufferSize];
    this.start=0;
    this.end=0;
    this.semaphore=new Semaphore(1);
    this.size=bufferSize;
    }
    
    public void Write(int value){
       this.semaphore.down();
       buffer[start]=value;
       
       start++;
       start%=this.size;
       
        this.semaphore.up();
       
       
    }
    
    public int read() {
		semaphore.down();
		int value = buffer[end];
		end++;
                end%=this.size;
		
//		System.out.println("Consumer reads: "+readValue);
		semaphore.up();

		return value;
    }
    
    
    
    
    
    
    
    
    
}
