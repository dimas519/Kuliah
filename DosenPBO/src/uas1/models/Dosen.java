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
public abstract class Dosen {

    protected String nama;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    
    public abstract String getNomorInduk();

    public abstract void setNomorInduk(String nomorInduk);
}
