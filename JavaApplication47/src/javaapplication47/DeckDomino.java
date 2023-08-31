/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication47;

/**
 *
 * @author Dimas
 */
public class DeckDomino{
     public static void main (String[] args){
    String[] array= new String[28];
//private static Card3[] cards = new Card3[52];

        int i = 0;
        int j=0;
        String str;

        for (Bintik bintik1 : Bintik.values()) {
             for (Bintik bintik2 : Bintik.values()) {
             if (bintik1 < bintik2){
             System.out.println(str = bintik1 + "-" + bintik2);
             }
            }
        }
    }

    //convert konversi = new convert();
    //String hasil = konversi.convert(i);
    //System.out.println(hasil);
    //Bintik bintik1= Bintik.;



}



class KartuDomino {
    private final Bintik bintik1;
    private final Bintik bintik2;

    public KartuDomino(Bintik bintik1, Bintik bintik2){
        this.bintik1=bintik1;
        this.bintik2=bintik2;
    }

    public Bintik bintik1(){
        return bintik1;
    }

    public Bintik bintik2(){
        return bintik2;
    }

    public String toString(){
        return bintik1+"-"+bintik2;
    }
}

enum Bintik{
    NOL ("0"),
    SATU ("1"),
    DUA ("2"),
    TIGA ("3"),
    EMPAT ("4"),
    LIMA ("5"),
    ENAM ("6");
    private String angka;

    Bintik(String input){
        this.angka=input;
    }

    public String getAngka(){
        return this.angka;
    }
}