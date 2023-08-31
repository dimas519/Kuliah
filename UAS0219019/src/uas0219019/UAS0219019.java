/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas0219019;

/**
 *
 * @author Dimas Kurniawan
 */
public class UAS0219019 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        swap<String > penukaran= new swap<>();    // sebagai contoh kita gunakan String, tidak mesti string namun dapat tipe data apa saja selain primitive
        
        String arrContoh[]={"satu","dua","tiga","empat","Lima"};  // contoh arraynya
        
        
        penukaran.swapingArray(arrContoh, 0, 3);  // array idx ke 0 tukaran dengan idx 3 
        
        for(String j : arrContoh){
            System.out.println(j);
        }
        
        
    }
    
}


class swap<O>{
    
    public void swapingArray(O[] arr, int satu,int dua){
        O temp=arr[satu];
        arr[satu]=arr[dua];
        arr[dua]=temp;
        
        
    }

}
