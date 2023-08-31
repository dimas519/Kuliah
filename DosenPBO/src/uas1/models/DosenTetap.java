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
public class DosenTetap extends Dosen {
    String NI;
    String NIDN;
    String Gelar;
    
    public void setGelar(String Gelar){
        this.Gelar=Gelar;
    }
    
    public String getGelar(){
        return this.Gelar;
    }
    
    @Override
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    @Override
    public String getNama() {
        return nama+", "+Gelar;
    }
    
    
    
    
  public void setNIDN(String NIDN){
      this.NIDN=NIDN;
  }
    
  public String getNIDN(){
      return NIDN;
  }

    @Override
    public String getNomorInduk() {
        return this.NI;
    }

  
    @Override
    public void setNomorInduk(String nomorInduk) {
        this.NI=nomorInduk;
    }
    
    
    
    
}
