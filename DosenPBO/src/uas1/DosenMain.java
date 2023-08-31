/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas1;

import java.util.ArrayList;
import java.util.List;
import uas1.models.DosenTetap;
import uas1.models.DosenKontrak;
import uas1.models.Dosen;

public class DosenMain {

    public static void main(String[] args) {
        List<Dosen> dosens = new ArrayList<>();
        DosenKontrak pascal = new DosenKontrak();
        pascal.setNama("Pascal Alfadian");
        pascal.setNIK("20120010");
        dosens.add(pascal);
        DosenTetap alfadian = new DosenTetap();
        alfadian.setNama("Alfadian Nugroho");
        alfadian.setGelar("M.Comp");
        alfadian.setNomorInduk("0401128402");
        alfadian.setNIDN("0401128402"); // hanya mengulang saja
        dosens.add(alfadian);
        for (Dosen dosen : dosens) {
            System.out.println("Nama: " + dosen.getNama());
            System.out.println("Nomor Induk: " + dosen.getNomorInduk());
            System.out.println("---");
        }
    }
}
