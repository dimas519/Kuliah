/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.a03;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
public class DAAA03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int vertex=sc.nextInt();
        disjointSets dj=new disjointSets(vertex);
        int jumlah=sc.nextInt();
        int total=0;
        
        int x[]=new int[jumlah];
        int y[]=new int[jumlah];
        int bobot[]=new int[jumlah];
        for (int z = 0; z <jumlah; z++) {
            x[z]=sc.nextInt();
            y[z]=sc.nextInt();
            bobot[z]=sc.nextInt();
            
        } 
        quickSort1 qs=new quickSort1();
        
        qs.sort(bobot,x,y);
        
        
        for (int z = 0; z <jumlah; z++) {
            int hasil=dj.union(x[z], y[z], bobot[z]);
//            System.out.println(bobot[z]);
            total+=(bobot[z]-hasil);
            
            
        }
        
        
        System.out.println(total);

    }
}

class quickSort1{
    
    private void quickSort(int[] inputArray,int left,int right,int x[],int y[]){
        if(left<right){
            int pivotIndex = lomutoPartition(inputArray,left,right,x,y);
            quickSort(inputArray,left,pivotIndex-1,x,y);
            quickSort(inputArray,pivotIndex+1,right,x,y);
        }
    }
private int lomutoPartition(int[] inputArray,int left, int right,int x[],int y[]){
        int pivot = inputArray[right];
        int i = left-1;
        for(int j=left;j<right;j++){
            if(inputArray[j]<=pivot){
                i = i+1;
                int temp = inputArray[i];
                inputArray[i]=inputArray[j];
                inputArray[j]=temp;
                
                temp=x[i];
                x[i]=x[j];
                x[j]=temp;
                        
                temp=y[i];
                y[i]=y[j];
                y[j]=temp;        
            }
        }
        i++;
        int temp = inputArray[i];
        inputArray[i]=inputArray[right];
        inputArray[right]=temp;
        
        
                temp=x[i];
                x[i]=x[right];
                x[right]=temp;
                        
                temp=y[i];
                y[i]=y[right];
                y[right]=temp;  
        return i;
    }

    public void sort(int[] inputArray,int x[],int y[]){
        quickSort(inputArray,0,inputArray.length-1,x,y);
    }


}


class disjointSets { //class disjoin yang memiliki atribut parents,ranks ,numOfelement
int [] parents; //yang menyimpan siapa parentnya jika dia loop maka dia yg "tertua"
int [] ranks; //ranks menyimpan upperbound dari tinggi"
int numOfElements; //yang menyatakan ada berapa vertex / node

disjointSets(int numOfElements){ // construktor disjoint set dengan path Compresion
    this.numOfElements=numOfElements;
    this.parents=new int[numOfElements];
    this.ranks=new int[numOfElements];
    for(int i=0;i<numOfElements;i++){
        this.parents[i]=i;
        this.ranks[i]=0;
    }
}
    
public int findSets(int element){ // yang akan mengembalikan
    if(parents[element]==element){ // jika sudah diroot ditandai dengan parent dari element maka element itu sendiri maka tandanya sudah tertua
        return element;
    }else {
        parents[element]=parents[parents[element]];//jika belum maka satukan parent-parentnya dengan path compresion
        return findSets(parents[element]); //sekaligus menelusuri orang tuanya dengan cara rekursif satu satu menuju root
    }
}

public int union(int satu, int dua,int bobot){ //lakukan penyatuan antara satu dan dua
        if (satu > dua) {
        int temp=satu;
        satu=dua;
        dua=temp;
    }
    int p1 =findSets(satu); //lakukan penelusuran mencari 'tertua' di satu
    int p2 =findSets(dua); //lakukan penelusuran mencari 'tertua' di dua
    if (p1!=p2){ //jika mereka beda orang tua maka bisa disatukan
            if(ranks[p1]>=ranks[p2]){ //cari rank yang paling sedikit
                parents[p2]=p1; //satukan orang tuanya dengan cara pohon paling sedikit dijadikan anak dari pohon yang banyak
                ranks[p1]++; //tambahkan rank yg banyak dengan 1 karena ketambahan anak 1
            }else{ //begitu pula sebaliknya
                parents[p1]=p2;
                ranks[p2]++;
            }
        //System.out.println("berhasil");
        //System.out.println(Arrays.toString(parents));
        return 0;
    }else{
        return bobot;
//        System.out.println("sama"); //dapat dipergunakan untuk menghitung ada berapa banyak yang membuat loops
    }
 }
}


