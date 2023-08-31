/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so2;

import java.util.LinkedList;

/**
 *
 * @author Kurni
 */
public class indexing {
    private int awal;
    private int akhir;
    LinkedList<Integer> antrian;
    
    public indexing(){
        this.antrian=new LinkedList();
    }
    
    public void in(int id){
        this.antrian.addLast(id);
    }
    
    public int out(){
        return this.antrian.pollFirst();
    }
    
}
