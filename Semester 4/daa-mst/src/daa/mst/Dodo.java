/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.mst;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;
class MST {
    int V;
    public MST(int V){
        this.V=V;
    }

    int minKey(int[] value, boolean mstSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE;
        int min_index = -1;
  
        for (int b = 0; b < V; b++){
            if (mstSet[b] == false && value[b] < min) {
                min = value[b];
                min_index = b;
            }
        }
        return min_index;
    }
  
   
    void printMST(int parent[], int graph[][])
    {
        int sum=0;
     
        for (int i = 1; i < V; i++){
            sum=sum+graph[i][parent[i]];}
        System.out.println(sum);
           
    }
  
    void primMST(int graph[][])
    {
       
        int parent[] = new int[V];
  
        
        int key[] = new int[V];
  
        
        boolean mstSet[] = new boolean[V];
  
   
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
  
        
        key[0] = 0; 
        parent[0] = -1;
  
  
        for (int count = 0; count < V - 1; count++) {
            
            int u = minKey(key, mstSet);
  
            mstSet[u] = true;
  
            for (int v = 0; v < V; v++){
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        printMST(parent, graph);
    }}
public class Dodo{  
    public static void main(String[] args)
    {
       
        Scanner sc = new java.util.Scanner (System.in);
        int n = sc.nextInt() ;//variable untuk menyatakan banyaknya rumah 
        int k = sc.nextInt() ; //vatiable yang menyatakan banyaknya terowongan
        int[][] e = new int[n][n]; //array untuk menyimpan edge yang menhubungkan 2 rumah
        for (int i = 0; i < k; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int weight = sc.nextInt();
            e[v1-1][v2-1]=weight;
            e[v2-1][v1-1]=weight;
        }
        MST t = new MST(n);     
        if(n==0){
            System.out.println(0);
        }
        else{
        t.primMST(e);
    }}
}
