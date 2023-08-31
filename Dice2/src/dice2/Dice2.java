/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dice2;

/**
 *
 * @author Dimas
 */
public class Dice2{
    private int kocok;
    private String kembali;
    
    public void getKocok(int kocokan){
        this.kocok=kocokan;
    }
    
    
    
    
    
    
    
    public String setTampilan(){
        switch (kocok){
            case 1:
                kembali="1";
                break;
            case 2:
                kembali="2";
                break;
            case 3:
                kembali="3";
                break;
            case 4:
                kembali="4";
                break;
            case 5:
                kembali="5";
                break;
            case 6:
                kembali="6";
                break;
            
        }
            return kembali;
        }
                
    }