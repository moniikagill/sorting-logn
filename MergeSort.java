import java.util.Arrays;
public class MergeSort {

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
		MergeSort m = new MergeSort();
		int[] numbers = {1,3,2,4};
		//call the method that will sort the numbers
		m.sort(numbers);
		System.out.println(numbers[2]);
	}

}
