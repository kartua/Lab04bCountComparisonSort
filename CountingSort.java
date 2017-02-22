/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kartua
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] list = {3, 8, 12, 34, 54, 84, 91, 110};
        int[] list1 = {90, 8, 7, 56, 123, 235, 9, 1, 653};
        int[] list2 = {1,2,3,4,5,6,7,8,9,0,11};
        int[] list3 = {3,8,12};
        
        Inte[] data = new Inte[list1.length];
        int i = 0;
        for (int num : list1)
            data[i++] = new Inte(num);
        
//        Sorting.selectionSort(data); 
        //Sorting.bubbleSort(data);
        //Sorting.insertionSort(data);
//        Sorting1.quickSort(data);
        Sorting1.mergeSort(data);
        System.out.println(Inte.count);
        
    }
} 
