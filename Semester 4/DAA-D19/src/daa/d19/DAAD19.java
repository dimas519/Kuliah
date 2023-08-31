/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.d19;

/**
 *
 * @author Dimas Kurniawan
 */

import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedHashMap;
public class DAAD19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
        while (sc.hasNextInt()){
            int number=sc.nextInt();
            if(map.get(number)==null){
                map.put(number,1);
            }else {
                map.put(number,map.get(number)+1);
            }
        }

        for (int i : map.keySet()){
            System.out.println(i+" "+map.get(i));
        }
    }
}
