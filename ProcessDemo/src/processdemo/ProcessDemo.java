/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processdemo;

/**
 *
 * @author Kurni
 */
public class ProcessDemo
{
    public static void main(String[] args)
    {
        try
        {
            // create a new process
            
            int bawah=3;
            int atas=5;
            int ukuran=atas-bawah+1;
            System.out.println("Creating Process");
            ProcessBuilder builder[]=new ProcessBuilder[ukuran];
            int pos=0;
            for(int i=bawah;i<=atas;i++){
            builder[pos] = new ProcessBuilder("notepad.exe");
            pos++;
            }
            
            pos=0;
            Process arr[]=new Process[ukuran];
            for(ProcessBuilder x: builder){
            arr[pos] = x.start();
            pos++;
            }
            
            // wait 10 seconds
            System.out.println("Waiting");
            Thread.sleep(10000);
            // kill the process
            
            for(Process x: arr){
            x.destroy();
            }
            System.out.println("Process destroyed");
        }
            catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}