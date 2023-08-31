/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.fungsidp;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
public class DAAFungsiDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        fungsi f=new fungsi();
        int banyak=sc.nextInt();
        for(int i=0;i<banyak;i++){
            long res=f.dpFungsi(sc.nextInt(), sc.nextInt(), sc.nextInt());
            System.out.println(res);
        }
        
        
        
    }
    
}


class fungsi{
    long arr[][][];
    
    public fungsi(){
        arr=new long[16][16][16]; //ukuran kelasnya tidak lebih dari 15
    }
    
    public long dpFungsi(int a,int b,int c){ //3 buah input
        if(arr[a][b][c]!=0 ){ //kalau tidak 0 maka sudah pernah disisi
            return arr[a][b][c];
        }else if(a==0){
            return b+1; //kalau di dia a nya 0 auto return b+1
        }else if(b==0){ //sementara  kalau dia b=0
            long value=dpFungsi(a-1,1,c); //lakukan rekursif sampai dia a=0 setelah itu asign dan keluarkan nilai
            arr[a][b][c]=value;
            return value; //keluarkan hasil perhitugnan yg tadi
        }else if(c==0){ //sementara kalau c 0
            long value=dpFungsi(a-1,b-1,1);  //loop sampai dia ketemu yg sudah pernah dihitung atau sampai a==0
            arr[a][b][c]= value;
            return value;
        }else { //jika tidak loop seperti rumus
            long value=dpFungsi(a-1,b,c)+dpFungsi(a,b-1,c)+dpFungsi(a,b,c-1);
           arr[a][b][c]= value;
           return value; //semua if diatas keluarkan berapa vlue hasil hitung
        }
    }

}