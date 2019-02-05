import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapSort {
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
	public static void writeFile(int []input) throws IOException {
		   
	    String file = "heapSortSorted";
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		//for(String)
		String strArray[] = Arrays.stream(input)
				.mapToObj(String::valueOf)
				.toArray(String[]::new);
		for(int i = 0;i<strArray.length;i++) {
			writer.write(strArray[i]);
			if(strArray[i]!=strArray[strArray.length-1]) {
				writer.write(",");	
			}
	
		}
		
	     
	    writer.close();
	}

	
	//method to build  max-heap 
     public static void buildheap(int []numberArray) {
	      
		    for(int index =(numberArray.length-1)/2; index>=0; index--){
		     heapify(numberArray,index,numberArray.length-1);
		      }
		   }
	
	 private static void heapify(int[] arr, int i, int size) {
		// TODO Auto-generated method stub
		int left = 2*i+1;
	      int right = 2*i+2;
	      int max;
	      if(left <= size && arr[left] > arr[i]){
	       max=left;
	      } else {
	       max=i;
	      }
	 
	      if(right <= size && arr[right] > arr[max]) {
	       max=right;
	      }
	      // If max is not current node, exchange it with max of left and right child
	      if(max!=i) {
	         exchange(arr,i, max);
	         heapify(arr, max,size);
	      }
		
	}
	//method for exchanging the first index with second index
	private static void exchange(int[] numberArray, int index, int max) {
		// TODO Auto-generated method stub
		//always swap whats in index with the max
		int temp = numberArray[index];
        numberArray[index] = numberArray[max];
        numberArray[max] = temp; 
		
	}
	 public static int[] heapSort(int[] numberArray) {
	     
	      buildheap(numberArray); //builds max heap
	      int sizeOfHeap=numberArray.length-1;//reduces the size of the array leaving the largest element out as we already know that thats the largest
	      for(int i=sizeOfHeap; i>0; i--) {
	         exchange(numberArray,0, i);//always swaps the last elemnt with the root indexed at 0 
	         sizeOfHeap=sizeOfHeap-1;
	         heapify(numberArray, 0,sizeOfHeap); //to retain the max heap property after the swap occurs
	      }
	      return numberArray;
	   }
	 


	

	public static void main(String[] args) {
		//HeapSort tester = new HeapSort();
		File file = new File("testallsortsUnsorted.txt");
		ArrayList<Integer> num = readFile(file);
		int[] numArray = num.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
        //int test[] = {1,5,7,3,9,2};
		long startTime = System.currentTimeMillis();
        heapSort(numArray);
        long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime); 
		System.out.println("time taken to sort:"+duration);
        System.out.println(Arrays.toString(numArray));
        try {
			writeFile(numArray);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
