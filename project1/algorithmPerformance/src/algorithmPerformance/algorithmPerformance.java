package algorithmPerformance;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

public class algorithmPerformance {
	
	
	/**
	 * sorted array and comparison count tracker
	 */
	static class SortResult {
	    int[] sortedArray;
	    long comparisons;

	    SortResult(int[] sortedArray, long comparisons) {
	        this.sortedArray = sortedArray;
	        this.comparisons = comparisons;
	    }
	}

	/**
	 * assists in generating an array of random integers of n size
	 * 
	 * @param n - the requested size of array
	 * @return an array of n size of randomly generated integers
	 */
	public static int[] generateRandomArray(int n) {
		Random rand = new Random(10);
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100);
        }

        return arr;
    }

	/**
	 * Prints all elements of the requested array
	 * 
	 * @param arr - the desired array to be printed
	 */
	public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
	
	
	//MERGE SORT
	public static SortResult mergeSort(int[] arr) {
	    int[] copy = Arrays.copyOf(arr, arr.length);
	    long[] comparisons = {0};

	    mergeSortHelper(copy, comparisons);

	    return new SortResult(copy, comparisons[0]);
	}

	private static void mergeSortHelper(int[] arr, long[] comp) {
	    if (arr.length <= 1) return;

	    int mid = arr.length / 2;
	    int[] left = Arrays.copyOfRange(arr, 0, mid);
	    int[] right = Arrays.copyOfRange(arr, mid, arr.length);

	    mergeSortHelper(left, comp);
	    mergeSortHelper(right, comp);

	    merge(arr, left, right, comp);
	}

	private static void merge(int[] result, int[] left, int[] right, long[] comp) {
	    int i = 0, j = 0, k = 0;

	    while (i < left.length && j < right.length) {
	        comp[0]++; // comparison
	        if (left[i] <= right[j]) {
	            result[k++] = left[i++];
	        } else {
	            result[k++] = right[j++];
	        }
	    }

	    while (i < left.length) result[k++] = left[i++];
	    while (j < right.length) result[k++] = right[j++];
	}
	
	
	//QUICK SORT
	public static SortResult quickSort(int[] arr) {
	    int[] copy = Arrays.copyOf(arr, arr.length);
	    long[] comp = {0};

	    quickSortHelper(copy, 0, copy.length - 1, comp);

	    return new SortResult(copy, comp[0]);
	}

	private static void quickSortHelper(int[] arr, int low, int high, long[] comp) {
	    if (low < high) {
	        int p = partition(arr, low, high, comp);
	        quickSortHelper(arr, low, p - 1, comp);
	        quickSortHelper(arr, p + 1, high, comp);
	    }
	}

	private static int partition(int[] arr, int low, int high, long[] comp) {
	    int pivot = arr[high];
	    int i = low - 1;

	    for (int j = low; j < high; j++) {
	        comp[0]++; // comparison
	        if (arr[j] <= pivot) {
	            i++;

	            int temp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = temp;
	        }
	    }

	 
	    int temp = arr[i + 1];
	    arr[i + 1] = arr[high];
	    arr[high] = temp;

	    return i + 1;
	}
	
	//HEAP SORT 
	public static SortResult heapSort(int[] arr) {
	    int[] copy = Arrays.copyOf(arr, arr.length);
	    long[] comp = {0};

	    int n = copy.length;

	    for (int i = n / 2 - 1; i >= 0; i--) {
	        heapify(copy, n, i, comp);
	    }

	    for (int i = n - 1; i > 0; i--) {
	        int temp = copy[0];
	        copy[0] = copy[i];
	        copy[i] = temp;

	        heapify(copy, i, 0, comp);
	    }

	    return new SortResult(copy, comp[0]);
	}

	private static void heapify(int[] arr, int n, int i, long[] comp) {
	    int largest = i;
	    int left = 2 * i + 1;
	    int right = 2 * i + 2;

	    if (left < n) {
	        comp[0]++;
	        if (arr[left] > arr[largest]) largest = left;
	    }

	    if (right < n) {
	        comp[0]++;
	        if (arr[right] > arr[largest]) largest = right;
	    }

	    if (largest != i) {
	        int swap = arr[i];
	        arr[i] = arr[largest];
	        arr[largest] = swap;

	        heapify(arr, n, largest, comp);
	    }
	}
	
	//SHAKER SORT 
	public static SortResult shakerSort(int[] arr) {
	    int[] copy = Arrays.copyOf(arr, arr.length);
	    long[] comp = {0};

	    boolean swapped = true;
	    int start = 0;
	    int end = copy.length - 1;

	    while (swapped) {
	        swapped = false;

	        for (int i = start; i < end; i++) {
	            comp[0]++;
	            if (copy[i] > copy[i + 1]) {
	                int temp = copy[i];
	                copy[i] = copy[i + 1];
	                copy[i + 1] = temp;
	                swapped = true;
	            }
	        }

	        if (!swapped) break;

	        swapped = false;
	        end--;

	        for (int i = end - 1; i >= start; i--) {
	            comp[0]++;
	            if (copy[i] > copy[i + 1]) {
	                int temp = copy[i];
	                copy[i] = copy[i + 1];
	                copy[i + 1] = temp;
	                swapped = true;
	            }
	        }

	        start++;
	    }

	    return new SortResult(copy, comp[0]);
	}
	
	
	/**
	 * create table to store and display results 
	 */
	static class TableRow {
	    int n;
	    long merge;
	    long quick;
	    long heap;
	    long shaker;

	    TableRow(int n, long merge, long quick, long heap, long shaker) {
	        this.n = n;
	        this.merge = merge;
	        this.quick = quick;
	        this.heap = heap;
	        this.shaker = shaker;
	    }
	}
	
	
	/**
	 * Main method, going to use to call other functions/methods to complete the goal of the project 
	 * in testing the effectiveness of different sorting algorithms
	 * @param args
	 */
	public static void main(String[] args) {

	    int[] sizes = {4, 6, 8, 25, 50};

	    ArrayList<TableRow> table = new ArrayList<>();
	    
	    
	    for (int size : sizes) {

	        int[] original = generateRandomArray(size);

	        System.out.println("\n==============================");
	        System.out.println("INPUT SIZE (n): " + size);
	        System.out.print("Original Array: ");
	        printArray(original);
	        System.out.println("==============================");

	        // ================= MERGE SORT =================
	        SortResult merge = mergeSort(Arrays.copyOf(original, original.length));
	        System.out.println("\n--- Merge Sort ---");
	        System.out.print("Sorted Output: ");
	        printArray(merge.sortedArray);
	        System.out.println("n = " + size);
	        System.out.println("Comparisons = " + merge.comparisons);

	        // ================= QUICK SORT =================
	        SortResult quick = quickSort(Arrays.copyOf(original, original.length));
	        System.out.println("\n--- Quick Sort ---");
	        System.out.print("Sorted Output: ");
	        printArray(quick.sortedArray);
	        System.out.println("n = " + size);
	        System.out.println("Comparisons = " + quick.comparisons);

	        // ================= HEAP SORT =================
	        SortResult heap = heapSort(Arrays.copyOf(original, original.length));
	        System.out.println("\n--- Heap Sort ---");
	        System.out.print("Sorted Output: ");
	        printArray(heap.sortedArray);
	        System.out.println("n = " + size);
	        System.out.println("Comparisons = " + heap.comparisons);

	        // ================= SHAKER SORT =================
	        SortResult shaker = shakerSort(Arrays.copyOf(original, original.length));
	        System.out.println("\n--- Shaker Sort ---");
	        System.out.print("Sorted Output: ");
	        printArray(shaker.sortedArray);
	        System.out.println("n = " + size);
	        System.out.println("Comparisons = " + shaker.comparisons);

	        System.out.println("\n==============================\n");
	        
	        table.add(new TableRow(
	                size,
	                merge.comparisons,
	                quick.comparisons,
	                heap.comparisons,
	                shaker.comparisons
	        ));
	        
	    }
	    
	    printResultsTable(table);
	}
	
	public static void printResultsTable(ArrayList<TableRow> table) {

	    System.out.println("\n================ RESULTS TABLE ================");

	    System.out.printf("%-6s %-12s %-12s %-12s %-12s\n",
	            "n", "Merge", "Quick", "Heap", "Shaker");

	    for (TableRow row : table) {
	        System.out.printf("%-6d %-12d %-12d %-12d %-12d\n",
	                row.n,
	                row.merge,
	                row.quick,
	                row.heap,
	                row.shaker);
	    }

	    System.out.println("===============================================");
	}
}

