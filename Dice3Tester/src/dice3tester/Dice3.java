/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dice3tester;

/**
 *
 * @author Dimas
 */
public class Dice3{
    private int kocok;
    private String kembali;
    
    public void getKocok(int kocokan){
        this.kocok=kocokan;
    }
    
    
    
    
    
    
    
    public String setTampilan(){
        switch (kocok){
            case 1:
                kembali="SATU";
                break;
            case 2:
                kembali="DUA";
                break;
            case 3:
                kembali="TIGA";
                break;
            case 4:
                kembali="EMPAT";
                break;
            case 5:
                kembali="LIMA";
                break;
            case 6:
                kembali="ENAM";
                break;
            
        }
            return kembali;
        }
         
    enum Spot3{
    SATU ("."),
    DUA (":"),
    TIGA (":."),
    EMPAT ("::"),
    LIMA ("::."),
    ENAM (":::");
    private String angka;

    Spot3 (String input){
        this.angka=input;
    }
    
    
   public String getAngka(){
        return this.angka;
}


}  
    
    }