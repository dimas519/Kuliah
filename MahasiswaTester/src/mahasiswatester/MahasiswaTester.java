/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package mahasiswatester;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
import java.util.Arrays;
public class MahasiswaTester {

    
    public static void main(String[] args) {
       Scanner sc= new Scanner (System.in);
       int jumlah=sc.nextInt();
        Mahasiswa[] mh=new Mahasiswa[jumlah];
       
       int i=0;
       String nama="";
       double ipk;
       int sks;
       
       while(i<jumlah){
       nama=sc.next();
       ipk=sc.nextDouble();
       sks=sc.nextInt();
       mh[i]=new Mahasiswa(nama,ipk,sks);
     i++;
       }
    Arrays.sort(mh);
    
    i=1;
    
    while(i<=jumlah){
    System.out.print(i+".");
    System.out.println(mh[i-1]);
    i++;
    }
  
}
     
       
       
    }
    

class Mahasiswa implements Comparable<Mahasiswa>{
    private String nama;
    private double ipk;
    private int sks;
    
    
    
public Mahasiswa(String nama,double ipk, int sks){
    this.nama=nama;
    this.ipk=ipk;
    this.sks=sks;
    
}

  public int compareTo(Mahasiswa mhs){
      if(this.ipk>mhs.ipk){
            return 1;
        }else if(this.ipk==mhs.ipk){
            if(this.sks>mhs.sks){
                return 1;
            }else if(this.sks == mhs.sks){
                return 0;
            }else{
                return -1;
            }
        }else{
            return -1;
        }
    }
  public int comparetoSKS(Mahasiswa mhs){
     if(this.sks>mhs.sks){
          return 1;
      } else if(this.ipk<mhs.sks){
          return -1;
      } else {
          return 0;
      }
      
      
      
      
  }
  
   public String toString() {
       String mhs=this.nama+" "+this.ipk+" "+this.sks;
       return mhs;
   }
    
    
}
