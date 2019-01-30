import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MergeSort {
 private static final String COMMA_DELIMITER = ",";

//reads the given file and puts in the array
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
	//mergesort sorting method
	public void merge(int input[], int[] leftArray, int[] rightArray, int left, int right) {
		
		//we want to split the input array into half
		//we also need to know length of each half of the array
		
	
		
		int i = 0;
	    int j = 0;//initial indexes of left array and right array
		int k = 0;
		
		while(i< left && j< right) {
			if(leftArray[i]<= rightArray[j]) {
				input[k] = leftArray[i];
				i++;
				
			
			}
			else {
				
				input[k] = rightArray[j];
				j++;
				
			}
			k++;
			
		}
		while(i< left) {
			input[k] = leftArray[i];
			i++;
			k++;
			
		}
		while(j< right) {
			input[k] = rightArray[j];
			j++;
			k++;
		
		}
		
	}
	public void sort(int input[]) {
		int length = input.length;
		if(length<2) {
			return;
		}
		int middle = (input.length)/2;
		int left[] = new int [middle];
		int right[] = new int[input.length-middle];
		
			 for (int i = 0; i < middle; i++) {
			        left[i] = input[i];
			    }
			    for (int i = middle; i < input.length; i++) {
			        right[i - middle] = input[i];
			    }
			    sort(left);
			 
			    sort(right);
			  
			    merge(input, left, right, middle, length-middle);
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("testfile.txt");
		ArrayList<Integer> num = readFile(file);
		int[]numArray = num.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
		//String 
		System.out.println(Arrays.toString(numArray));
		MergeSort m = new MergeSort();
		//int[] numbers = {1,3,2,4};
		//call the method that will sort the numbers
		m.sort(numArray);
	    System.out.println(Arrays.toString(numArray));
	}

}
