/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.c33;
    import java.util.Scanner;
/**
 *
 * @author Dimas Kurniawan
 */
public class DAAC33 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int jumlah=sc.nextInt();
        
        int xArr[]=new int[jumlah];
        int yArr[]=new int[jumlah];
        
        
        for (int z = 0; z <jumlah ; z++) {
            xArr[z] = sc.nextInt();
            yArr[z]=sc.nextInt();
        }
        
        Graph g=new Graph(jumlah,xArr,yArr);
        
        int jHub=sc.nextInt();
        
        for(int i=0;i<jHub;i++){
            int satu =sc.nextInt();
            int dua=sc.nextInt();
            g.union(satu, dua);
        }
        
//        for(int x:g.parents){
//            System.out.println(x);
//        }
        
        g.process();
        double hasil=g.minTotal;
        System.out.printf("%.3f\n",hasil);
        
    }
    
}

class Graph{
    int size;
    int x[];
    int y[];
    int parents[];
    int ranks[];
    public Graph(int size,int x[],int y[]){
        this.size=size;
        this.x=x;
        this.y=y;
        this.parents=new int[size];
        this.ranks=new int[size];
        
        for(int i=0;i<size;i++){
            parents[i]=i;
            ranks[i]=0;
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
    
public void union(int satu, int dua){ //lakukan penyatuan antara satu dan dua
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

    }else{
//        System.out.println("sama"); //dapat dipergunakan untuk menghitung ada berapa banyak yang membuat loops
    }
 }

public void process(){
    int logic=parents[0];
    
    for(int i=0;i<size;i++){
        if(parents[i]!=logic){
            bruteforce(i);
            
        }
    }


    

    
}

public double jarak(int satu,int dua){
    double xd=Math.pow(Math.abs(x[dua]-x[satu]),2);
    double yd=Math.pow(Math.abs(y[dua]-y[satu]),2);
    double hasil=Math.sqrt(xd+yd);
    return hasil;
}

double minTotal=0;
    public void bruteforce(int beda){
        int parentBeda=parents[beda];
        double minValue=Integer.MAX_VALUE;
        
        for(int x=0;x<size;x++){
            if(parents[x]==0){
                
                for(int i=0;i<size;i++){
                    if(parents[parentBeda]==parents[i]){
                            System.out.println(i);
                            double res=jarak(x,i);
                        
                            if(res<minValue){
//                            System.out.println(res);
                            minValue=res;
                            }
                    }
                }
            }
        }
        
        for(int i=0;i<size;i++){
            if(parents[i]==beda){
                parents[i]=0;
            }
        }
       
       
      this.minTotal+=minValue;
      
}
    
    
    
    
    
    
        
        
        
        
        
        
        
        
 
    
    
    
    
    
    
    
}
