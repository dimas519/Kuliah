/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas05191019;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dimas Kurniawan
 */
public class UAS05191019 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        
        Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
        for (Path name : dirs) {

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(name,"*.*")) {
               
                
                int i=0;// anggapan untuk file biasa punya jenis data seperti txt, docx, file ,in ,ans, dll sementara jika folder maka tidak ada hanya nama 
                for (Path file : stream) {
                    System.out.println(file.getFileName());
                    System.out.println("===");
                    i++;
                } 
                
                if(i!=0){
                    System.out.println();
                }
                
                }
                
        }

            
            }

        }

    


