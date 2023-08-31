/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas0419019;

/**
 *
 * @author Dimas Kurniawan
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UAS0419019 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Path path=Paths.get("C:\\Users\\Dimas\\Documents\\NetBeansProjects\\Latihan Pbo\\XANADU.txt");  //
    
    


        System.out.print(readFirstLineFromFile(path.toString()));
    }

    static String readFirstLineFromFile(String path) 
    {
     
        
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }catch(IOException s){
            System.err.println("FIle tidak ditemukan");
            return "";
        } finally{
            // br.close(); tidak diperlukan karena IOException sudah autoCloseAble, dan br sudah didalam parameter try (autoCloseAble);
        }
        
    }



    
}
