/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tescoba;

import java.util.Date;

/**
 *
 * @author Dimas Kurniawan
 */
public class Tescoba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Date   d =new Date();
        d.setDate(25);
        d.setMonth(3);
        
        
        System.out.println(d.getDay()); // hari (untuk senin)
        
        System.out.println(d.getDate()); // hari tanggal 
        
        System.out.println(d.getMonth());
        System.out.println(d.getYear());
    }
    
}
