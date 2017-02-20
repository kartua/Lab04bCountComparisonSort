
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kartua
 */
public class Driver {

    public static void main(String[] args) {
        int[] list = {3, 8, 12, 34, 54, 84, 91, 110};
        int[] list1 = {90, 8, 7, 56, 123, 235, 9, 1, 653};
        int[] list2 = {1,2,3,4,5,6,7,8,9};//quicksort 31 comparisons.
        Integer[] data = new Integer[list.length];
        int i = 0;
        for (int num : list)
            data[i++] = num;
        //Sorting.selectionSort(data);
        //Sorting.bubbleSort(data);
        Sorting.insertionSort(data);
        //Sorting.quickSort(data);
    }
}
