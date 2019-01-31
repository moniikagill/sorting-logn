import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimSort {
	private static final String COMMA_DELIMITER = ",";
	public static ArrayList<Integer> readFile(File file) {
		List<Integer>records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(COMMA_DELIMITER);
		     //  records.add(Arrays.asList(values));
		       for(String s: values) {
		    	   int z = Integer.parseInt(s);
		        records.add(z);
		        
		        }
		    }
		 
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		return (ArrayList<Integer>) records;
	
		}
	public static int RUN = 32;
	public static void insertionSort(int arr[], int left, int right) 
	{ 
	    for (int i = left + 1; i <= right; i++) 
	    { 
	        int temp = arr[i]; 
	        int j = i - 1; 
	        while (arr[j] > temp && j > left) 
	        { 
	            arr[j+1] = arr[j]; 
	            j--; 
	        } 
	        arr[j+1] = temp; 
	    } 
	} 
	public static void merge(int arr[], int l, int m, int r) 
	{ 
	    // original array is broken in two parts 
	    // left and right array 
	    int len1 = m - l + 1, len2 = r - m; 
	    int left[] = new int [len1];
	    int right[] = new int [len2]; 
	    for (int i = 0; i < len1; i++) 
	        left[i] = arr[l + i]; 
	    for (int i = 0; i < len2; i++) 
	        right[i] = arr[m + 1 + i]; 
	  
	    int i = 0; 
	    int j = 0; 
	    int k = l; 
	  
	    // after comparing, we merge those two array 
	    // in larger sub array 
	    while (i < len1 && j < len2) 
	    { 
	        if (left[i] <= right[j]) 
	        { 
	            arr[k] = left[i]; 
	            i++; 
	        } 
	        else
	        { 
	            arr[k] = right[j]; 
	            j++; 
	        } 
	        k++; 
	    } 
	  
	    // copy remaining elements of left, if any 
	    while (i < len1) 
	    { 
	        arr[k] = left[i]; 
	        k++; 
	        i++; 
	    } 
	  
	    // copy remaining element of right, if any 
	    while (j < len2) 
	    { 
	        arr[k] = right[j]; 
	        k++; 
	        j++; 
	    } 
	} 
	public static void timSort(int arr[], int n) 
	{ 
	    // Sort individual subarrays of size RUN 
	    for (int i = 0; i < n; i+=RUN) 
	        insertionSort(arr, i, Math.min((i+31), (n-1))); 
	  
	    // start merging from size RUN (or 32). It will merge 
	    // to form size 64, then 128, 256 and so on .... 
	    for (int size = RUN; size < n; size = 2*size) 
	    { 
	        // pick starting point of left sub array. we are going to merge arr[left..left+size-1] 
	        // and arr[left+size, left+2*size-1] 
	        // After every merge, we increase left by 2*size 
	        for (int left = 0; left < n; left += 2*size) 
	        { 
	            // find ending point of left sub array 
	            // mid+1 is starting point of right sub array 
	            int mid = left + size - 1; 
	            int right = Math.min((left + 2*size - 1), (n-1)); 
	  
	            // merge sub array arr[left.....mid] & 
	            // arr[mid+1....right] 
	            merge(arr, left, mid, right); 
	        } 
	    } 
	} 
	
	
	//If the list is larger than 64 elements than the algorithm will make a first pass through 
	//the list looking for parts that are strictly increasing or decreasing. 
	//merge_compute_minrun()  calculating min run

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("testfile.txt");
		ArrayList<Integer> num = readFile(file);
		int[]numArray = num.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
		// int arr[] = {10, 22, 9, 23, 19}; 
		    int n = numArray.length; 
		   System.out.println(n);
		   timSort(numArray, n); 
		   System.out.println(Arrays.toString(numArray));

	}

}
