/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas1.models;

/**
 *
 * @author Dimas Kurniawan
 */
public class DosenKontrak extends Dosen {
    String NIK;
    
    @Override
    public String getNomorInduk() {
        return this.NIK;
    }

  
    
    public void setNIK(String nomorInduk) {
        this.NIK=nomorInduk;
    }
    
    public void setNomorInduk(String NIDN){
        //tidak ada NIDN Sehingga tidak mengset apa apa
    }

    
    
    
}
