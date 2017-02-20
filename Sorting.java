
import java.util.Arrays;

/**
 * Sorting demonstrates sorting and searching on an array of objects.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class Sorting {

    private static int sortCount = 0;

    /**
     * Sorts the specified array of integers using the selection sort algorithm.
     *
     * @param data the array to be sorted
     */
    public static <T extends Comparable<T>>
            void selectionSort(T[] data) {
        sortCount = 0;
        long begin = System.currentTimeMillis();
        int min;
        T temp;

        for (int index = 0; index < data.length - 1; index++) {
            min = index;
            for (int scan = index + 1; scan < data.length; scan++) {
                sortCount++;
                if (data[scan].compareTo(data[min]) < 0) {
                    min = scan;
                }
            }

            swap(data, min, index);
        }
        System.out.println("Selectinsort comparison: " + sortCount);
        System.out.println("Running time: "
                + (System.currentTimeMillis() - begin) + "ms\n");

    }

    /**
     * Swaps to elements in an array. Used by various sorting algorithms.
     *
     * @param data the array in which the elements are swapped
     * @param index1 the index of the first element to be swapped
     * @param index2 the index of the second element to be swapped
     */
    private static <T extends Comparable<T>>
            void swap(T[] data, int index1, int index2) {
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    /**
     * Sorts the specified array of objects using an insertion sort algorithm.
     *
     * @param data the array to be sorted
     */
    public static <T extends Comparable<T>>
            void insertionSort(T[] data) {
        long begin = System.currentTimeMillis();
        int passOutter = 0;//track nummber of outter for-loop pass
        int passInner = 0;//track number of inner for-loop pass
        for (int index = 1; index < data.length; index++) {
            T key = data[index];
            int position = index;
            passOutter++;
            // shift larger values to the right
            if (data[position - 1].compareTo(key) > 0) //subtract 1 because it will add 1 inside while loop
            {
                passOutter--;
            }
            while (position > 0 && data[position - 1].compareTo(key) > 0) {
                passInner++;
                data[position] = data[position - 1];
                position--;
            }

            data[position] = key;
        }
        System.out.println("Insertionsort comparison: "
                + (passOutter + passInner));
        System.out.println("Running time: "
                + (System.currentTimeMillis() - begin) + "ms\n");
    }

    /**
     * Sorts the specified array of objects using a bubble sort algorithm.
     *
     * @param data the array to be sorted
     */
    public static <T extends Comparable<T>>
            void bubbleSort(T[] data) {
        long begin = System.currentTimeMillis();
        int position, scan, count = 0;
        T temp;

        for (position = data.length - 1; position >= 0; position--) {
            for (scan = 0; scan <= position - 1; scan++) {
                count++;
                if (data[scan].compareTo(data[scan + 1]) > 0) {
                    swap(data, scan, scan + 1);
                }
            }
        }
        System.out.println("Bubblesort comparison: " + count);
        System.out.println("Running time: "
                + (System.currentTimeMillis() - begin) + "ms\n");
    }

    /**
     * Sorts the specified array of objects using the merge sort algorithm.
     *
     * @param data the array to be sorted
     */
    public static <T extends Comparable<T>>
            void mergeSort(T[] data) {
        sortCount = 0;
        mergeSort(data, 0, data.length - 1);
    }

    /**
     * Recursively sorts a range of objects in the specified array using the
     * merge sort algorithm.
     *
     * @param data the array to be sorted
     * @param min the index of the first element
     * @param max the index of the last element
     */
    private static <T extends Comparable<T>>
            void mergeSort(T[] data, int min, int max) {
        if (min < max) {
            int mid = (min + max) / 2;
            mergeSort(data, min, mid);
            mergeSort(data, mid + 1, max);
            merge(data, min, mid, max);
        }
    }

    /**
     * Merges two sorted subarrays of the specified array.
     *
     * @param data the array to be sorted
     * @param first the beginning index of the first subarray
     * @param mid the ending index fo the first subarray
     * @param last the ending index of the second subarray
     */
    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>>
            void merge(T[] data, int first, int mid, int last) {
        T[] temp = (T[]) (new Comparable[data.length]);

        int first1 = first, last1 = mid;  // endpoints of first subarray
        int first2 = mid + 1, last2 = last;  // endpoints of second subarray
        int index = first1;  // next index open in temp array

        //  Copy smaller item from each subarray into temp until one
        //  of the subarrays is exhausted
        while (first1 <= last1 && first2 <= last2) {
            if (data[first1].compareTo(data[first2]) < 0) {
                temp[index] = data[first1];
                first1++;
            } else {
                temp[index] = data[first2];
                first2++;
            }
            index++;
        }

        //  Copy remaining elements from first subarray, if any
        while (first1 <= last1) {
            temp[index] = data[first1];
            first1++;
            index++;
        }

        //  Copy remaining elements from second subarray, if any
        while (first2 <= last2) {
            temp[index] = data[first2];
            first2++;
            index++;
        }

        //  Copy merged data into original array
        for (index = first; index <= last; index++) {
            data[index] = temp[index];
        }
    }

    /**
     * Sorts the specified array of objects using the quick sort algorithm.
     *
     * @param data the array to be sorted
     */
    public static <T extends Comparable<T>>
            void quickSort(T[] data) {
        long startTime = System.currentTimeMillis();
        sortCount = 0;
        quickSort(data, 0, data.length - 1);
        long excutionTime = System.currentTimeMillis() - startTime;
        System.out.println("Quicksort comparison: " + sortCount);
        System.out.println("Running time: " + excutionTime + "ms");
        
    }

    /**
     * Recursively sorts a range of objects in the specified array using the
     * quick sort algorithm.
     *
     * @param data the array to be sorted
     * @param min the minimum index in the range to be sorted
     * @param max the maximum index in the range to be sorted
     */
    private static <T extends Comparable<T>>
            void quickSort(T[] data, int min, int max) {
        if (min < max) {
            // create partitions
            int indexofpartition = partition(data, min, max);

            // sort the left partition (lower values)
            quickSort(data, min, indexofpartition - 1);

            // sort the right partition (higher values)
            quickSort(data, indexofpartition + 1, max);
        }
    }

    /**
     * Used by the quick sort algorithm to find the partition.
     *
     * @param data the array to be sorted
     * @param min the minimum index in the range to be sorted
     * @param max the maximum index in the range to be sorted
     */
    private static <T extends Comparable<T>>
            int partition(T[] data, int min, int max) {
        T partitionelement;
        int left, right;
        int middle = (min + max) / 2;

        // use the middle data value as the partition element
        partitionelement = data[middle];
        // move it out of the way for now
        swap(data, middle, min);

        left = min;
        right = max;

        while (left < right) {

            
            // search for an element that is > the partition element
            while (left < right && data[left].compareTo(partitionelement) <= 0) {
                left++;
                sortCount++;
            }
            if (left>=right) sortCount--;
            sortCount++;
            // search for an element that is < the partition element
            while (data[right].compareTo(partitionelement) > 0) {
                right--;
                sortCount++;
            }
            sortCount++;
            // swap the elements
            if (left < right) {
                swap(data, left, right);
            }
        }

        // move the partition element into place
        swap(data, min, right);

        return right;
    }

    public static int getSortCount() {
        return sortCount;
    }
}
