/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kartua
 */
public class Inte implements Comparable<Inte>{
    Integer n;
    public static int count =0;
    
    public Inte(int i){
    n = i;
    }
    public int compareTo(Inte o) {
        count++;
        return this.n.compareTo(o.n);
    }
    public static void resetCount(){
        count =0;
    }

}
