import java.util.Arrays;

public class HeapSort {
	
	
	
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
		HeapSort tester = new HeapSort();
        int test[] = {1,5,7,3,9,2};
        tester.heapSort(test);
        System.out.println(Arrays.toString(test));

	}

}
